/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.servicio;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author jk
 */
public interface IUploadArchivoFacade {
    
    public void upload(FileUploadEvent event, String directorio);
    public List<String> getFiles(String directorio);
    
}
