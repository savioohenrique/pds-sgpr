package br.com.sgpr.teste.business;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cidades")
public class Cidade {
    private int id;
    private String nome;

    @Id
    @Column(name = "id_cidade")
    public int getId() {
        return id;
    }

    @Column(name = "id_cidade")
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    
}
