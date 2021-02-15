package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rota_cidades")
public class RotaCidades{
    private String id_rota;
    private String nome;
    private int num_seq;

    @Column(name = "id_rota")
    public String getId_rota() {
        return id_rota;
    }

    @Column(name = "id_rota")
    public void setId_rota(String id_rota) {
        this.id_rota = id_rota;
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
        return num_seq;
    }

    @Column(name = "num_seq")
    public void setNumSeq(int num_seq) {
        this.num_seq = num_seq;
    }
    
}
