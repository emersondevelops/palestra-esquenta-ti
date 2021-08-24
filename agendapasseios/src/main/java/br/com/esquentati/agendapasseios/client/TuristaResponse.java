package br.com.esquentati.agendapasseios.client;

public class TuristaResponse {

    private String nome;
    private String telefone;

    public TuristaResponse(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }
}
