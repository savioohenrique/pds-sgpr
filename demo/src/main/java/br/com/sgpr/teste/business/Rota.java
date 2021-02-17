package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rotas")
public class Rota {
    private String idRota;
    private String nome;

    @Id
    @Column(name = "id_rota")
    public String getIdRota(){
        return idRota;
    }

    @Column(name = "id_rota")
    public void setIdRota(String novoId){
        idRota = novoId;
    }

    @Column(name = "nome_rota")
    public String getNome(){
        return nome;
    }

    @Column(name = "nome_rota")
    public void setNome(String novoNome){
        nome = novoNome;
    }
}
