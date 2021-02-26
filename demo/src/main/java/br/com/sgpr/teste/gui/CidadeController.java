package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.Cidade;
import br.com.sgpr.teste.data.CidadeRepository;

@RestController
@RequestMapping(path = "cidades")
public class CidadeController {
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping()
    public Iterable<Cidade> getCidades(){
        return cidadeRepository.findAll();
    }
}
