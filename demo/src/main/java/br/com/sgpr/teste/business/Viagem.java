package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="viagem")
public class Viagem {
    private int id;
    private String data;
    private String hora_saida;
    private float preco;
    private String rota;
    private String motorista;
    private String onibus;
    private String status;
    private String empresa;
    private int asssentosDisponiveis;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_viagem")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Column(name="data_viagem")
    public String getData(){
        return data;
    }

    @Column(name="data_viagem")
    public void setData(String novaData){
        data = novaData;
    }

    @Column(name="hora_saida")
    public String getHoraSaida(){
        return hora_saida;
    }

    @Column(name="hora_saida")
    public void setHoraSaida(String novaHoraSaida){
        hora_saida = novaHoraSaida;
    }

    public float getPreco(){
        return preco;
    }

    public void setPreco(float novoPreco){
        preco = novoPreco;
    }

    public String getRota(){
        return rota;
    }

    public void setRota(String novaRota){
        rota = novaRota;
    }

    public String getMotorista(){
        return motorista;
    }

    public void setMotorista(String novaMotorista){
        motorista= novaMotorista;
    }

    public String getOnibus(){
        return onibus;
    }

    public void setOnibus(String novaOnibus){
        onibus = novaOnibus;
    }

    @Column(name="status_saida")
    public String getStatus(){
        return status;
    }

    @Column(name="status_saida")
    public void setStatus(String novoStatus){
        status = novoStatus;
    }

    public String getEmpresa(){
        return empresa;
    }

    public void setEmpresa(String novaEmpresa){
        empresa = novaEmpresa;
    }

    @Column(name = "assentos_disponiveis")
    public int getAsssentosDisponiveis() {
        return asssentosDisponiveis;
    }

    public void setAsssentosDisponiveis(int asssentosDisponiveis) {
        this.asssentosDisponiveis = asssentosDisponiveis;
    }
}

