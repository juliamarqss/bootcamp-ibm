package com.example.bootcamp.ibm.controller;

import com.example.bootcamp.ibm.domain.Cliente;
import com.example.bootcamp.ibm.dto.ClienteDto;
import com.example.bootcamp.ibm.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClienteController.class)
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ClienteService clienteService;

    @InjectMocks
    private ClienteController clienteController;

    private ClienteDto clienteDto;

    @BeforeEach
    public void setup(){
        clienteDto = new ClienteDto(1, "Maria", "maria@teste.com");
    }

    @Test
    public void testInsertCliente() throws Exception{
        Cliente clienteInserido = new Cliente(1, "Joao", "joao@teste.com");

        when(clienteService.insert(any(Cliente.class))).thenReturn(clienteInserido);

        mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"nome\":\"joao\",\"email\":\"joao@teste.com\"}")).andExpect(status().isCreated())
                .andExpect(MockMvcResultMatchers.header().string("Location", "http://localhost/clientes/1"));
    }

    @Test
    public void testDeleteCliente() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testFindClienteByIdExistente() throws Exception{
        Integer clienteId = 1;
        Cliente clienteEncontrado = new Cliente(1, "Joao", "joao@teste.com");

        when(clienteService.find(clienteId)).thenReturn(clienteEncontrado);

        mockMvc.perform(MockMvcRequestBuilders.get("/clientes/1"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.nome").value("Joao"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("joao@teste.com"));
    }

//    @Test
//    public void testUpdateCliente() throws Exception{
//        Integer clienteId = 1;
//
//        Cliente clienteAtualizado = new Cliente(clienteId, "Maria", "maria@teste.com");
//        Cliente clienteExistente = new Cliente(clienteId, "Joao", "joao@teste.com");
//
//        when(clienteService.find(clienteId)).thenReturn(clienteExistente);
//        when(clienteService.update(any(Cliente.class))).thenReturn(clienteAtualizado)
//
//    }
}
