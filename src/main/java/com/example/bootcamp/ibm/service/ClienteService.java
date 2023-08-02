package com.example.bootcamp.ibm.service;


import com.example.bootcamp.ibm.domain.Cliente;
import com.example.bootcamp.ibm.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente insert(Cliente obj){
        obj.setId(null);
        obj = repository.save(obj);
        return obj;
    }

    public Optional<Cliente> find(Integer id){
        Optional<Cliente> obj = repository.findById(id);
        return obj;
    }
}
