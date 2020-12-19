package com.compasso.testecompasso.testecompasso.controller;


import com.compasso.testecompasso.testecompasso.model.Cliente;
import com.compasso.testecompasso.testecompasso.model.dto.ClienteDto;
import com.compasso.testecompasso.testecompasso.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@SuppressWarnings("Duplicates")
@RequestMapping(value = "/cliente", produces = MediaType.APPLICATION_JSON_VALUE,
        consumes = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping
    public ResponseEntity<?> post(@Valid @RequestBody Cliente cliente) {
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteService.saveCliente(cliente));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
