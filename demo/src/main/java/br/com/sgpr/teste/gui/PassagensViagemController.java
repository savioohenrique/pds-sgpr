package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.entity.PassagensViagem;
import br.com.sgpr.teste.business.entity.VisaoUserPassagem;
import br.com.sgpr.teste.business.service.PassagemService;
import br.com.sgpr.teste.data.PassagensViagemsRepository;

@RestController
@RequestMapping(path="passagens")
public class PassagensViagemController {
    @Autowired
    private PassagensViagemsRepository viagensRepository;
    @Autowired
    private PassagemService passagemService;

    @GetMapping()
    public Iterable<PassagensViagem> getPassagensViagem(@RequestParam String viagemId){
        System.out.println("Pegando as passagens da viagem " + viagemId + "...");
        return viagensRepository.getPassagens(viagemId);
    }

    @GetMapping(path = "/{userId}")
    public Iterable<VisaoUserPassagem> getUserPass(@PathVariable("userId") String userId) {
        return passagemService.getUserPass(userId);
    }
}
