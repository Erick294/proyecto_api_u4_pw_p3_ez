package com.example.proyecto_api_u4_pw_p3_ez.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.proyecto_api_u4_pw_p3_ez.repository.modelo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Transactional
@Repository
public class ClienteRepositoryImpl implements IClienteRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void insertar(Cliente cliente) {
        // TODO Auto-generated method stub
        this.entityManager.persist(cliente); 
    }

    @Override
    public void actualizar(Cliente cli) {
        // TODO Auto-generated method stub
        this.entityManager.merge(cli);
        
    }

    public Cliente buscar(Integer id) {
        // TODO Auto-generated method stub
        return this.entityManager.find(Cliente.class, id);
    }

    @Override
    public void eliminar(Integer id) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscar(id));
    }

    @Override
    public Cliente buscarCedula(String cedula) {
        // TODO Auto-generated method stub
        TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c WHERE c.cedula = :cedula", Cliente.class);
		myQuery.setParameter("cedula", cedula);
		return myQuery.getSingleResult();
    }

    @Override
    public List<Cliente> buscarTodos() {
        // TODO Auto-generated method stub
        TypedQuery<Cliente> myQuery = this.entityManager.createQuery("SELECT c FROM Cliente c", Cliente.class);
		return myQuery.getResultList();
    }

    @Override
    public void eliminarCedula(String cedula) {
        // TODO Auto-generated method stub
        this.entityManager.remove(this.buscarCedula(cedula));
    }
    
}
