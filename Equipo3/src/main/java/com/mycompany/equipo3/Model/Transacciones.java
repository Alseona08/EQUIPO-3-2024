/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3.Model;

import java.io.Serializable;
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
@Table(name = "TRANSACCIONES")
@NamedQueries({
    @NamedQuery(name = "Transacciones.findAll", query = "SELECT t FROM Transacciones t"),
    @NamedQuery(name = "Transacciones.findByTransaccionid", query = "SELECT t FROM Transacciones t WHERE t.transaccionid = :transaccionid"),
    @NamedQuery(name = "Transacciones.findByEstado", query = "SELECT t FROM Transacciones t WHERE t.estado = :estado")})
public class Transacciones implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "TRANSACCIONID")
    private int transaccionid;
    @Column(name = "ESTADO")
    private String estado;
    @JoinColumn(name = "LIBROID_DESTINO", referencedColumnName = "LIBROID")
    @ManyToOne
    private Libros libroidDestino;
    @JoinColumn(name = "LIBROID_ORIGEN", referencedColumnName = "LIBROID")
    @ManyToOne
    private Libros libroidOrigen;
    @JoinColumn(name = "USUARIOID", referencedColumnName = "USUARIOID")
    @ManyToOne
    private Usuarios usuarioid;

    public Transacciones() {
    }

    public Transacciones(int transaccionid) {
        this.transaccionid = transaccionid;
    }

    public Transacciones(int transaccionid, String estado, Libros libroidDestino, Libros libroidOrigen, Usuarios usuarioid) {
        this.transaccionid = transaccionid;
        this.estado = estado;
        this.libroidDestino = libroidDestino;
        this.libroidOrigen = libroidOrigen;
        this.usuarioid = usuarioid;
    }
    
    public int getTransaccionid() {
        return transaccionid;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libros getLibroidDestino() {
        return libroidDestino;
    }

    public void setLibroidDestino(Libros libroidDestino) {
        this.libroidDestino = libroidDestino;
    }

    public Libros getLibroidOrigen() {
        return libroidOrigen;
    }

    public void setLibroidOrigen(Libros libroidOrigen) {
        this.libroidOrigen = libroidOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Transacciones other = (Transacciones) obj;
        if (this.transaccionid != other.transaccionid) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.libroidDestino, other.libroidDestino)) {
            return false;
        }
        return Objects.equals(this.libroidOrigen, other.libroidOrigen);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Transacciones[ transaccionid=" + transaccionid + " ]";
    }
    
}
