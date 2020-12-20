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

    public Cliente getClientePorNOme(String nome) {
        return  clienteRepository.findFirstByNome(nome);
    }

    public Cliente getClientePorId(String id) {
        Optional<Cliente> cliente = clienteRepository.findById(Long.valueOf(id));
        return cliente.get();
    }

    public void deleteCliente(String id) {
         clienteRepository.delete(this.getClientePorId(id));
    }

    public Cliente update(String id, String nomeCliente) {
        Cliente cliente = this.getClientePorId(id);
        cliente.setNome(nomeCliente);
        return clienteRepository.save(cliente);
    }
}
