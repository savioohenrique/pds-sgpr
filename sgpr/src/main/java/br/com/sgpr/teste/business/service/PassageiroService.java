package br.com.sgpr.teste.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Passageiro;
import br.com.sgpr.teste.data.PassageiroRepository;

@Service
public class PassageiroService {
	@Autowired
	private PassageiroRepository passageiroRepository;

	public void cadastrar(Iterable<Passageiro> passageiro) {
		passageiroRepository.saveAll(passageiro);
	}

	public Iterable<Passageiro> findAll() {
		return passageiroRepository.findAll();
	}

	public Optional<Passageiro> findById(String cpfPassageiro) {
		return passageiroRepository.findById(cpfPassageiro);
	}

	public void deleteById(String cpfPassageiro) {
		passageiroRepository.deleteById(cpfPassageiro);	
	}
	
}
