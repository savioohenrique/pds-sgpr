package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.entity.Cidade;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
import br.com.sgpr.teste.business.service.CidadeService;
import br.com.sgpr.teste.business.util.Mensagem;

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
    public Mensagem postCidade(@RequestBody Cidade novaCidade) {
        try {
            cidadeService.saveCidade(novaCidade);
            return new Mensagem("Sucesso");
        } catch (BusinessExceptions e) {
            Mensagem msg = new Mensagem("Error");
            msg.setErros(e.getListOfMenssagens());
            return msg;
        }
    }

    @DeleteMapping(path = "/{cidadeId}")
    public String deleteCidade(@PathVariable int cidadeId) {
        return cidadeService.deleteCidade(cidadeId);
    }
}
