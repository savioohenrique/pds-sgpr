package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.sgpr.teste.data.ViagemRepository;
import br.com.sgpr.teste.business.Viagem;

@RestController
@RequestMapping(path="viagem")
public class ViagemController {
	@Autowired
	private ViagemRepository viagemRepository;
	
	@GetMapping()
	public Iterable<Viagem> getViagens(){
		return viagemRepository.findAll();
    }
    
    @PostMapping()
    public String postViagem(@RequestBody Viagem novaViagem){
        System.out.println(novaViagem.getRota());
        viagemRepository.save(novaViagem);
        return "Saved";
    }
}

