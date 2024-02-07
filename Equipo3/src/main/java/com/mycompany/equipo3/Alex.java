/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Categorias;
import com.mycompany.equipo3.Model.Libros;
import com.mycompany.equipo3.Model.Usuarios;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
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
        System.out.println("Hola mundo");
        Usuarios usuario = new Usuarios(2,"Alejandro","adios","wasd");
        insertarUsuario(usuario);
        insertarLibro(2,"Don Quijote","Miguel De Cervantes","Obra maestra","Disponible","Fantasia",usuario);
        em.close();
        emf.close();
    }
    
    
    public static void insertarLibro(int libroid, String titulo, String autor, String descripcion, String estado, String categorianombre, Usuarios usuarioid) throws SQLException{
        em.getTransaction().begin();
        Categorias categoria = new Categorias(3,categorianombre);
        em.persist(categoria);
        Libros lib = new Libros(libroid,titulo,autor,descripcion,estado,categoria,usuarioid);
        em.persist(lib);
      
        em.getTransaction().commit();
    }
    
    public static void insertarUsuario(Usuarios usuario){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    
    
    
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
         
       
}
