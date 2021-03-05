package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.PassagensViagem;

public interface PassagensViagemsRepository extends CrudRepository<PassagensViagem, String>{
    @Query(value = "select cod_validacao, data_validade, num_assento, cpf, nome from passagem as ps, passageiro as p where ps.viagem = :viagemId and ps.cpf_dono = p.cpf;", nativeQuery = true)
    public Iterable<PassagensViagem> getPassagens(@Param("viagemId") String viagem);
}
