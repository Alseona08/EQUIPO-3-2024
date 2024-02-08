/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Resenas;
import com.mycompany.equipo3.Model.Transacciones;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JTextArea;

/**
 *
 * @author migue
 */

public class Gonzalo {
    
       
    public static void listadoRegistros(JTextArea txtArea){
        EntityManager em = JPAUtil.getEntityManager();
        Transacciones transaccion;
        TypedQuery<Transacciones> query = em.createQuery("SELECT t from Transacciones t",Transacciones.class);
        
        try{
            Collection<Transacciones> coleccion=query.getResultList();
            Iterator<Transacciones> it=coleccion.iterator();
            
            // Limpia el contenido del JTextArea
            txtArea.setText("");
            
            // Concatena los resultados en el JTextArea
            StringBuilder resultado = new StringBuilder();
            resultado.append("ID libro origen \tID libro destino \tEstado\n");
            
                    
            while (it.hasNext()){
                transaccion=it.next();
                resultado.append(transaccion.getLibroidOrigen().getTitulo());
                resultado.append(transaccion.getLibroidDestino().getTitulo());
                resultado.append(transaccion.getEstado());
                
            }
            txtArea.append(resultado.toString());
        }
        catch(NoResultException e){
            System.out.println("No hay datos en la base de datos.");
        } 
    }
    
    public static void consultaMasivaReseñaPorTituloYCalificacion(String titulo, int calificacion,JTextArea txtArea){
        EntityManager em = JPAUtil.getEntityManager();
        Resenas resena;
        TypedQuery<Resenas> query = em.createQuery("SELECT r from Resenas r WHERE r.libroid.titulo =: TITULOP AND r.calificacion =: CALIFICACIONP", Resenas.class);
        
        query.setParameter("TITULOP", titulo);
        query.setParameter("CALIFICACIONP", calificacion);
        
        try{
            Collection<Resenas> coleccion=query.getResultList();
            Iterator<Resenas> it=coleccion.iterator();
            
            // Limpia el contenido del JTextArea
            txtArea.setText("");

            // Concatena los resultados en el JTextArea
            StringBuilder resultado = new StringBuilder();
            resultado.append("ID reseña \tContenido \tCalificacion \tID libro \tID reseña \tID usuario\n");
            
            while(it.hasNext()){
                resena = it.next();
                resultado.append(resena.getResenaid()).append("\t");
                resultado.append(resena.getContenido()).append("\t");
                resultado.append(resena.getCalificacion()).append("\t");
                resultado.append(resena.getLibroid()).append("\t");
                resultado.append(resena.getResenaid()).append("\t");
                resultado.append(resena.getUsuarioid()).append("\t");
            }
            
            txtArea.append(resultado.toString());
           
        }
        catch(NoResultException e){
            txtArea.setText("NO HAY DATOS QUE CORRESPONDAN");
        } 
        
    }
   
    
     
    
    
   
    
    
    
}
