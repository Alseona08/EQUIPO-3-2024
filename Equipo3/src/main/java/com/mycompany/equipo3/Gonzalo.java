/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author migue
 */

public class Gonzalo {
    
        private static EntityManagerFactory emf;
        private static EntityManager em;
        
    public static void listadoRegistros(){
        Transacciones transaccion;
        TypedQuery<Transacciones> query = em.createQuery("SELECT t from Transacciones t",Transacciones.class);
        
        try{
            Collection<Transacciones> coleccion=query.getResultList();
            Iterator<Transacciones> it=coleccion.iterator();
            
            System.out.print("TransaccionID \t");
            System.out.print("LibroID_Origen \t");
            System.out.print("LibroID_Destino \t");
            System.out.print("Estado");
                    
            while (it.hasNext()){
                transaccion=it.next();
                System.out.print(transaccion.getTransaccionid()+"\t");
                System.out.print(transaccion.getLibroidOrigen()+"\t");
                System.out.print(transaccion.getLibroidDestino()+"\t");
                System.out.println(transaccion.getEstado());
                
            }
        }
        catch(NoResultException e){
            System.out.println("No hay datos");
        } 
    }
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    
    public static void main(String[] args){
        inicializaFactory();
        System.out.println("hola");
        em.close();
        emf.close();
    }
    
}
