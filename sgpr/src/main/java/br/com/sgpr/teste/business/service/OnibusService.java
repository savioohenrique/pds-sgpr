package br.com.sgpr.teste.business.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Onibus;
import br.com.sgpr.teste.data.OnibusRepository;

@Service
public class OnibusService {
	private OnibusRepository OnibusRepository;

	public void cadastrar(Iterable<Onibus> onibus) {
		OnibusRepository.saveAll(onibus);
	}

	public Iterable<Onibus> findAll() {
		return OnibusRepository.findAll();
	}

	public Optional<Onibus> findById(String cpfOnibus) {
		return OnibusRepository.findById(cpfOnibus);
	}

	public void deleteById(String cpfOnibus) {
		OnibusRepository.deleteById(cpfOnibus);	
	}

}
