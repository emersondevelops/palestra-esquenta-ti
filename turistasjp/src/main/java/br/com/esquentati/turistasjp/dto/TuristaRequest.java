package br.com.esquentati.turistasjp.dto;

import br.com.esquentati.turistasjp.client.EnderecoResponse;
import br.com.esquentati.turistasjp.model.Turista;

public class TuristaRequest {

    private String nome;
    private String cpf;
    private String telefone;
    private String cep;
    private String numero;
    private String complemento;

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getCep() {
        return cep;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public Turista paraTurista(EnderecoResponse enderecoResponse) {
        return new Turista(
                this.nome,
                this.cpf,
                this.telefone,
                this.cep,
                this.numero,
                this.complemento,
                enderecoResponse.getLogradouro(),
                enderecoResponse.getBairro(),
                enderecoResponse.getLocalidade(),
                enderecoResponse.getUf()
        );
    }
}
