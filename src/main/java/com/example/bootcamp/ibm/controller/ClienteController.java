package com.example.bootcamp.ibm.controller;

import com.example.bootcamp.ibm.domain.Cliente;
import com.example.bootcamp.ibm.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Cliente cliente) {
        Cliente obj = service.insert(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cliente>> find(@PathVariable Integer id){
        Optional<Cliente> obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

}
