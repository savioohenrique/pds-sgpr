package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.TempPassagem;

public interface TempPassagemRepository extends CrudRepository<TempPassagem, String> {
    
}
