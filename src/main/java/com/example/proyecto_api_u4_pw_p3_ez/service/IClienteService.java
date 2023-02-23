package com.example.proyecto_api_u4_pw_p3_ez.service;

import java.util.List;

import com.example.proyecto_api_u4_pw_p3_ez.repository.modelo.Cliente;
import com.example.proyecto_api_u4_pw_p3_ez.service.To.ClienteTo;

public interface IClienteService {

    public void insertar(Cliente cliente);
    public void actualizar(Cliente cliente);
    public void eliminar(Integer id);
    public void eliminarCedula(String cedula);
    public ClienteTo buscarCedula(String cedula);
    public List<ClienteTo> buscarTodos();
    
}
