/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3.Model;

import java.io.Serializable;
import java.math.BigDecimal;
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
    private BigDecimal transaccionid;
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

    public Transacciones(BigDecimal transaccionid) {
        this.transaccionid = transaccionid;
    }

    public BigDecimal getTransaccionid() {
        return transaccionid;
    }

    public void setTransaccionid(BigDecimal transaccionid) {
        this.transaccionid = transaccionid;
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
        int hash = 0;
        hash += (transaccionid != null ? transaccionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Transacciones)) {
            return false;
        }
        Transacciones other = (Transacciones) object;
        if ((this.transaccionid == null && other.transaccionid != null) || (this.transaccionid != null && !this.transaccionid.equals(other.transaccionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.equipo3.Transacciones[ transaccionid=" + transaccionid + " ]";
    }
    
}
