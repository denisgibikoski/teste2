package com.compasso.testecompasso.testecompasso.service;

import com.compasso.testecompasso.testecompasso.model.Cliente;
import com.compasso.testecompasso.testecompasso.model.dto.ClienteDto;
import com.compasso.testecompasso.testecompasso.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente saveCliente(Cliente clienteDto){
        Cliente cliente = new Cliente();
        cliente.setIdade(clienteDto.getIdade());

        return this.clienteRepository.save(cliente);
    }
}
