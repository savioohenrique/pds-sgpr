package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.Rota;
import br.com.sgpr.teste.data.RotaRepository;

@RestController
@RequestMapping(path="rotas")
public class RotaController {
    @Autowired
    private RotaRepository rotaRepository;
    
    @GetMapping()
    public Iterable<Rota> getRotas(){
        System.out.println("Pegando todas as rotas");
        return rotaRepository.findAll();
    }
}
