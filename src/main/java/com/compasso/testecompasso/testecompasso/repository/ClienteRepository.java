package com.compasso.testecompasso.testecompasso.repository;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findFirstByNome(String nome);

}
