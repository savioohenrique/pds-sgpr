package br.com.sgpr.teste.business.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Onibus;
import br.com.sgpr.teste.business.entity.Passagem;
import br.com.sgpr.teste.business.entity.Viagem;
import br.com.sgpr.teste.data.OnibusRepository;
import br.com.sgpr.teste.data.PassagemRepository;
import br.com.sgpr.teste.data.ViagemRepository;

@Service
public class PassagemService {
	@Autowired
	private PassagemRepository passagemRepository;
	
	@Autowired
	private ViagemRepository viagemRepository;
	
	@Autowired
	private OnibusRepository onibusRepository;
	
	public void gerar(Iterable<Passagem> passagem){
		passagemRepository.saveAll(passagem);
	}
	
	public void validatePassagem(Passagem passagem) throws Exception{
		int idViagem = passagem.getViagem();
		
		System.out.println("Quantidade de assentos ocupados para a viagem: " + idViagem);
		
		Optional<Viagem> viagem = viagemRepository.findById(idViagem);
		String idOnibus = viagem.get().getOnibus();
	
		Optional<Onibus> onibus = onibusRepository.findById(idOnibus);
		String assentosOcupados = passagemRepository.getAssentosOcupados(idViagem);
		
		int qtdAssentos = onibus.get().getNum_assentos();
		
		if (qtdAssentos <= Integer.parseInt(assentosOcupados)) {
			throw new Exception("Não possui assentos disponíveis!");
		}
		
		if (passagem.getCodigo() == null) {
			throw new Exception("O código da passagem não pode ser nulo!");
		}
	}

	public void update(Passagem passagem) {
		passagemRepository.save(passagem);
	}

	public Optional<Passagem> buscar(String cpfPassagem) {
		return passagemRepository.findById(cpfPassagem);
	}
	
	public Iterable<Passagem> findAll() {
		return passagemRepository.findAll();
	}

	public void deleteById(String cpfPassagem) {
		passagemRepository.deleteById(cpfPassagem);	
	}

	

	
}
