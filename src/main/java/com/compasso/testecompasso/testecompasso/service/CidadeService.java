package com.compasso.testecompasso.testecompasso.service;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade saveCidade(Cidade cidade){
        return cidadeRepository.save(cidade);
    }


}
