package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rota_cidades")
public class VisaoRotaCidade{
    private String idRota;
    private String nome;
    private int numSeq;

    @Column(name = "id_rota")
    public String getIdRota() {
        return idRota;
    }

    @Column(name = "id_rota")
    public void setIdRota(String id_rota) {
        this.idRota = id_rota;
    }

    @Column(name = "nome_cidade")
    public String getNomeCidade() {
        return nome;
    }

    @Column(name = "nome_cidade")
    public void setNomeCidade(String NomeCidade) {
        this.nome = NomeCidade;
    }

    @Id
    @Column(name = "num_seq")
    public int getNumSeq() {
        return numSeq;
    }

    @Column(name = "num_seq")
    public void setNumSeq(int num_seq) {
        this.numSeq = num_seq;
    }
    
}
