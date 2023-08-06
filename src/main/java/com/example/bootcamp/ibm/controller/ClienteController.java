package com.example.bootcamp.ibm.controller;

import com.example.bootcamp.ibm.domain.Cliente;
import com.example.bootcamp.ibm.dto.ClienteDto;
import com.example.bootcamp.ibm.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

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
    public ResponseEntity<Cliente> find(@PathVariable Integer id){
        Cliente obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody ClienteDto dto, @PathVariable Integer id){
        Cliente obj = service.fromDto(dto);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
