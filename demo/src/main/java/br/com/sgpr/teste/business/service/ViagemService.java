package br.com.sgpr.teste.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Viagem;
import br.com.sgpr.teste.business.entity.VisaoViagens;
import br.com.sgpr.teste.data.ViagemRepository;
import br.com.sgpr.teste.data.VisaoViagensRepository;

@Service
public class ViagemService {
    @Autowired
    private ViagemRepository viagemRepository;
    @Autowired
	private VisaoViagensRepository viagensRepository;
	
	public Iterable<Viagem> getViagens(){
        System.out.println("Pegando todas as viagens...");
		return viagemRepository.findAll();
    }

    public String saveViagem(Viagem novaViagem){
        System.out.println("Salvando nova viagem...");
        viagemRepository.save(novaViagem);
        return "Saved";
    }

    public String deleteViagem(int viagemId){
        System.out.println("Deletando viagem de id "+ viagemId + "...");
        viagemRepository.deleteById(viagemId);
        return new String("Viagem de id " + viagemId + " deletada");
    }

	public Iterable<VisaoViagens> getVisaoViagens(){
		System.out.println("Pegando todas as viagens...");
		return viagensRepository.findAll();
	}

	public Iterable<VisaoViagens> pesquisarViagens(String origem, String destino){
		if(destino == null){
			System.out.println("Começando a pesquisa pelas viagens com origem em " + origem + "...");
			return viagensRepository.findAllViagens(origem);
		}else{
			System.out.println("Começando a pesquisa pelas viagens com origem em " + origem + " e destino a " + destino + "...");
			return viagensRepository.findAllViagens(origem, destino);
		}
	}
}
