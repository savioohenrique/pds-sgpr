package br.com.sgpr.teste.data;

import org.springframework.data.repository.CrudRepository;

import br.com.sgpr.teste.business.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
