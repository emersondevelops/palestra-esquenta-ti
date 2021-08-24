package br.com.esquentati.turistasjp.controller;

import br.com.esquentati.turistasjp.client.EnderecoResponse;
import br.com.esquentati.turistasjp.client.ViaCepClient;
import br.com.esquentati.turistasjp.dto.TuristaRequest;
import br.com.esquentati.turistasjp.dto.TuristaResponse;
import br.com.esquentati.turistasjp.model.Turista;
import br.com.esquentati.turistasjp.repository.TuristaRepository;
import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/turista")
public class TuristaController {

    @Autowired
    TuristaRepository turistaRepository;

    @Autowired
    ViaCepClient viaCepClient;

    @PostMapping
    public ResponseEntity<?> cadastra(@RequestBody TuristaRequest turistaRequest, UriComponentsBuilder uriComponentsBuilder) {
        try {
            EnderecoResponse enderecoResponse = viaCepClient.obterEndereco(turistaRequest.getCep());
            Turista novoTurista = turistaRequest.paraTurista(enderecoResponse);
            Turista turista = turistaRepository.save(novoTurista);
            URI uri = uriComponentsBuilder.path("/turista/{id}").build(turista.getId());
            return ResponseEntity.created(uri).build();
        } catch (FeignClientException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("CEP inválido");
        }
    }

    @GetMapping
    public ResponseEntity<?> busca(@RequestParam("cpf") String cpf) {
        Optional<Turista> turista = turistaRepository.findByCpf(cpf);
        if (turista.isPresent()) {
            TuristaResponse turistaResponse = new TuristaResponse(turista.get());
            return ResponseEntity.status(HttpStatus.OK).body(turistaResponse);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turista não encontrado");
    }
}
