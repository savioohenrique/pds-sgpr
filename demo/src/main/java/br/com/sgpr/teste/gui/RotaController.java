package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.Rota;
import br.com.sgpr.teste.business.RotaCidades;
import br.com.sgpr.teste.data.RotaCidadesRepository;
import br.com.sgpr.teste.data.RotaRepository;

@RestController
@RequestMapping(path="rotas")
public class RotaController {
    @Autowired
    private RotaRepository rotaRepository;
    @Autowired
    private RotaCidadesRepository rotaCidadesRepository;
    
    @GetMapping()
    public Iterable<Rota> getRotas(){
        System.out.println("Pegando todas as rotas");
        return rotaRepository.findAll();
    }

    @PostMapping()
    public String postRota(@RequestBody Rota rota){
        System.out.println("Salvando nova rota...");
        rotaRepository.save(rota);
        return new String("salvo com sucesso!");
    }

    @GetMapping(path="/rotacidades")
    public Iterable<RotaCidades> getCidades(@RequestParam String idRota){
        System.out.println("Pegando todas as cidades da rota " + idRota + "...");
        return rotaCidadesRepository.getCidadesRota(idRota);
    }
}
