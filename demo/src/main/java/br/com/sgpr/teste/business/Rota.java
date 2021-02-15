package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rotas")
public class Rota {
    private String id_rota;
    private String nome;
    private String origem;
    private String destino;

    @Id
    @Column(name = "id_rota")
    public String getIdRota(){
        return id_rota;
    }

    @Column(name = "id_rota")
    public void setIdRota(String novoId){
        id_rota = novoId;
    }

    @Column(name = "nome_rota")
    public String getNome(){
        return nome;
    }

    @Column(name = "nome_rota")
    public void setNome(String novoNome){
        nome = novoNome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
}
