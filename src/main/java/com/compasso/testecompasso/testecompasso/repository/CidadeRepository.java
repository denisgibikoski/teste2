package com.compasso.testecompasso.testecompasso.repository;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
}
