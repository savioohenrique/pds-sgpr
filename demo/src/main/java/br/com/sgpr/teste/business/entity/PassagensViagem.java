package br.com.sgpr.teste.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PassagensViagem {
    private String codValidacao;
    private String viagem;
    private int numAssento;
    private String cpf;
    private String nome;

    @Id
    @Column(name = "cod_validacao")
    public String getCodValidacao(){
        return codValidacao;
    }

    @Column(name = "cod_validacao")
    public void setCodValidacao(String novoCodValidacao){
        codValidacao = novoCodValidacao;
    }


    public String getViagem() {
        return viagem;
    }

    public void setViagem(String viagem) {
        this.viagem = viagem;
    }

    @Column(name = "num_assento")
    public int getNumAssento() {
        return numAssento;
    }

    @Column(name = "num_assento")
    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
