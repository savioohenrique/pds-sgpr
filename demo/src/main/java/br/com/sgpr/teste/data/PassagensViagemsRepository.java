package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.visoes.VisaoPassagens;

public interface PassagensViagemsRepository extends CrudRepository<VisaoPassagens, String>{
    @Query(value = "select cod_validacao, viagem, num_assento, cpf, nome from passagem as ps, passageiro as p where ps.viagem = :viagemId and ps.cpf_dono = p.cpf;", nativeQuery = true)
    public Iterable<VisaoPassagens> getPassagens(@Param("viagemId") String viagem);

    @Query(value = "select cod_validacao, viagem, num_assento, cpf, nome from passagem as ps, passageiro as p where ps.cpf_dono = :userId and ps.cpf_dono = p.cpf;", nativeQuery = true)
    public Iterable<VisaoPassagens> getUserPass(@Param("userId") String userId);
}
