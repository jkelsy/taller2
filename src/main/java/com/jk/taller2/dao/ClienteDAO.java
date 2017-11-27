/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.dao;

import com.jk.taller2.dominio.Cliente;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jk
 */
@Component
public class ClienteDAO implements IClienteDAO{
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public Cliente findById(long id) {
        return (Cliente)sessionFactory
                        .getCurrentSession()
                        .get(Cliente.class, id);
    }

    @Override
    @Transactional
    public List<Cliente> findAll() {
        List<Cliente> clientes =  
                            sessionFactory
                                .getCurrentSession()
                                .createQuery("from Cliente")
                                .list();
                
        return clientes;
    }

    @Override
    @Transactional
    public void create(Cliente entity) {
        sessionFactory.getCurrentSession().save(entity);
    }

    @Override
    @Transactional
    public void update(Cliente entity) {
        sessionFactory.getCurrentSession().update(entity);
    }

    @Override
    @Transactional
    public void delete(Cliente entity) {
        sessionFactory.getCurrentSession().delete(entity);
    }

    @Override
    @Transactional
    public void deleteById(long entityId) {
        Cliente temporal = this.findById(entityId);
        sessionFactory.getCurrentSession().delete(temporal);        
    }
    
}
