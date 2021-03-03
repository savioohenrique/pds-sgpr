package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.Cidade;

public interface CidadeRepository extends CrudRepository<Cidade, Integer>{
    @Query(value = "select * from cidades where nome = :nomeCidade", nativeQuery = true)
    public Cidade getCidadeByName(String nomeCidade);

    @Query(value = "select id_cidade from cidades where nome = :nomeCidade", nativeQuery = true)
    public int getCidadeId(String nomeCidade);
}
