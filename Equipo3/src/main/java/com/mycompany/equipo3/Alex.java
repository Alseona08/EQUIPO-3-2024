/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Categorias;
import com.mycompany.equipo3.Model.Libros;
import com.mycompany.equipo3.Model.Transacciones;
import com.mycompany.equipo3.Model.Usuarios;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
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
        //Usuarios usuario = new Usuarios(1,"Miguel","Hola","wasd");
        //insertarUsuario(usuario);
        //insertarLibro(4,"Mistborn","Sanderson","Obra maestra 2","Disponible","Fantasía",usuario);
        em.close();
        emf.close();
    }
    
    
    private static void insertarLibro(int libroid, String titulo, String autor, String descripcion, String estado, String categorianombre, Usuarios usuarioid) throws SQLException{
        em.getTransaction().begin();
        Categorias categoria = new Categorias(3,categorianombre);
        em.persist(categoria);
        Libros lib = new Libros(libroid,titulo,autor,descripcion,estado,categoria,usuarioid);
        em.persist(lib);
      
        em.getTransaction().commit();
    }
    
    public static void insertarUsuario(Usuarios usuario){
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    
    private static void modificarLibro(Libros lib, String titulo, String autor, String descripcion, String estado,int categoriaid, String categorianombre){
        em.getTransaction().begin();
       
        lib.getCategoriaid().setNombre(categorianombre);
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setDescripcion(descripcion);
        lib.setEstado(estado);
        em.getTransaction().commit(); 
    }
    
    
    public static Transacciones selectTransaccion(int transaccionid){
        em.getTransaction().begin();
        Transacciones tr=em.find(Transacciones.class, transaccionid,LockModeType.PESSIMISTIC_READ);
        em.getTransaction().commit(); 
        return tr;
        
    }
    
    
    
    
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
         
       
}
