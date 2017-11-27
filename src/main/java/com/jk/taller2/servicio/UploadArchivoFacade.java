/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.servicio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.primefaces.event.FileUploadEvent;
import org.springframework.stereotype.Component;

/**
 *
 * @author jk
 */
@Component
public class UploadArchivoFacade implements IUploadArchivoFacade {
    
    @Override
    public void upload(FileUploadEvent event, String directorio) {
        InputStream input = null;
        OutputStream output = null;
        String extension;
        String nombre;
        
        try {
            input = event.getFile().getInputstream();        
            
            extension = FilenameUtils.getExtension(event.getFile().getFileName());
            nombre = FilenameUtils.getBaseName(event.getFile().getFileName());
            
            while(Files.exists(Paths.get(directorio+nombre+"."+extension))){                
                nombre="_"+nombre;
            }

            output = new FileOutputStream(new File(directorio, nombre+"."+extension));
            IOUtils.copy(input, output);            

        } catch (IOException e) {
            System.err.println("Error al subir el archivo al servidor " + e.getMessage());            
        } finally {
            IOUtils.closeQuietly(input);
            IOUtils.closeQuietly(output);
        }
    }

    @Override
    public List<String> getFiles(String directorio) {
        List<String> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(Paths.get(directorio))) {
            for (Path path : directoryStream) {
                fileNames.add(path.toString());
            }
        } catch (IOException ex) {}
        return fileNames;
    }
    
}
