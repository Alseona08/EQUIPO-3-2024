/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3.Model;

import com.mycompany.equipo3.Model.Usuarios;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
    private BigDecimal resenaid;
    @Column(name = "CONTENIDO")
    private String contenido;
    @Column(name = "CALIFICACION")
    private BigInteger calificacion;
    @JoinColumn(name = "LIBROID", referencedColumnName = "LIBROID")
    @ManyToOne
    private Libros libroid;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Usuarios usuarioid;

    public Resenas() {
    }

    public Resenas(BigDecimal resenaid) {
        this.resenaid = resenaid;
    }

    public BigDecimal getResenaid() {
        return resenaid;
    }

    public void setResenaid(BigDecimal resenaid) {
        this.resenaid = resenaid;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public BigInteger getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(BigInteger calificacion) {
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
        int hash = 0;
        hash += (resenaid != null ? resenaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Resenas)) {
            return false;
        }
        Resenas other = (Resenas) object;
        if ((this.resenaid == null && other.resenaid != null) || (this.resenaid != null && !this.resenaid.equals(other.resenaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Resenas[ resenaid=" + resenaid + " ]";
    }
    
}
