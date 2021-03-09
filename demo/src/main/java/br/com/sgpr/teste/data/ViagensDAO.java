package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.VisaoViagens;

public interface ViagensDAO extends Repository<VisaoViagens, Integer>{
    @Query(value = "select * from viagens where origem = :origem", nativeQuery = true)
    public Iterable<VisaoViagens> findAllViagens(@Param("origem") String origem);
}


