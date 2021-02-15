package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rota_cidades")
public class RotaCidade {
    private String id_rota;
    private int id_cidade;
    private int num_seq;

    @Id
    @Column(name = "id_rota")
    public String getId_rota() {
        return id_rota;
    }

    @Column(name = "id_rota")
    public void setId_rota(String id_rota) {
        this.id_rota = id_rota;
    }

    @Column(name = "id_cidade")
    public int getIdCidade() {
        return id_cidade;
    }

    @Column(name = "id_cidade")
    public void setIdCidade(int id_cidade) {
        this.id_cidade = id_cidade;
    }

    @Column(name = "num_seq")
    public int getNumSeq() {
        return num_seq;
    }

    @Column(name = "num_seq")
    public void setNumSeq(int num_seq) {
        this.num_seq = num_seq;
    }
    
}
