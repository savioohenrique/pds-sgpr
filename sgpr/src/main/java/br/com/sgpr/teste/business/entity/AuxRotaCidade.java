package br.com.sgpr.teste.business.entity;

import java.util.ArrayList;

public class AuxRotaCidade {
    private String rotaId;
    private ArrayList<VisaoRotaCidade> cidades;

    public String getRotaId() {
        return rotaId;
    }

    public void setRotaId(String rotaId) {
        this.rotaId = rotaId;
    }

    public ArrayList<VisaoRotaCidade> getCidades() {
        return cidades;
    }

    public void setCidades(ArrayList<VisaoRotaCidade> cidades) {
        this.cidades = cidades;
    }
}
