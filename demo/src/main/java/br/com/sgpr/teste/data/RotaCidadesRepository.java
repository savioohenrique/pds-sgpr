package br.com.sgpr.teste.data;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.RotaCidades;

public interface RotaCidadesRepository extends CrudRepository<RotaCidades, String>{
    @Query(value = "select * from rota_cidades where id_rota = :idRota", nativeQuery = true)
    public Iterable<RotaCidades> getCidadesRota(@Param("idRota") String idRota);

    @Modifying
    @Transactional
    @Query(value = "insert into rota_cidades (id_rota, id_cidade, num_seq) values(:idRota, :idCidade, :numSeq)", nativeQuery = true)
    public void saveNovaCidade(@Param("idRota") String idRota, @Param("idCidade") int idCidade, @Param("numSeq") int numSeq);

    @Modifying
    @Transactional
    @Query(value = "delete from rota_cidades where id_rota = :rotaId", nativeQuery = true)
    public void deleteCidadesRotaById(@Param("rotaId") String rotaId);
}
