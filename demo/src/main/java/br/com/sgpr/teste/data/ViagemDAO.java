package br.com.sgpr.teste.data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="viagem")
public class ViagemDAO {
    private String data;
    private String hora_saida;
    private String rota;
    private String motorista;
    private String onibus;

    public ViagemDAO(){}

    @Id
    public String getData(){
        return data;
    }

    public void setData(String novaData){
        data = novaData;
    }

    public String getHoraSaida(){
        return hora_saida;
    }

    public void setHoraSaida(String novaHoraSaida){
        hora_saida = novaHoraSaida;
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
}
