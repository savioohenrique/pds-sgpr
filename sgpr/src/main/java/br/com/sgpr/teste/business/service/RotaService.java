package br.com.sgpr.teste.business.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.Rota;
import br.com.sgpr.teste.business.entity.VisaoRotas;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
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

    public String saveNewRota(Rota rota) throws BusinessExceptions{
        System.out.println("Salvando nova rota " + rota.getIdRota() + " de nome " + rota.getNome() +" com origem em "+ rota.getNomeOrigem() + " e destino "+ rota.getNomeDestino() +"...");
        validateRota(rota);
        rota.setOrigem(cidadeRepository.getCidadeId(rota.getNomeOrigem()).orElseGet(() -> 0));
        rota.setDestino(cidadeRepository.getCidadeId(rota.getNomeDestino()).orElseGet(() -> 0));
        rotaRepository.save(rota);
        return new String("salvo com sucesso!");
    }

    public String deleteRota(String rotaId){
        rotaRepository.deleteById(rotaId);
        return new String("rota deletada!");
    }

    //Teste
    public ArrayList<Rota> getRotaById(String rotaId){
        return rotaRepository.getRotaById(rotaId);
    }

    private void validateRota(Rota rotaToValidate) throws BusinessExceptions{
        ArrayList<String> listOfInvalidFeilds = new ArrayList<>();

        if(rotaToValidate == null){
            listOfInvalidFeilds.add("Rota não fornecida!");
            throw new BusinessExceptions(listOfInvalidFeilds);
        }

        if(rotaToValidate.getIdRota() == null || rotaToValidate.getIdRota().isEmpty()){
            listOfInvalidFeilds.add("Id da rota não fornecido!");
        }else{
            Optional<Rota> rota = rotaRepository.findById(rotaToValidate.getIdRota());

            if(rota.isPresent()) {
                listOfInvalidFeilds.add("Rota já existe");
            }
        }

        if(rotaToValidate.getNome() == null || rotaToValidate.getNome().isEmpty()){
            listOfInvalidFeilds.add("Nome da rota não fornecida!");
        }

        if(rotaToValidate.getNomeOrigem() == null || rotaToValidate.getNomeOrigem().isEmpty()){
            listOfInvalidFeilds.add("Origem não fornecida");
        }else{
            Optional<Integer> cidadeId = cidadeRepository.getCidadeId(rotaToValidate.getNomeOrigem());
            
            if(cidadeId.isEmpty()) {
                listOfInvalidFeilds.add("Origem invalida");            }
        }

        if(rotaToValidate.getNomeDestino() == null || rotaToValidate.getNomeDestino().isEmpty()){
            listOfInvalidFeilds.add("Destino não fornecido");
        }else{
            Optional<Integer> cidadeId = cidadeRepository.getCidadeId(rotaToValidate.getNomeDestino());
            
            if(cidadeId.isEmpty()) {
                listOfInvalidFeilds.add("Destino invalido");            }
        }

        if(listOfInvalidFeilds.size() > 0) {
            throw new BusinessExceptions(listOfInvalidFeilds);
        }
    }
}
