package br.com.esquentati.agendapasseios.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    @Enumerated(EnumType.STRING)
    private TipoDePasseioEnum tipoDePasseio;
    private LocalDate dataDoPasseio;
    private LocalDateTime dataHoraDoAgendamento;

    public Agendamento() {
    }

    public Agendamento(String nome, String telefone, TipoDePasseioEnum tipoDePasseio, LocalDate dataDoPasseio) {
        this.nome = nome;
        this.telefone = telefone;
        this.tipoDePasseio = tipoDePasseio;
        this.dataDoPasseio = dataDoPasseio;
        this.dataHoraDoAgendamento = LocalDateTime.now();
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

    public void atualizaData(LocalDate dataDoPasseio) {
        this.dataDoPasseio = dataDoPasseio;
    }
}
