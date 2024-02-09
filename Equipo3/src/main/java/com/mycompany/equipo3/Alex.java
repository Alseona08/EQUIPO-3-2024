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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
    
    
    public static Libros insertarLibro(int libroid, String titulo, String autor, String descripcion, String estado, String categorianombre, Usuarios usuarioid){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Categorias categoria = null;
        if(getCategorias(categorianombre)){
            TypedQuery <Categorias> query=em.createQuery("select c from Categorias c where c.nombre=:CAT",Categorias.class);
            query.setParameter("CAT", categorianombre);
            categoria =query.getSingleResult();
        }else{
            categoria = new Categorias(getLastIdCategoria()+1,categorianombre);
        }
            em.persist(categoria);
            Libros lib = new Libros(libroid,titulo,autor,descripcion,estado,categoria,usuarioid);
            em.persist(lib);
        em.getTransaction().commit();
        return lib;
    }
    public static void insertarTransaccion(int transaccionid, String estado,Libros lib1,Libros lib2,Usuarios usu){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Transacciones trans = new Transacciones(transaccionid,estado,lib2,lib1,usu);
        em.persist(trans);
        em.getTransaction().commit();
    }
    
    public static void insertarUsuario(Usuarios usuario){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
    }
    
    
    public static Libros modificarLibro(Libros lib, String titulo, String autor, String descripcion, String estado, String categorianombre){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        
        if(getCategorias(categorianombre)){
            TypedQuery <Categorias> query=em.createQuery("select c from Categorias c where c.nombre=:CAT",Categorias.class);
            query.setParameter("CAT", categorianombre);
            Categorias cat=query.getSingleResult();
            lib.setCategoriaid(cat);
        }else{
            lib.getCategoriaid().setNombre(categorianombre);
        }
                 
        lib.setTitulo(titulo);
        lib.setAutor(autor);
        lib.setDescripcion(descripcion);
        lib.setEstado(estado);
        em.getTransaction().commit(); 
        return lib;
    }
    
    
    public static Transacciones selectTransaccion(int transaccionid){
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Transacciones tr=em.find(Transacciones.class, transaccionid,LockModeType.PESSIMISTIC_READ);
        em.getTransaction().commit(); 
        return tr;
        
    }
    public static int getLastIdCategoria(){
        EntityManager em = JPAUtil.getEntityManager();
        int id = 0;
        TypedQuery<Long> query1 = em.createQuery("Select count(c) from Categorias c",Long.class);
        Long count = query1.getSingleResult();
        TypedQuery<Integer> query = em.createQuery("Select max(c.categoriaid) from Categorias c",Integer.class);
        if(count !=0){
            id = query.getSingleResult();
        }
        return id;
    }
    public static int getLastIdLibro(){
        EntityManager em = JPAUtil.getEntityManager();
        int id = 0;
        TypedQuery<Long> query1 = em.createQuery("Select count(l) from Libros l",Long.class);
        Long count = query1.getSingleResult();
        TypedQuery<Integer> query = em.createQuery("Select max(l.libroid) from Libros l",Integer.class);
        if(count !=0){
        id = query.getSingleResult();
        }
        return id;
    }
    public static int getLastIdTransaccion(){
        EntityManager em = JPAUtil.getEntityManager();
        int id = 0;
        TypedQuery<Long> query1 = em.createQuery("Select count(t) from Transacciones t",Long.class);
        Long count = query1.getSingleResult();
        TypedQuery<Integer> query = em.createQuery("Select max(t.transaccionid) from Transacciones t",Integer.class);
        if(count !=0){
            id = query.getSingleResult();
        }
        return id;
    }
    
    public static boolean getCategorias(String cat){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery <Long> tq=em.createQuery("select count(c) from Categorias c where c.nombre=:nombre",Long.class);
        tq.setParameter("nombre", cat);
        Long aux=tq.getSingleResult();
        boolean sol=false;
        
        if(aux!=0){
            sol=true;
        }
        
        return sol;
    }
    
    
    
    public static void inicializaFactory(){
        emf = Persistence.createEntityManagerFactory ("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }
         
       
}
