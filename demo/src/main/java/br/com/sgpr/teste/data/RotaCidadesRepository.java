package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.RotaCidades;

public interface RotaCidadesRepository extends CrudRepository<RotaCidades, Integer>{
    @Query(value = "select * from rota_cidades where id_rota = :idRota", nativeQuery = true)
    public Iterable<RotaCidades> getCidadesRota(@Param("idRota") String idRota);
}
