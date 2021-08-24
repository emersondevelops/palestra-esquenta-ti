package br.com.esquentati.turistasjp.dto;

import br.com.esquentati.turistasjp.model.Turista;

public class TuristaResponse {

    private String nome;
    private String telefone;

    public TuristaResponse(Turista turista) {
        this.nome = turista.getNome();
        this.telefone = turista.getTelefone();
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
