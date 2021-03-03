package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;
import br.com.sgpr.teste.business.entity.Viagem;

public interface ViagemRepository extends CrudRepository<Viagem, Integer>{

}
