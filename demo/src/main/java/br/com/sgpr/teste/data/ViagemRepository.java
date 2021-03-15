package br.com.sgpr.teste.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.Viagem;

public interface ViagemRepository extends CrudRepository<Viagem, Integer>{
    @Modifying
    @Transactional
    @Query(value = "update viagem set assentos_disponiveis = :newQty where id_viagem = :viagemId", nativeQuery = true)
    public void updateAssentosDisponiveis(@Param("viagemId") int viagemId, @Param("newQty") int newQty);
}
