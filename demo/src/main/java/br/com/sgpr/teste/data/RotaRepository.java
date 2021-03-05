package br.com.sgpr.teste.data;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.Rota;

public interface RotaRepository extends CrudRepository<Rota, String>{
    @Query(value = "select * from rota where id_rota = :rotaId", nativeQuery = true)
    public ArrayList<Rota> getRotaById(@Param("rotaId") String id);
}
