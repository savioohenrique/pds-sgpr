package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		System.out.println("Pegando todas as viagens...");
		return viagensRepository.findAll();
	}

	@GetMapping(path="busca")
	public Iterable<Viagens> pesquisarViagens(@RequestParam String origem, @RequestParam String destino){
		System.out.println("Começando a pesquisa pelas viagens com origem em " + origem + " e destino a " + destino + "...");
		return viagensRepository.findAllViagens(origem, destino);
	}

	@GetMapping(path="busca1")
	public Iterable<Viagens> pesquisarViagens(@RequestParam String origem){
		System.out.println("Começando a pesquisa pelas viagens com origem em " + origem + "...");
		return viagensRepository.findAllViagens(origem);
	}
}
