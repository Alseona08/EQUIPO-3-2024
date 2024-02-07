/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.equipo3;

import com.mycompany.equipo3.Model.Transacciones;
import com.mycompany.equipo3.Model.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
    public static void modificacionMasiva(int idUsuario){
        TypedQuery<Usuarios> query = em.createQuery("Select u from Usuarios u where u.idusuario=:IDUSUARIO",Usuarios.class);
        query.setParameter("IDUSUARIO",idUsuario);
        Usuarios usuario = query.getSingleResult();
        TypedQuery<Transacciones> query1 = em.createQuery("Select t from Transacciones t where t.usuarioid=:USUARIOID ",Transacciones.class);
        query1.setParameter("USUARIOID",usuario);
        List<Transacciones> lista = query1.getResultList();
        for(Transacciones t: lista){
            em.remove(t);
        }
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }
    public static boolean checkUsuarioLogin(String nombre, String contraseña){
        EntityManager em = JPAUtil.getEntityManager();
        boolean exists = false;
        TypedQuery<Long> query = em.createQuery("Select count(u) from Usuarios u where u.contrasena=:CONTRASENA AND u.nombre=:NOMBRE",Long.class);
        query.setParameter("CONTRASENA",contraseña);
        query.setParameter("NOMBRE", nombre);
        Long usuario = query.getSingleResult();
        if(usuario != 0){
            exists = true;
        }
        return exists;
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

    
}
