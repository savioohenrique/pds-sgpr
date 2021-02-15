package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.RotaCidade;

public interface RotaCidadeRepository extends CrudRepository<RotaCidade, Integer>{
    @Query(value = "select * from rota_cidades where id_rota = :idRota", nativeQuery = true)
    public Iterable<RotaCidade> getCidadesRota(@Param("idRota") String idRota);
}
