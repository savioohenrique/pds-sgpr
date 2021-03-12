package br.com.sgpr.teste.business.service;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.PassagensViagem;
import br.com.sgpr.teste.business.entity.TempPassagem;
import br.com.sgpr.teste.business.entity.Viagem;
import br.com.sgpr.teste.business.exceptions.BusinessExceptions;
import br.com.sgpr.teste.data.PassagensViagemsRepository;
import br.com.sgpr.teste.data.TempPassagemRepository;
import br.com.sgpr.teste.data.ViagemRepository;

@Service
public class PassagemService {
    @Autowired
    private PassagensViagemsRepository passagensViagensRepository;
    @Autowired
    private TempPassagemRepository passagemRepository;
    @Autowired
    private ViagemRepository viagemRepository;

    public Iterable<PassagensViagem> getPassagensViagem(String viagemId){
        return passagensViagensRepository.getPassagens(viagemId);
    }

    public Iterable<PassagensViagem> getUserPass(String userId) {
        return passagensViagensRepository.getUserPass(userId);
    }

    public void cancelarViagem(String passId) throws BusinessExceptions{
        System.out.println("Cancelando a pass " + passId);
        TempPassagem pass = passagemRepository.findById(passId).orElseGet(() -> null);
        Viagem viagem = viagemRepository.findById(pass.getViagem()).orElseGet(() -> null);

        LocalDate viagemDate = LocalDate.parse(viagem.getData());
        LocalDate today = LocalDate.now();

        ArrayList<String> listOfErros = new ArrayList<>();
        if(today.isBefore(viagemDate)) {
            String mouth = today.getMonthValue() > 9 ? "" + today.getMonthValue() : "0" + today.getMonthValue();
            LocalDate yesterday = LocalDate.parse(today.getYear() + "-" + mouth + "-" + (today.getDayOfMonth() - 1));
            System.out.println(yesterday);
            // todo checar se a data do dia do cancelamento é valida. 
        }else {
            listOfErros.add("Data da Viagem é invalida");
        }
	}
}
