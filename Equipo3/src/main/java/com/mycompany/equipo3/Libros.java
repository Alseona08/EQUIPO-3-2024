/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author migue
 */
@Entity
@Table(name = "LIBROS")
@NamedQueries({
    @NamedQuery(name = "Libros.findAll", query = "SELECT l FROM Libros l"),
    @NamedQuery(name = "Libros.findByLibroid", query = "SELECT l FROM Libros l WHERE l.libroid = :libroid"),
    @NamedQuery(name = "Libros.findByTitulo", query = "SELECT l FROM Libros l WHERE l.titulo = :titulo"),
    @NamedQuery(name = "Libros.findByAutor", query = "SELECT l FROM Libros l WHERE l.autor = :autor"),
    @NamedQuery(name = "Libros.findByDescripcion", query = "SELECT l FROM Libros l WHERE l.descripcion = :descripcion"),
    @NamedQuery(name = "Libros.findByEstado", query = "SELECT l FROM Libros l WHERE l.estado = :estado")})
public class Libros implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "LIBROID")
    private int libroid;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "AUTOR")
    private String autor;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Column(name = "ESTADO")
    private String estado;
    @OneToMany(mappedBy = "libroid")
    private Collection<Resenas> resenasCollection;
    @JoinColumn(name = "CATEGORIAID", referencedColumnName = "CATEGORIAID")
    @ManyToOne
    private Categorias categoriaid;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Usuarios usuarioid;
    @OneToMany(mappedBy = "libroidDestino")
    private Collection<Transacciones> transaccionesCollection;
    @OneToMany(mappedBy = "libroidOrigen")
    private Collection<Transacciones> transaccionesCollection1;

    public Libros() {
    }

    public Libros(int libroid, String titulo, String autor, String descripcion, String estado, Categorias categoriaid, Usuarios usuarioid) {
        this.libroid = libroid;
        this.titulo = titulo;
        this.autor = autor;
        this.descripcion = descripcion;
        this.estado = estado;
        this.categoriaid = categoriaid;
        this.usuarioid = usuarioid;
    }

    public Libros(int libroid) {
        this.libroid = libroid;
    }

    public int getLibroid() {
        return libroid;
    }

    public void setLibroid(int libroid) {
        this.libroid = libroid;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Collection<Resenas> getResenasCollection() {
        return resenasCollection;
    }

    public void setResenasCollection(Collection<Resenas> resenasCollection) {
        this.resenasCollection = resenasCollection;
    }

    public Categorias getCategoriaid() {
        return categoriaid;
    }

    public void setCategoriaid(Categorias categoriaid) {
        this.categoriaid = categoriaid;
    }

    public Usuarios getUsuarioid() {
        return usuarioid;
    }

    public void setUsuarioid(Usuarios usuarioid) {
        this.usuarioid = usuarioid;
    }

    public Collection<Transacciones> getTransaccionesCollection() {
        return transaccionesCollection;
    }

    public void setTransaccionesCollection(Collection<Transacciones> transaccionesCollection) {
        this.transaccionesCollection = transaccionesCollection;
    }

    public Collection<Transacciones> getTransaccionesCollection1() {
        return transaccionesCollection1;
    }

    public void setTransaccionesCollection1(Collection<Transacciones> transaccionesCollection1) {
        this.transaccionesCollection1 = transaccionesCollection1;
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
        final Libros other = (Libros) obj;
        if (this.libroid != other.libroid) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.resenasCollection, other.resenasCollection)) {
            return false;
        }
        if (!Objects.equals(this.categoriaid, other.categoriaid)) {
            return false;
        }
        if (!Objects.equals(this.usuarioid, other.usuarioid)) {
            return false;
        }
        if (!Objects.equals(this.transaccionesCollection, other.transaccionesCollection)) {
            return false;
        }
        return Objects.equals(this.transaccionesCollection1, other.transaccionesCollection1);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Libros[ libroid=" + libroid + " ]";
    }
    
}
