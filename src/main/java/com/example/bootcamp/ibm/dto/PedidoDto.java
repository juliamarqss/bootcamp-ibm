package com.example.bootcamp.ibm.dto;

import com.example.bootcamp.ibm.domain.Cliente;
import com.example.bootcamp.ibm.domain.Pedido;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Setter
@Getter
public class PedidoDto implements Serializable {

    private Integer id;
    private Date data;
    private Cliente cliente;

    public PedidoDto(Pedido obj){
        id = obj.getId();
        data = obj.getData();
        cliente = obj.getCliente();
    }
}
