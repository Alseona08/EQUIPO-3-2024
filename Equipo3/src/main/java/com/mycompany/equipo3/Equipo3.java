/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Transacciones;
import com.mycompany.equipo3.Model.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author migue
 */
public class Equipo3 {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static void main(String[] args) {
        inicializaFactory();
        em.close();
        emf.close();
    }
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
}
