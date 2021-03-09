package br.com.sgpr.teste.business.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Cidade;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
import br.com.sgpr.teste.data.CidadeRepository;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;
    
    public Iterable<Cidade> getCidades(){
        System.out.println("Pegando todas as cidades");
        return cidadeRepository.findAll();
    }

    public String saveCidade(Cidade cidade) throws BusinessExceptions{
        System.out.println("Salvando nova cidade, " + cidade.getNome());
        validateCidade(cidade);
        cidadeRepository.save(cidade);
        return new String("Cidade salva");
    }

    public String deleteCidade(int cidadeId) {
        System.out.println("Delentando cidade de id " + cidadeId +"...");
        cidadeRepository.deleteById(cidadeId);
        return new String("Cidade de id " + cidadeId + " deletada");
    }

    private void validateCidade(Cidade cidadeToValidate) throws BusinessExceptions{
        ArrayList<String> listOfInvalidFields = new ArrayList<>();

        if(cidadeToValidate == null) {
            listOfInvalidFields.add("Cidade não fornecida");
            throw new BusinessExceptions(listOfInvalidFields);
        }

        if(cidadeToValidate.getNome() == null || cidadeToValidate.getNome().isEmpty()) {
            listOfInvalidFields.add("Nome da cidade não foi fornecido");
        }

        if(listOfInvalidFields.size() > 0) {
            throw new BusinessExceptions(listOfInvalidFields);
        }
    }
}
