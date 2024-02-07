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
    public static boolean checkUsuario(String nombre, String contraseña){
        boolean exists = false;
        TypedQuery<Usuarios> query = em.createQuery("Select u from Usuarios u where u.contrasena=:CONTRASENA AND u.nombre=:NOMBRE",Usuarios.class);
        Usuarios usuario = query.getSingleResult();
        if(usuario != null){
            exists = true;
        }
        return exists;
    }
}
