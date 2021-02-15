package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.Viagens;

public interface ViagensRepository extends CrudRepository<Viagens, Integer>{
    @Query(value = "select * from viagens where viagens.origem = :origem", nativeQuery = true)
    public Iterable<Viagens> findAllViagens(@Param("origem") String origem);
    
    @Query(value = "select * from viagens where viagens.origem = :origem and viagens.destino = :destino", nativeQuery = true)
    public Iterable<Viagens> findAllViagens(@Param("origem") String origem, @Param("destino") String destino);
}

