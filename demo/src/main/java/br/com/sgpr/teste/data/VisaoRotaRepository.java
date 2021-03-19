package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;
import br.com.sgpr.teste.business.entity.visoes.VisaoRotas;

public interface VisaoRotaRepository extends CrudRepository<VisaoRotas, String>{
    
}
