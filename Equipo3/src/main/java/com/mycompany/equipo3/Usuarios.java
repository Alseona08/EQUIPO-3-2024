/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Id
    @Basic(optional = false)
    @Column(name = "USUARIOID")
    private BigDecimal usuarioid;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "CORREOELECTRONICO")
    private String correoelectronico;
    @Column(name = "CONTRASENA")
    private String contrasena;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Resenas> resenasCollection;
    @OneToMany(mappedBy = "usuarioid")
    private Collection<Libros> librosCollection;

    public Usuarios() {
    }

    public Usuarios(BigDecimal usuarioid) {
        this.usuarioid = usuarioid;
    }

    public BigDecimal getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(BigDecimal usuarioid) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioid != null ? usuarioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuarios)) {
            return false;
        }
        Usuarios other = (Usuarios) object;
        if ((this.usuarioid == null && other.usuarioid != null) || (this.usuarioid != null && !this.usuarioid.equals(other.usuarioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Usuarios[ usuarioid=" + usuarioid + " ]";
    }
    
}
