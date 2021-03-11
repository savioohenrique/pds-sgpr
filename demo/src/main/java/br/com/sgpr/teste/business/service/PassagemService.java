package br.com.sgpr.teste.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.sgpr.teste.business.entity.VisaoUserPassagem;
import br.com.sgpr.teste.data.VisaoUserPassagemRepository;

@Service
public class PassagemService {
    @Autowired
    private VisaoUserPassagemRepository visaoUserPass;

    public Iterable<VisaoUserPassagem> getUserPass(String userId) {
        return visaoUserPass.getUserPass(userId);
    }
}
