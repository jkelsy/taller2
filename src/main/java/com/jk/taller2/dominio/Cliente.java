/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jk.taller2.dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author jk
 */
@Entity
@Table(name = "thom_cliente")
public class Cliente implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nmcliente")
    private Long id;
    
    @Basic 
    @Column(length = 15)
    private String cdcliente;
    
    @Basic
    @Column(length = 120, nullable = false)
    private String dsnombre;
    
    @Basic
    @Column(length = 120)
    private String dsdireccion;
    
    @Basic
    @Column(length = 120)
    private String dsmail;    
   
    @Column(nullable = false)    
    private Date feregistro;
    
    @Column(nullable = false)    
    private Date febaja;
    
    @Basic
    @Column(length = 120, nullable = false)
    private String cdusuario;
    
    @Basic
    @Column(length = 1)
    private String snactivo;
    
    @Basic
    @Column(length = 60)
    private String cdtelefono;
    
    @Basic
    @Column(length = 120)
    private String dscontacto;
    
    @Basic
    @Column(length = 50)
    private String dslogo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCdcliente() {
        return cdcliente;
    }

    public void setCdcliente(String cdcliente) {
        this.cdcliente = cdcliente;
    }

    public String getDsnombre() {
        return dsnombre;
    }

    public void setDsnombre(String dsnombre) {
        this.dsnombre = dsnombre;
    }

    public String getDsdireccion() {
        return dsdireccion;
    }

    public void setDsdireccion(String dsdireccion) {
        this.dsdireccion = dsdireccion;
    }

    public String getDsmail() {
        return dsmail;
    }

    public void setDsmail(String dsmail) {
        this.dsmail = dsmail;
    }

    public Date getFeregistro() {
        return feregistro;
    }

    public void setFeregistro(Date feregistro) {
        this.feregistro = feregistro;
    }

    public Date getFebaja() {
        return febaja;
    }

    public void setFebaja(Date febaja) {
        this.febaja = febaja;
    }

    public String getCdusuario() {
        return cdusuario;
    }

    public void setCdusuario(String cdusuario) {
        this.cdusuario = cdusuario;
    }

    public String getSnactivo() {
        return snactivo;
    }

    public void setSnactivo(String snactivo) {
        this.snactivo = snactivo;
    }

    public String getCdtelefono() {
        return cdtelefono;
    }

    public void setCdtelefono(String cdtelefono) {
        this.cdtelefono = cdtelefono;
    }

    public String getDscontacto() {
        return dscontacto;
    }

    public void setDscontacto(String dscontacto) {
        this.dscontacto = dscontacto;
    }

    public String getDslogo() {
        return dslogo;
    }

    public void setDslogo(String dslogo) {
        this.dslogo = dslogo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + dsnombre + '}';
    }
    
    
}
