package com.compasso.testecompasso.testecompasso.repository;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {


    Cidade findOneByNome(String nome);

    List<Cidade> findAllByUf(String uf);
}
