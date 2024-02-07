/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Libros;
import com.mycompany.equipo3.Model.Categorias;
import com.mycompany.equipo3.Model.Transacciones;
import com.mycompany.equipo3.Model.Usuarios;
import java.sql.PreparedStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author migue
 */
public class Silvia {
    private static EntityManagerFactory emf;
    private static EntityManager em;
    
    /**
     * Cuando un intercambio se acepte o el usuario que lo empezó decida eliminarlo se llamará a este método para borrarla de la BBDD
     * También borrará los libros asociados
     * 
     * @param idTransaccion 
     */
    private static void borrarTransaccion(int idTransaccion) {  
        em.getTransaction().begin();
        
        Transacciones tr = em.find(Transacciones.class, idTransaccion, LockModeType.PESSIMISTIC_READ);

        Libros libroOrigen = tr.getLibroidOrigen();
        Libros libroDestino = tr.getLibroidDestino();

        em.remove(tr);

        em.remove(libroOrigen);
        em.remove(libroDestino);

        em.getTransaction().commit();
    }

    
    /**
     * Pueden consultarse todas las transacciones que ofrezcan un libro con un titulo en particular
     * 
     * @param tituloLibro 
     */
    private static void consultaIntercambiosPorTitulo(String tituloLibro) {
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transacciones> query = cb.createQuery(Transacciones.class);
        
        Root<Transacciones> transRoot = query.from(Transacciones.class);
        Join<Transacciones, Libros> librosJoin = transRoot.join("libroidOrigen");
        
        query.select(transRoot).where(cb.equal(librosJoin.get("titulo"), tituloLibro));

        List<Transacciones> resultados = em.createQuery(query).getResultList();
        for (Transacciones transaccion : resultados) {
            System.out.println("ID de transacción: " + transaccion.getTransaccionid());
            System.out.println("Estado: " + transaccion.getEstado());
            System.out.println("ID de libro origen: " + transaccion.getLibroidOrigen().getLibroid());
            System.out.println("Título de libro origen: " + transaccion.getLibroidOrigen().getTitulo());
        }

        em.getTransaction().commit();
    }
    
    private static void consultaIntercambiosPorCategoria(String nombreCategoria) {
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Transacciones> query = cb.createQuery(Transacciones.class);

        Root<Transacciones> transRoot = query.from(Transacciones.class);
        Join<Transacciones, Libros> librosJoin = transRoot.join("libroidOrigen");
        Join<Libros, Categorias> categoriasJoin = librosJoin.join("categoriaid");

        query.select(transRoot).where(cb.equal(categoriasJoin.get("nombre"), nombreCategoria));

        List<Transacciones> resultados = em.createQuery(query).getResultList();
        for (Transacciones transaccion : resultados) {
            System.out.println("ID de transacción: " + transaccion.getTransaccionid());
            System.out.println("Estado: " + transaccion.getEstado());
            System.out.println("ID de libro origen: " + transaccion.getLibroidOrigen().getLibroid());
            System.out.println("Título de libro origen: " + transaccion.getLibroidOrigen().getTitulo());
        }

        // Confirmar la transacción
        em.getTransaction().commit();
    }
    
    private static void consultaTransaccionesUsuario(int idUsuario){
        em.getTransaction().begin();
        
        Usuarios usuario=em.find(Usuarios.class, idUsuario, LockModeType.PESSIMISTIC_READ);
        
        if(usuario!=null){
            
            Transacciones t;
            Collection<Transacciones> coleccion = usuario.getTransaccionesCollection();
            Iterator<Transacciones> it = coleccion.iterator();
            
            while(it.hasNext()){
                t=it.next();
                System.out.println("Libro ofrecido:");
                System.out.println(t.getLibroidOrigen());
                System.out.println("Libro pedido:");
                System.out.println(t.getLibroidDestino());
                System.out.println("Estado");
                System.out.println(t.getEstado());
            }
        }else{
            System.out.println("No existe el usuario");
        }
    }

    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
    
    public static void main(String[] args){
        inicializaFactory();
        
        em.close();
        emf.close();
    }
}
