package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.entity.Rota;

public interface RotaRepository extends CrudRepository<Rota, String>{
    
}
