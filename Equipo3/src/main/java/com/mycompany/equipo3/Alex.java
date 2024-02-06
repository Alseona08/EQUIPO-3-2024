/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author migue
 */
public class Alex {
    private static EntityManagerFactory emf;
    private static EntityManager em;

    public static void main(String[] args) throws SQLException {
        inicializaFactory();
        
        insertarLibro(1,"Don Quijote","Miguel De Cervantes","Obra maestra","Disponible",3,2);
        em.close();
        emf.close();
    }
    
    
    private static void insertarLibro(int libroid, String titulo, String autor, String descripcion, String estado, Categorias categoriaid, Usuarios usuarioid) throws SQLException{

        
        em.getTransaction().begin();
        Libros lib = new Libros(libroid,titulo,autor,descripcion,estado,categoriaid,usuarioid);
        em.persist(lib);
      
        em.getTransaction().commit();
    }
    
    
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
         
       
}
