package br.com.sgpr.teste.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.sgpr.teste.business.entity.Passagem;

public interface PassagemRepository extends CrudRepository<Passagem, String>{
	@Query(value = "select count(*) from passagem where viagem = :idViagem", nativeQuery = true)
	public String getAssentosOcupados(@Param("idViagem") int idViagem);
}
