package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "rota")
public class Rota {
    private String IdRota;
    private String nome;
    private int origem;
    private int destino;
    private String nomeOrigem;
    private String nomeDestino;

    @Id
    @Column(name = "id_rota")
    public String getIdRota() {
        return IdRota;
    }

    @Column(name = "id_rota")
    public void setIdRota(String idRota) {
        IdRota = idRota;
    }

    @Column(name = "nome_rota")
    public String getNome() {
        return nome;
    }

    @Column(name = "nome_rota")
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getOrigem() {
        return origem;
    }

    public void setOrigem(int origem) {
        this.origem = origem;
    }

    public int getDestino() {
        return destino;
    }

    public void setDestino(int destino) {
        this.destino = destino;
    }
    
    //teste
    @Transient 
    public String getNomeOrigem() {
        return nomeOrigem;
    }

    public void setNomeOrigem(String origem) {
        this.nomeOrigem = origem;
    }

    @Transient
    public String getNomeDestino() {
        return nomeDestino;
    }

    public void setNomeDestino(String destino) {
        this.nomeDestino = destino;
    }
}
