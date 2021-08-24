package br.com.esquentati.agendapasseios.dto;

import br.com.esquentati.agendapasseios.model.Agendamento;
import br.com.esquentati.agendapasseios.model.TipoDePasseioEnum;
import br.com.esquentati.agendapasseios.client.TuristaResponse;

import java.time.LocalDate;

public class AgendamentoRequest {

    private String cpf;
    private TipoDePasseioEnum tipoDePasseio;
    private LocalDate dataDoPasseio;

    public String getCpf() {
        return cpf;
    }

    public TipoDePasseioEnum getTipoDePasseio() {
        return tipoDePasseio;
    }

    public LocalDate getDataDoPasseio() {
        return dataDoPasseio;
    }

    public Agendamento paraAgendamento(TuristaResponse turista) {
        return new Agendamento(turista.getNome(), turista.getTelefone(), this.tipoDePasseio, this.dataDoPasseio);
    }
}
