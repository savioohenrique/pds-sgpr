package br.com.sgpr.teste.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Rota;
import br.com.sgpr.teste.business.entity.VisaoRotas;
import br.com.sgpr.teste.data.CidadeRepository;
import br.com.sgpr.teste.data.RotaRepository;
import br.com.sgpr.teste.data.VisaoRotaRepository;

@Service
public class RotaService {
    @Autowired
    private RotaRepository rotaRepository;
    @Autowired
    private VisaoRotaRepository visaoRotaRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Iterable<VisaoRotas> getRotas(){
        System.out.println("Pegando todas as rotas");
        return visaoRotaRepository.findAll();
    }

    public String saveNewRota(Rota rota){
        System.out.println("Salvando nova rota " + rota.getIdRota() + " de nome " + rota.getNome() +" com origem em "+ rota.getNomeOrigem() + " e destino "+ rota.getNomeDestino() +"...");
        rota.setOrigem(cidadeRepository.getCidadeId(rota.getNomeOrigem()));
        rota.setDestino(cidadeRepository.getCidadeId(rota.getNomeDestino()));
        rotaRepository.save(rota);
        return new String("salvo com sucesso!");
    }

    public String deleteRota(String rotaId){
        rotaRepository.deleteById(rotaId);
        return new String("rota deletada!");
    }
}
