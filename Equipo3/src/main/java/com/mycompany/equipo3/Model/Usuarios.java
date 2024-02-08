/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3.Model;

import com.mycompany.equipo3.Model.Transacciones;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "USUARIOS")
@NamedQueries({
    @NamedQuery(name = "Usuarios.findAll", query = "SELECT u FROM Usuarios u"),
    @NamedQuery(name = "Usuarios.findByUsuarioid", query = "SELECT u FROM Usuarios u WHERE u.usuarioid = :usuarioid"),
    @NamedQuery(name = "Usuarios.findByNombre", query = "SELECT u FROM Usuarios u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuarios.findByCorreoelectronico", query = "SELECT u FROM Usuarios u WHERE u.correoelectronico = :correoelectronico"),
    @NamedQuery(name = "Usuarios.findByContrasena", query = "SELECT u FROM Usuarios u WHERE u.contrasena = :contrasena")})
public class Usuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id @GeneratedValue
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private int usuarioid;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CORREOELECTRONICO")
    private String correoelectronico;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Resenas> resenasCollection;
    @OneToMany(mappedBy = "usuarioid",orphanRemoval=true)
    private Collection<Libros> librosCollection;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Transacciones> transaccionesCollection;

    public Usuarios() {
    }
    public Usuarios(String nombre, String correoelectronico, String contrasena) {
        
        this.nombre = nombre;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
    }
    public Usuarios(int usuarioid, String nombre, String correoelectronico, String contrasena) {
        this.usuarioid = usuarioid;
        this.nombre = nombre;
        this.correoelectronico = correoelectronico;
        this.contrasena = contrasena;
        this.resenasCollection = null;
        this.librosCollection = null;
        this.transaccionesCollection = null;
    }
    
    

    public Usuarios(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public int getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Collection<Resenas> getResenasCollection() {
        return resenasCollection;
    }

    public void setResenasCollection(Collection<Resenas> resenasCollection) {
        this.resenasCollection = resenasCollection;
    }

    public Collection<Libros> getLibrosCollection() {
        return librosCollection;
    }

    public void setLibrosCollection(Collection<Libros> librosCollection) {
        this.librosCollection = librosCollection;
    }

    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }
    

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Usuarios other = (Usuarios) obj;
        if (this.usuarioid != other.usuarioid) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.correoelectronico, other.correoelectronico)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        if (!Objects.equals(this.resenasCollection, other.resenasCollection)) {
            return false;
        }
        return Objects.equals(this.librosCollection, other.librosCollection);
    }

    

    

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Usuarios[ usuarioid=" + usuarioid + " ]";
    }
    
}