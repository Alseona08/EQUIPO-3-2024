/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;

/**
 *
 * @author migue
 */
public class Silvia {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    /**
     * Cuando un intercambio se acepte o el usuario que lo empezó decida eliminarlo se llamará a este método para borrarla de la BBDD
     * 
     * @param idTransaccion 
     */
    private static void borrarDatos(int idTransaccion) {  
        em.getTransaction().begin();
        Transacciones tr = em.find(Transacciones.class, idTransaccion, LockModeType.PESSIMISTIC_READ);
        
        em.remove(tr);
        em.getTransaction().commit();
    }
    
    
}
