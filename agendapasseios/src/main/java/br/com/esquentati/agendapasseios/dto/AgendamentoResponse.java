package br.com.esquentati.agendapasseios.dto;

import br.com.esquentati.agendapasseios.model.Agendamento;
import br.com.esquentati.agendapasseios.model.TipoDePasseioEnum;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AgendamentoResponse {

    private Long id;
    private String nome;
    private String telefone;
    private TipoDePasseioEnum tipoDePasseio;
    private LocalDate dataDoPasseio;
    private LocalDateTime dataHoraDoAgendamento;

    public AgendamentoResponse(Agendamento agendamento) {
        this.id = agendamento.getId();
        this.nome = agendamento.getNome();
        this.telefone = agendamento.getTelefone();
        this.tipoDePasseio = agendamento.getTipoDePasseio();
        this.dataDoPasseio = agendamento.getDataDoPasseio();
        this.dataHoraDoAgendamento = agendamento.getDataHoraDoAgendamento();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public TipoDePasseioEnum getTipoDePasseio() {
        return tipoDePasseio;
    }

    public LocalDate getDataDoPasseio() {
        return dataDoPasseio;
    }

    public LocalDateTime getDataHoraDoAgendamento() {
        return dataHoraDoAgendamento;
    }
}
