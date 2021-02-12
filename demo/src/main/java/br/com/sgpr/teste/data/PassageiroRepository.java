package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;
import br.com.sgpr.teste.business.Passageiro;

public interface PassageiroRepository extends CrudRepository<Passageiro, Integer>{

}
