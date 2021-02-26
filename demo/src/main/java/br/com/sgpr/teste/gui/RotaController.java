package br.com.sgpr.teste.gui;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.sgpr.teste.business.Cidade;
import br.com.sgpr.teste.business.Rota;
import br.com.sgpr.teste.business.VisãoRotas;
import br.com.sgpr.teste.business.RotaCidades;
import br.com.sgpr.teste.business.VisaoRotaCidade;
import br.com.sgpr.teste.data.VisaoRotaCidadeRepository;
import br.com.sgpr.teste.data.CidadeRepository;
import br.com.sgpr.teste.data.RotaCidadesRepository;
import br.com.sgpr.teste.data.RotaRepository;
import br.com.sgpr.teste.data.VisaoRotaRepository;

@RestController
@RequestMapping(path="rota")
public class RotaController {
    @Autowired
    private RotaRepository rotaRepository;
    @Autowired
    private VisaoRotaRepository visaoRotaRepository;
    @Autowired
    private RotaCidadesRepository rotaCidadesRepository;
    @Autowired
    private VisaoRotaCidadeRepository visaoRotaCidadesRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping()
    public Iterable<VisãoRotas> getRotas(){
        System.out.println("Pegando todas as rotas");
        return visaoRotaRepository.findAll();
    }

    @PostMapping()
    public String postRota(@RequestBody Rota rota){
        System.out.println("Salvando nova rota " + rota.getIdRota() + " de nome " + rota.getNome() +" com origem em "+ rota.getNomeOrigem() + " e destino "+ rota.getNomeDestino() +"...");
        rota.setOrigem(cidadeRepository.getCidadeId(rota.getNomeOrigem()));
        rota.setDestino(cidadeRepository.getCidadeId(rota.getNomeDestino()));
        rotaRepository.save(rota);
        return new String("salvo com sucesso!");
    }

    @GetMapping(path="/cidades")
    public Iterable<VisaoRotaCidade> getCidades(@RequestParam String idRota){
        System.out.println("Pegando todas as cidades da rota " + idRota + "...");
        return visaoRotaCidadesRepository.getCidadesRota(idRota);
    }

    @PostMapping(path="/cidades")
    public String postRotaCidades(@RequestBody ArrayList<VisaoRotaCidade> cidades){
        System.out.println("Salvando cidades da rota...");
        for(VisaoRotaCidade c : cidades){
            Cidade cidade = cidadeRepository.getCidadeByName(c.getNomeCidade());
            rotaCidadesRepository.save(new RotaCidades(c.getIdRota(), cidade.getId(), c.getNumSeq()));
        }
        return new String("cidades da rota salva com sucesso!");
    }
}
