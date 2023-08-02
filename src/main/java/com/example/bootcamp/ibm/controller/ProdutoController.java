package com.example.bootcamp.ibm.controller;

import com.example.bootcamp.ibm.domain.Produto;
import com.example.bootcamp.ibm.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Produto produto) {
        Produto obj = service.insert(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Produto>> find(@PathVariable Integer id) {
        Optional<Produto> obj = service.find(id);
        return ResponseEntity.ok().body(obj);
    }
}
