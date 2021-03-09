package br.com.sgpr.teste.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Motorista;
import br.com.sgpr.teste.data.MotoristaRepository;

@Service
public class MotoristaService {
	@Autowired
	private MotoristaRepository MotoristaRepository;

	public void cadastrar(Iterable<Motorista> Motorista) {
		MotoristaRepository.saveAll(Motorista);
	}

	public Iterable<Motorista> findAll() {
		return MotoristaRepository.findAll();
	}

	public Optional<Motorista> findById(String cpfMotorista) {
		return MotoristaRepository.findById(cpfMotorista);
	}

	public void deleteById(String cpfMotorista) {
		MotoristaRepository.deleteById(cpfMotorista);	
	}
}
