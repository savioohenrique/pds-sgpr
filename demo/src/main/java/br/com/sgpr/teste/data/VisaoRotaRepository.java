package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;
import br.com.sgpr.teste.business.VisaoRotas;

public interface VisaoRotaRepository extends CrudRepository<VisaoRotas, Integer>{
    
}
