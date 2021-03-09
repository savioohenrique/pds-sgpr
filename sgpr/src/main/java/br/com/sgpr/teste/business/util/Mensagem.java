package br.com.sgpr.teste.business.util;

import java.util.ArrayList;

public class Mensagem {
    private String status;
    private ArrayList<String> Erros;

    public Mensagem(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getErros() {
        return Erros;
    }

    public void setErros(ArrayList<String> erros) {
        Erros = erros;
    }
    
    
}
