/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.controller;

import com.jk.taller2.dominio.Cliente;
import com.jk.taller2.servicio.ClienteFacade;
import com.jk.taller2.servicio.IClienteFacade;
import com.jk.taller2.servicio.IUploadArchivoFacade;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import org.primefaces.event.FileUploadEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author jk
 */
@Controller
public class ArchivoController implements Serializable{
    
    @Autowired
    private IUploadArchivoFacade archivoFacade;
    
    List<String> archivoList;

    public List<String> getArchivoList() {
        return archivoList;
    }

    public void setArchivoList(List<String> archivoList) {
        this.archivoList = archivoList;
    }
    
    @PostConstruct
    public void inicio(){
        //se puede mejorar cargando la ruta de un archivo de configuración
        archivoList = archivoFacade.getFiles("/home/files/taller2/");
    }
    
    public void cargar(FileUploadEvent event){
        archivoFacade.upload(event, "/home/files/taller2/");
        inicio();
    }
    
}
