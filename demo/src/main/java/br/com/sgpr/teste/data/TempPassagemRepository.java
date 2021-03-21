package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.Passagem;

public interface TempPassagemRepository extends CrudRepository<Passagem, String> {
    
}
