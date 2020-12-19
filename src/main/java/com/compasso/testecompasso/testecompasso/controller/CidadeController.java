package com.compasso.testecompasso.testecompasso.controller;

import com.compasso.testecompasso.testecompasso.model.Cidade;
import com.compasso.testecompasso.testecompasso.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@CrossOrigin
@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Cidade cidade) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.cidadeService.saveCidade(cidade));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

}
