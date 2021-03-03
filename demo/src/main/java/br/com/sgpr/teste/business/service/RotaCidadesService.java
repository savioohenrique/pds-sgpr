package br.com.sgpr.teste.business.service;

import java.util.ArrayList;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sgpr.teste.business.entity.Cidade;
import br.com.sgpr.teste.business.entity.RotaCidades;
import br.com.sgpr.teste.business.entity.VisaoRotaCidade;
import br.com.sgpr.teste.data.CidadeRepository;
import br.com.sgpr.teste.data.RotaCidadesRepository;
import br.com.sgpr.teste.data.VisaoRotaCidadeRepository;


@Service
public class RotaCidadesService {
    @Autowired
    private RotaCidadesRepository rotaCidadesRepository;
    @Autowired
    private VisaoRotaCidadeRepository visaoRotaCidadesRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Iterable<VisaoRotaCidade> getCidades(@PathVariable String rotaId){
        System.out.println("Pegando todas as cidades da rota " + rotaId + "...");
        return visaoRotaCidadesRepository.getCidadesRota(rotaId);
    }

    public String saveCidadesDaRota(ArrayList<VisaoRotaCidade> cidades){
        System.out.println("Salvando as "+ cidades.size() + " cidades da rota...");
        for(VisaoRotaCidade c : cidades){
            Cidade cidade = cidadeRepository.getCidadeByName(c.getNomeCidade());
            RotaCidades rc = new RotaCidades(c.getIdRota(), cidade.getId(), c.getNumSeq());
            rotaCidadesRepository.saveNovaCidade(rc.getIdRota(), rc.getIdCidade(), rc.getNumSeq());
        }
        return new String("cidades da rota salva com sucesso!");
    }

    public String deleteCidadesDaRota(@PathVariable String rotaId){
        System.out.println("Começando a deletar as cidades da rota de id " + rotaId + "...");
        rotaCidadesRepository.deleteCidadesRotaById(rotaId);
        return new String("Todas as cidadades da rota foram deletadas!");
    }
}
