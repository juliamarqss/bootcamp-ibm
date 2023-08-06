package com.example.bootcamp.ibm.controller.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StandartError {
    private Integer status; // erro 404, 500
    private Long horario;
    private String mensagem;
}
