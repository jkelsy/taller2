/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.controller;

import com.jk.taller2.dominio.Cliente;
import com.jk.taller2.servicio.ClienteFacade;
import com.jk.taller2.servicio.IClienteFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jk
 */
@Controller
public class ClienteController implements Serializable{
    
    @Autowired
    private IClienteFacade clienteFacade;
    
    private Cliente clienteInstance;
    private List<Cliente> clienteList;

    @PostConstruct
    public void inicio(){
        clienteInstance = new Cliente();
        clienteList = clienteFacade.findAll();
    }
    public List<Cliente> getClienteList() {        
        return clienteList;        
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }    

    public Cliente getClienteInstance() {
        return clienteInstance;
    }

    public void setClienteInstance(Cliente clienteInstance) {
        this.clienteInstance = clienteInstance;
    }
    
    public void guardar(){
        if(this.clienteInstance.getId() != null){
            clienteFacade.update(clienteInstance);
        }else{
            clienteFacade.create(clienteInstance);
        }
        
        inicio();
    }
    
    public void seleccionar(Cliente cliente){
        this.clienteInstance = cliente;
    }
    
}
