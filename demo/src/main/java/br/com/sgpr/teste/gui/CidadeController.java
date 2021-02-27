package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.Cidade;
import br.com.sgpr.teste.business.CidadeService;

@RestController
@RequestMapping(path = "cidades")
public class CidadeController {
    @Autowired
    private CidadeService cidadeService;

    @GetMapping()
    public Iterable<Cidade> getCidades() {
        return cidadeService.getCidades();
    }

    @PostMapping()
    public String postCidade(@RequestBody Cidade novaCidade) {
        return cidadeService.saveCidade(novaCidade);
    }

    @DeleteMapping(path = "/{cidadeId}")
    public String deleteCidade(@PathVariable int cidadeId) {
        return cidadeService.deleteCidade(cidadeId);
    }
}
