package com.compasso.testecompasso.testecompasso.service;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.model.Cliente;
import com.compasso.testecompasso.testecompasso.repository.CidadeRepository;
import com.compasso.testecompasso.testecompasso.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private CidadeRepository cidadeRepository;

    public Cliente saveCliente(Cliente cliente){

        Optional<Cidade> optionalCidade = cidadeRepository.findById(cliente.getCidade().getId());
        cliente.setCidade(optionalCidade.get());

        return this.clienteRepository.save(cliente);
    }
}
