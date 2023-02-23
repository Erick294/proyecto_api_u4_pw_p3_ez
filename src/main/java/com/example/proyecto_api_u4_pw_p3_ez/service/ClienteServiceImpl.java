package com.example.proyecto_api_u4_pw_p3_ez.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyecto_api_u4_pw_p3_ez.repository.IClienteRepository;
import com.example.proyecto_api_u4_pw_p3_ez.repository.modelo.Cliente;
import com.example.proyecto_api_u4_pw_p3_ez.service.To.ClienteTo;

@Service
public class ClienteServiceImpl implements IClienteService{
    
    @Autowired
    private IClienteRepository estudianteRepository;

    private ClienteTo convertir(Cliente cli){
        ClienteTo clio = new ClienteTo();
        clio.setApellido(cli.getApellido());
        clio.setGenero(cli.getGenero());
        clio.setCedula(cli.getCedula());
        clio.setEmail(cli.getEmail());
        clio.setId(cli.getId());
        clio.setNombre(cli.getNombre());
        return clio;
    }

    @Override
    public void actualizar(Cliente cliente) {
        // TODO Auto-generated method stub
        this.estudianteRepository.actualizar(cliente);
    }

    @Override
    public ClienteTo buscarCedula(String cedula) {
        // TODO Auto-generated method stub
        return this.convertir(this.estudianteRepository.buscarCedula(cedula));
    }

    @Override
    public List<ClienteTo> buscarTodos() {
        // TODO Auto-generated method stub
        List<Cliente> listatmp = this.estudianteRepository.buscarTodos();
        return listatmp.stream().map(cliente -> this.convertir(cliente)).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.estudianteRepository.eliminar(id); 
    }

    @Override
    public void eliminarCedula(String cedula) {
        // TODO Auto-generated method stub
        this.estudianteRepository.eliminarCedula(cedula);
    }

    @Override
    public void insertar(Cliente cliente) {
        // TODO Auto-generated method stub
        this.estudianteRepository.insertar(cliente);
    }

    
    
}
