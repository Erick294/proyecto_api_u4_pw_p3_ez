package com.example.proyecto_api_u4_pw_p3_ez.repository;

import java.util.List;

import com.example.proyecto_api_u4_pw_p3_ez.repository.modelo.Cliente;

public interface IClienteRepository {
    
    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Integer id);
    public void eliminarCedula(String cedula);
    public Cliente buscarCedula(String cedula);
    public List<Cliente> buscarTodos();
}
