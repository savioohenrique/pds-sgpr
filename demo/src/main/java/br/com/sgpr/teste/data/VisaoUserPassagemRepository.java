package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.VisaoUserPassagem;

public interface VisaoUserPassagemRepository extends CrudRepository<VisaoUserPassagem, Integer>{
    @Query(value = "select * from passagensUser where cpf_dono = :userId", nativeQuery = true)
    public Iterable<VisaoUserPassagem> getUserPass(@Param("userId") String userId);
}
