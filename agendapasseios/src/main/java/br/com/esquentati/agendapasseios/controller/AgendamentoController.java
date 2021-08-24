package br.com.esquentati.agendapasseios.controller;

import br.com.esquentati.agendapasseios.dto.AgendamentoRequest;
import br.com.esquentati.agendapasseios.dto.AgendamentoResponse;
import br.com.esquentati.agendapasseios.client.TuristaResponse;
import br.com.esquentati.agendapasseios.client.TuristasJpClient;
import br.com.esquentati.agendapasseios.model.Agendamento;
import br.com.esquentati.agendapasseios.repository.AgendamentoRepository;
import feign.FeignException.FeignClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    @Autowired
    TuristasJpClient turistasJpClient;

    @Autowired
    AgendamentoRepository agendamentoRepository;

    @PostMapping
    public ResponseEntity<?> agenda(@RequestBody AgendamentoRequest agendamentoRequest) {
        try {
            TuristaResponse turista = turistasJpClient.buscarTurista(agendamentoRequest.getCpf());
            Agendamento novoAgendamento = agendamentoRequest.paraAgendamento(turista);
            agendamentoRepository.save(novoAgendamento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Agendamento criado");
        } catch (FeignClientException e) {
            if (e.status() == 404) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Turista não encontrado");
            }
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao criar agendamento");
        }
    }

    @GetMapping
    public ResponseEntity<?> listaAgendamentos() {
        List<Agendamento> agendamentos = agendamentoRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK)
                .body(agendamentos.stream().map(AgendamentoResponse::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscaAgendamento(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(new AgendamentoResponse(agendamento.get()));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado");
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizaAgendamento(@PathVariable Long id, @RequestBody AgendamentoRequest agendamentoRequest) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            agendamento.get().atualizaData(agendamentoRequest.getDataDoPasseio());
            agendamentoRepository.save(agendamento.get());
            return ResponseEntity.status(HttpStatus.OK).body("Agendamento atualizado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> cancelarAgendamento(@PathVariable Long id) {
        Optional<Agendamento> agendamento = agendamentoRepository.findById(id);
        if (agendamento.isPresent()) {
            agendamentoRepository.delete(agendamento.get());
            return ResponseEntity.status(HttpStatus.OK).body("Agendamento cancelado");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Agendamento não encontrado");
    }
}
