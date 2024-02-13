/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3.Model;

import com.mycompany.equipo3.Model.Usuarios;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "RESENAS")
@NamedQueries({
    @NamedQuery(name = "Resenas.findAll", query = "SELECT r FROM Resenas r"),
    @NamedQuery(name = "Resenas.findByResenaid", query = "SELECT r FROM Resenas r WHERE r.resenaid = :resenaid"),
    @NamedQuery(name = "Resenas.findByContenido", query = "SELECT r FROM Resenas r WHERE r.contenido = :contenido"),
    @NamedQuery(name = "Resenas.findByCalificacion", query = "SELECT r FROM Resenas r WHERE r.calificacion = :calificacion")})
public class Resenas implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "RESENAID")
    private int resenaid;
    @Column(name = "CONTENIDO")
    private String contenido;
    @Column(name = "CALIFICACION")
    private int calificacion;
    @JoinColumn(name = "LIBROID", referencedColumnName = "LIBROID")
    @ManyToOne
    private Libros libroid;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Usuarios usuarioid;

    public Resenas() {
    }

    public Resenas(int resenaid, String contenido, int calificacion, Libros libroid, Usuarios usuarioid) {
        this.resenaid = resenaid;
        this.contenido = contenido;
        this.calificacion = calificacion;
        this.libroid = libroid;
        this.usuarioid = usuarioid;
    }
    

    public Resenas(int resenaid) {
        this.resenaid = resenaid;
    }

    public int getResenaid() {
        return resenaid;
    }

    public void setResenaid(int resenaid) {
        this.resenaid = resenaid;
    }

    

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public Libros getLibroid() {
        return libroid;
    }

    public void setLibroid(Libros libroid) {
        this.libroid = libroid;
    }

    public Usuarios getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuarios usuarioid) {
        this.usuarioid = usuarioid;
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
        final Resenas other = (Resenas) obj;
        if (this.resenaid != other.resenaid) {
            return false;
        }
        if (!Objects.equals(this.contenido, other.contenido)) {
            return false;
        }
        if (!Objects.equals(this.calificacion, other.calificacion)) {
            return false;
        }
        if (!Objects.equals(this.libroid, other.libroid)) {
            return false;
        }
        return Objects.equals(this.usuarioid, other.usuarioid);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Resenas[ resenaid=" + resenaid + " ]";
    }
    
}