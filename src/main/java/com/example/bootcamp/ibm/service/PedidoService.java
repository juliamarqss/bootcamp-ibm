package com.example.bootcamp.ibm.service;

import com.example.bootcamp.ibm.domain.Pedido;
import com.example.bootcamp.ibm.domain.Produto;
import com.example.bootcamp.ibm.dto.PedidoDto;
import com.example.bootcamp.ibm.repository.PedidoRepository;
import com.example.bootcamp.ibm.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteService clienteService;

    public Pedido insert(Pedido obj){
        obj.setId(null);
        obj.setData(new Date());
        obj.setCliente(clienteService.find(obj.getCliente().getId()));
        obj = pedidoRepository.save(obj);
        return obj;
    }

    public Pedido find(Integer id){
        Optional<Pedido> obj = pedidoRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!" + id + Produto.class.getName()));
    }

//    public void delete(Integer id) {
//        pedidoRepository.deleteById(id);
//    }

    public Pedido update(Pedido obj) {
        Pedido att = find(obj.getId());
        updateData(att, obj);
        return pedidoRepository.save(att);
    }

    public void updateData(Pedido novo, Pedido antigo){
        novo.setData(antigo.getData());
    }

    public Pedido fromDto(PedidoDto objDto){
        return new Pedido(objDto.getId(), objDto.getData(), objDto.getCliente());
    }
}
