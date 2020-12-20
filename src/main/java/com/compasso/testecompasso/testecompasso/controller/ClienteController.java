package com.compasso.testecompasso.testecompasso.controller;


import com.compasso.testecompasso.testecompasso.model.Cliente;
import com.compasso.testecompasso.testecompasso.service.ClienteService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/cliente")
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

    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> getClientePorNome(@Valid @PathVariable String nome) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.getClientePorNOme(nome));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getClientePorId(@Valid @PathVariable String id) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(this.clienteService.getClientePorId(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeClientePorId(@Valid @PathVariable String id) {
        try{
            clienteService.deleteCliente(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso!");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizarClientePorId(@Valid @PathVariable String id, @Valid @RequestBody  JSONObject nome) {
        try{
            JSONObject json = new JSONObject(nome);
            String nomeCliente = json.getAsString("nome");
            return ResponseEntity.status(HttpStatus.OK).body(clienteService.update(id, nomeCliente ));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
