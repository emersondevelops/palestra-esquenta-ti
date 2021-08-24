package br.com.esquentati.agendapasseios.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "turistasjp", url = "http://localhost:8081")
public interface TuristasJpClient {

    @GetMapping("/turista")
    TuristaResponse buscarTurista(@RequestParam("cpf") String cpf);

}
