package br.com.sgpr.teste.business.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.sgpr.teste.business.entity.visoes.AuxRotaCidade;
import br.com.sgpr.teste.business.entity.Cidade;
import br.com.sgpr.teste.business.entity.Rota;
import br.com.sgpr.teste.business.entity.RotaCidades;
import br.com.sgpr.teste.business.entity.visoes.VisaoRotaCidade;
import br.com.sgpr.teste.business.entity.visoes.VisaoRotas;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
import br.com.sgpr.teste.data.CidadeRepository;
import br.com.sgpr.teste.data.RotaCidadesRepository;
import br.com.sgpr.teste.data.RotaRepository;
import br.com.sgpr.teste.data.VisaoRotaCidadeRepository;
import br.com.sgpr.teste.data.VisaoRotaRepository;


@Service
public class RotaCidadesService {
    @Autowired
    private RotaCidadesRepository rotaCidadesRepository;
    @Autowired
    private VisaoRotaCidadeRepository visaoRotaCidadesRepository;
    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private RotaRepository rotaRepository;
    @Autowired
    private VisaoRotaRepository visaoRotasRepository;

    public Iterable<VisaoRotaCidade> getCidades(@PathVariable String rotaId){
        System.out.println("Pegando todas as cidades da rota " + rotaId + "...");
        return visaoRotaCidadesRepository.getCidadesRota(rotaId);
    }

    public String saveCidadesDaRota(AuxRotaCidade rotaCidades) throws BusinessExceptions {
        System.out.println("Salvando as "+ rotaCidades.getCidades().size() + " cidades da rota...");
        validadeRotaCidades(rotaCidades);
        for(VisaoRotaCidade c : rotaCidades.getCidades()){
            Cidade cidade = cidadeRepository.getCidadeByName(c.getNome());
            RotaCidades rc = new RotaCidades(rotaCidades.getRotaId(), cidade.getId(), c.getNumSeq());
            rotaCidadesRepository.saveNovaCidade(rc.getIdRota(), rc.getIdCidade(), rc.getNumSeq());
        }
        return new String("cidades da rota salva com sucesso!");
    }

    public String deleteCidadesDaRota(@PathVariable String rotaId){
        System.out.println("Começando a deletar as cidades da rota de id " + rotaId + "...");
        rotaCidadesRepository.deleteCidadesRotaById(rotaId);
        return new String("Todas as cidades da rota foram deletadas!");
    }

    public void validadeRotaCidades(AuxRotaCidade rotaCidadesToValidate) throws BusinessExceptions{
        ArrayList<String> listOfInvalidFeilds = new ArrayList<>();
        boolean rotaIsValid = true, cidadesIsValid = true;

        if(rotaCidadesToValidate == null) {
            listOfInvalidFeilds.add("Cidades da rota não foram fornecidas");
            throw new BusinessExceptions(listOfInvalidFeilds);
        }

        if(rotaCidadesToValidate.getRotaId() == null || rotaCidadesToValidate.getRotaId().isEmpty()) {
            listOfInvalidFeilds.add("rotaId não fornecido");
            rotaIsValid = false;
        }else{
            Optional<Rota> rota = rotaRepository.findById(rotaCidadesToValidate.getRotaId());

            if(rota.isEmpty()) {
                listOfInvalidFeilds.add("rotaId invalido");
                rotaIsValid = false;
            }
        }

        if(rotaCidadesToValidate.getCidades().size() == 0 || rotaCidadesToValidate.getCidades() == null) {
            listOfInvalidFeilds.add("Lista de cidades vazia");
        }else {
            for(VisaoRotaCidade cidadeToValidate : rotaCidadesToValidate.getCidades()) {
                if(cidadeToValidate.getNome() == null || cidadeToValidate.getNome().isEmpty()) {
                     listOfInvalidFeilds.add("Nome da cidade não fornecido!");
                     cidadesIsValid = false;
                }else {
                     Optional<Cidade> cidade = Optional.ofNullable(cidadeRepository.getCidadeByName(cidadeToValidate.getNome()));
     
                     if(cidade.isEmpty()) {
                         listOfInvalidFeilds.add("Cidade " + cidadeToValidate.getNome() + " invalida");
                         cidadesIsValid = false;
                     }
                }
             }
        }

        if(rotaIsValid && cidadesIsValid) {
            VisaoRotas rota = visaoRotasRepository.findById(rotaCidadesToValidate.getRotaId()).orElseGet(() -> new VisaoRotas());
            
            int lastIndex = rotaCidadesToValidate.getCidades().size() - 1;
            for(VisaoRotaCidade cidadeToValidade : rotaCidadesToValidate.getCidades()) {
                if(cidadeToValidade.getNumSeq() == 0 && !cidadeToValidade.getNome().equals(rota.getOrigem())) {
                    listOfInvalidFeilds.add("Origem não é a mesma que a origem da rotaId");
                }

                if(cidadeToValidade.getNumSeq() == lastIndex && !cidadeToValidade.getNome().equals(rota.getDestino())) {
                    listOfInvalidFeilds.add("Destino não é o mesmo que o destino da rotaId");
                }
            }

        }

        if(listOfInvalidFeilds.size() > 0) {
            throw new BusinessExceptions(listOfInvalidFeilds);
        }
    }
}
