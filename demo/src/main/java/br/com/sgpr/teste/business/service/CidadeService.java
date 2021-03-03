package br.com.sgpr.teste.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Cidade;
import br.com.sgpr.teste.data.CidadeRepository;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public Iterable<Cidade> getCidades(){
        System.out.println("Pegando todas as cidades");
        return cidadeRepository.findAll();
    }

    public String saveCidade(Cidade cidade){
        System.out.println("Salvando nova cidade, " + cidade.getNome());
        cidadeRepository.save(cidade);
        return new String("Cidade salva");
    }

    public String deleteCidade(int cidadeId) {
        System.out.println("Delentando cidade de id " + cidadeId +"...");
        cidadeRepository.deleteById(cidadeId);
        return new String("Cidade de id " + cidadeId + " deletada");
    }
}
