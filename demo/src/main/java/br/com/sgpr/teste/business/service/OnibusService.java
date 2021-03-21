package br.com.sgpr.teste.business.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Onibus;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
import br.com.sgpr.teste.data.OnibusRepository;

@Service
public class OnibusService {
	private OnibusRepository OnibusRepository;

	public void cadastrar(Onibus onibus) throws BusinessExceptions{
		validate(onibus);
		OnibusRepository.save(onibus);
	}

	private void validate(Onibus onibus) throws BusinessExceptions {
		ArrayList<String> listOfInvalidFeild = new ArrayList<>();
		
		if (onibus.getPlaca() == null) {
			listOfInvalidFeild.add("Placa vazia");
		}
		
		if (listOfInvalidFeild.size() > 0) {
			throw new BusinessExceptions(listOfInvalidFeild);
		}
	}

	public Iterable<Onibus> getTodosOnibus() {
		return OnibusRepository.findAll();
	}

	public Optional<Onibus> getOnibus(String numPlaca) {
		return OnibusRepository.findById(numPlaca);
	}

	public String deleteOnibus(String numPlaca) {
		OnibusRepository.deleteById(numPlaca);
		return "Onibus deletado";
	}
}
