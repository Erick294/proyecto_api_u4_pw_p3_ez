package com.example.proyecto_api_u4_pw_p3_ez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyecto_api_u4_pw_p3_ez.repository.modelo.Cliente;
import com.example.proyecto_api_u4_pw_p3_ez.service.IClienteService;
import com.example.proyecto_api_u4_pw_p3_ez.service.To.ClienteTo;

@RestController
@RequestMapping("/clientes")
public class EstudianteControllerRestFul {

    @Autowired
    private IClienteService clienteService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void registrar(@RequestBody Cliente cliente) {
      this.clienteService.insertar(cliente);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void actualizar(Cliente cliente) {
        this.clienteService.actualizar(cliente);
    }

    @GetMapping(path = "/buscar/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ClienteTo encontrarCedula(@PathVariable("cedula") String cedula) {
        return this.clienteService.buscarCedula(cedula);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClienteTo> encontrarTodos() {
        return this.clienteService.buscarTodos();
    }

    @DeleteMapping(path = "/{id}")
    public void borrar(@PathVariable("id") Integer id) {
        this.clienteService.eliminar(id);
    }

    @DeleteMapping(path = "/cedula/{cedula}")
    public void borrarPorCedula(@PathVariable("cedula") String cedula){
        this.clienteService.eliminarCedula(cedula);
    }
    
}
