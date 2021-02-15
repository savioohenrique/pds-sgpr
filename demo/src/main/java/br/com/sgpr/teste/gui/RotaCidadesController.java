package br.com.sgpr.teste.gui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// import br.com.sgpr.teste.business.RotaCidade;
import br.com.sgpr.teste.business.RotaCidades;
// import br.com.sgpr.teste.data.RotaCidadeRepository;
import br.com.sgpr.teste.data.RotaCidadesRepository;

@RestController
@RequestMapping(path = "rotacidades")
public class RotaCidadesController {
    @Autowired
    // private RotaCidadeRepository rotaCidadesRepository;
    private RotaCidadesRepository rotaCidadesRepository;

    // @GetMapping()
    // public Iterable<RotaCidades> getCidades(@RequestParam String idRota){
    //     System.out.println("Pegando todas as cidades da rota " + idRota + "...");
    //     return rotaCidadesRepository.getCidadesRota(idRota);
    // }
    @GetMapping()
    public Iterable<RotaCidades> getCidades(@RequestParam String idRota){
        System.out.println("Pegando todas as cidades da rota " + idRota + "...");
        return rotaCidadesRepository.getCidadesRota(idRota);
    }
}
