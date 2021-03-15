package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.TempOnibus;

public interface TempOnibusRepository extends CrudRepository<TempOnibus, String>{
    
}
