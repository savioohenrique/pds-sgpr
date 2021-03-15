package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sgpr.teste.business.Viagem;
import br.com.sgpr.teste.business.ViagemService;
import br.com.sgpr.teste.business.VisaoViagens;

@RestController
@RequestMapping(path="viagem")
public class ViagemController {
	@Autowired
	private ViagemService viagemService;
    
	@GetMapping()
	public Iterable<VisaoViagens> getViagens(){
		return viagemService.getVisaoViagens();
    }
    
    @GetMapping(path = "/{viagemId}")
    public VisaoViagens getViagemById(@PathVariable("viagemId") int viagemId) {
        return viagemService.getViagemById(viagemId);
    }

    @PostMapping()
    public String postViagem(@RequestBody Viagem novaViagem){
        return viagemService.saveViagem(novaViagem);
    }

    @DeleteMapping(path = "/{viagemId}")
    public String deleteViagem(@PathVariable int viagemId){
        return viagemService.deleteViagem(viagemId);
    }

    @GetMapping(path="busca")
	public Iterable<VisaoViagens> pesquisarViagens(@RequestParam String origem, @RequestParam(required = false) String destino){
		return viagemService.pesquisarViagens(origem, destino);
	}
}

