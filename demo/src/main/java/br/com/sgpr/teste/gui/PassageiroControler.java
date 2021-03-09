package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import br.com.sgpr.teste.data.PassageiroRepository;
import br.com.sgpr.teste.business.Passageiro;

@RestController
@RequestMapping(path="passageiro")
public class PassageiroControler {
	@Autowired
	private PassageiroRepository passageiroRepository;
	
	@GetMapping()
	public Iterable<Passageiro> getPassageiros(){
		return passageiroRepository.findAll();
	}
}
