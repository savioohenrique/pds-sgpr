package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.sgpr.teste.data.ViagensRepository;
import br.com.sgpr.teste.business.Viagens;

@RestController
@RequestMapping(path="viagens")
public class ViagensController {
	@Autowired
	private ViagensRepository viagensRepository;
	
	@GetMapping()
	public Iterable<Viagens> getViagens(){
		return viagensRepository.findAll();
	}
}
