package com.example.bootcamp.ibm.service;

import com.example.bootcamp.ibm.domain.Produto;
import com.example.bootcamp.ibm.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto insert(Produto obj) {
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public Optional<Produto> find(Integer id) {
        Optional<Produto> obj = repository.findById(id);
        return obj;
    }
}
