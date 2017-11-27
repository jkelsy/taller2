/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.servicio;

import com.jk.taller2.dao.IClienteDAO;
import com.jk.taller2.dominio.Cliente;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author jk
 */
@Component
public class ClienteFacade implements IClienteFacade{
    
    @Autowired
    private IClienteDAO cliente;

    @Override
    public Cliente findById(long id) {
        return cliente.findById(id);
    }

    @Override
    public List<Cliente> findAll() {
        return cliente.findAll();
    }

    @Override
    public void create(Cliente entity) {
        cliente.create(entity);
    }

    @Override
    public void update(Cliente entity) {
        cliente.update(entity);
    }

    @Override
    public void delete(Cliente entity) {
        cliente.delete(entity);
    }

    @Override
    public void deleteById(long entityId) {
        cliente.deleteById(entityId);
    }
    
}
