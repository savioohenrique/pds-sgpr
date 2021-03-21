package br.com.sgpr.teste.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passagem")
public class Passagem {
	@Id
    @Column(name = "cod_validacao")
    private String codValidacao;
	
	@Column(name="viagem")
    private int viagem;
	
    @Column(name = "num_assento")
    private int numAssento;
    
    @Column(name="cpf_dono")
    private String cpf;
    
    
    public String getCodValidacao(){
        return codValidacao;
    }

    public void setCodValidacao(String novoCodValidacao){
        codValidacao = novoCodValidacao;
    }

    public int getViagem() {
        return viagem;
    }

    public void setViagem(int viagem) {
        this.viagem = viagem;
    }

    public int getNumAssento() {
        return numAssento;
    }

    public void setNumAssento(int numAssento) {
        this.numAssento = numAssento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
