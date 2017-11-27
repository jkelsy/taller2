/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.servicio;

import com.jk.taller2.dominio.Cliente;
import java.util.List;

/**
 *
 * @author jk
 */
public interface IClienteFacade {
    
    Cliente findById(long id);

    List<Cliente> findAll();

    void create(Cliente entity);

    void update(Cliente entity);

    void delete(Cliente entity);

    void deleteById(long entityId);
    
}
