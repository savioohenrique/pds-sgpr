package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.Onibus;

public interface TempOnibusRepository extends CrudRepository<Onibus, String>{
    
}
