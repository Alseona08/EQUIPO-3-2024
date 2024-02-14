/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Libros;
import com.mycompany.equipo3.Model.Resenas;
import com.mycompany.equipo3.Model.Transacciones;
import com.mycompany.equipo3.Model.Usuarios;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author migue
 */
public class Miguel {
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
    public static void borradoMasivo(Usuarios usu){
        EntityManager em = JPAUtil.getEntityManager();
        
        Query query3 = em.createQuery("delete from Transacciones where usuarioid=:idUsuarioV");
        query3.setParameter("idUsuarioV",usu);
        em.getTransaction().begin();
        int deleteCount3 = query3.executeUpdate();
        em.getTransaction().commit();
        
        Query query1 = em.createQuery("delete from Resenas where usuarioid=:idUsuarioV");
        query1.setParameter("idUsuarioV",usu);
        em.getTransaction().begin();
        int deleteCount1 = query1.executeUpdate();
        em.getTransaction().commit();
        
        Query query2 = em.createQuery("delete from Libros where usuarioid=:idUsuarioV");
        query2.setParameter("idUsuarioV",usu);
        em.getTransaction().begin();
        int deleteCount2 = query2.executeUpdate();
        em.getTransaction().commit();
        System.out.println(deleteCount1);
        System.out.println(deleteCount2);
        System.out.println(deleteCount3);
        
        Query query = em.createQuery("DELETE FROM Usuarios u WHERE u.usuarioid = :idUsuario");
        query.setParameter("idUsuario", usu.getUsuarioid());
        em.getTransaction().begin();
        int deleteCount = query.executeUpdate();
        em.getTransaction().commit();
    }
    
    public static boolean checkUsuarioRegistro(String mail){
        EntityManager em = JPAUtil.getEntityManager();
        boolean exists = true;
        TypedQuery<Long> query = em.createQuery("Select count(u) from Usuarios u where u.correoelectronico=:MAIL",Long.class);
        query.setParameter("MAIL", mail);
        Long usuario = query.getSingleResult();
        if(usuario != 0){
            exists = false;
        }
        return exists; 
    }
    public static Usuarios getUsuarioLoged(String nombre, String contraseña){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Usuarios> query = em.createQuery("Select u from Usuarios u where u.contrasena=:CONTRASENA AND u.nombre=:NOMBRE",Usuarios.class);
        query.setParameter("CONTRASENA",contraseña);
        query.setParameter("NOMBRE", nombre);
        Usuarios usuario = query.getSingleResult();
        return usuario; 
    }
    public static int getLastIdUsuario(){
        EntityManager em = JPAUtil.getEntityManager();
        int id = 0;
        TypedQuery<Long> query1 = em.createQuery("Select count(u) from Usuarios u",Long.class);
        Long count = query1.getSingleResult();
        TypedQuery<Integer> query = em.createQuery("Select max(u.usuarioid) from Usuarios u",Integer.class);
        if(count != 0){
            id = query.getSingleResult();
        }
        return id;
    }

    public static boolean checkUsuarioLogin(String nombre, String passw) {
        EntityManager em = JPAUtil.getEntityManager();
        boolean exists = false;
        TypedQuery<Long> query = em.createQuery("Select count(u) from Usuarios u where u.contrasena=:CONTRASENA AND u.nombre=:NOMBRE",Long.class);
        query.setParameter("CONTRASENA",passw);
        query.setParameter("NOMBRE", nombre);
        Long usuario = query.getSingleResult();
        if(usuario != 0){
            exists = true;
        }
        return exists;
    }
    public static List<String> selectTitulos(){
        EntityManager em = JPAUtil.getEntityManager();
        TypedQuery<Object[]> query = em.createQuery("SELECT l.libroid, l.titulo FROM Libros l", Object[].class);
        List<Object[]> resultList = query.getResultList();
        List<String> lista = new ArrayList<>();

        for (Object[] row : resultList) {
            int id = (int) row[0]; // Suponiendo que el ID es de tipo BigDecimal
            String titulo = (String) row[1];
            String item = id + " - " + titulo;
            lista.add(item);
        }

        em.close();
        return lista;
    }
    public static void insertResena(int id, String contenido,int calif, Libros libId, Usuarios usuId){
        EntityManager em =JPAUtil.getEntityManager();
        em.getTransaction().begin();
        Resenas res = new Resenas(id,contenido,calif,libId,usuId);
        em.persist(res);
        em.getTransaction().commit();
    }
    public static int getLastIdResena(){
        EntityManager em = JPAUtil.getEntityManager();
        int id = 1;
        TypedQuery<Long> query1 = em.createQuery("Select count(c) from Resenas c",Long.class);
        Long count = query1.getSingleResult();
        if(count !=0){
            TypedQuery<Integer> query = em.createQuery("Select max(c.categoriaid) from Resenas c",Integer.class);
            id = query.getSingleResult();
        }
        return id;
    }
    
}
