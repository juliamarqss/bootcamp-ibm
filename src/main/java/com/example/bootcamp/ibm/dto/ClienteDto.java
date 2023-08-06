package com.example.bootcamp.ibm.dto;

import com.example.bootcamp.ibm.domain.Cliente;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
public class ClienteDto implements Serializable {
    private Integer id;
    private String nome;
    private String email;

    public ClienteDto(Cliente obj){
        id = obj.getId();
        nome = obj.getNome();
        email = obj.getEmail();
    }

    public ClienteDto(Integer i, String nome, String email) {
    }
}
