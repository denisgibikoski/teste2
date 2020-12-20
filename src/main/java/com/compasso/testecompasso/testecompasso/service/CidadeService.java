package com.compasso.testecompasso.testecompasso.service;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade saveCidade(Cidade cidade){
        return cidadeRepository.save(cidade);
    }


    public Cidade getCidade(String nome) {
        return cidadeRepository.findOneByNome(nome);
    }

    public List<Cidade> getEstado(String uf) {
        return cidadeRepository.findAllByUf(uf);
    }
}
