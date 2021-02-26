package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rota_cidades")
public class RotaCidades {
    private String idRota;
    private int id_cidade;
    private int numSeq;

    public RotaCidades() {};

    public RotaCidades(String id, int idCidade, int numSeq) {
        this.idRota = id;
        this.id_cidade = idCidade;
        this.numSeq = numSeq;
    };

    @Id    
    @Column(name = "id_rota")
    public String getIdRota() {
        return idRota;
    }

    @Column(name = "id_rota")
    public void setIdRota(String id_rota) {
        this.idRota = id_rota;
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
        return numSeq;
    }

    @Column(name = "num_seq")
    public void setNumSeq(int numSeq) {
        this.numSeq = numSeq;
    }
    
}
