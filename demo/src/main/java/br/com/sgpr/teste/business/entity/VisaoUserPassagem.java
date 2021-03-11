package br.com.sgpr.teste.business.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passagensUser")
public class VisaoUserPassagem {
    private int id;
    private String cpf;
    private String data;
    private String rota;
    private String onibus;
    private String horaSaida;
    private String assento;
    private String status;

    @Id
    @Column(name = "id_viagem")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  

    @Column(name = "cpf_dono")
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Column(name = "data_viagem")
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRota() {
        return rota;
    }

    public void setRota(String rota) {
        this.rota = rota;
    }

    public String getOnibus() {
        return onibus;
    }

    public void setOnibus(String onibus) {
        this.onibus = onibus;
    }

    @Column(name = "hora_saida")
    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;
    }

    @Column(name = "num_assento")
    public String getAssento() {
        return assento;
    }

    public void setAssento(String assento) {
        this.assento = assento;
    }

    @Column(name = "status_saida")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }  
}
