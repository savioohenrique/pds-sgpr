package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.RotaCidades;

public interface RotaCidadesRepository extends CrudRepository<RotaCidades, Integer>{
    @Query(value = "select rc.id_rota, c.nome as nome_cidade, rc.num_seq from rota_cidades as rc, cidades as c where rc.id_rota = :idRota and rc.id_cidade = c.id_cidade;", nativeQuery = true)
    public Iterable<RotaCidades> getCidadesRota(@Param("idRota") String idRota);
}
