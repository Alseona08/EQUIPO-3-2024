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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
     * Cuando un intercambio se acepte o el usuario que lo empezó decida
     * eliminarlo se llamará a este método para borrarla de la BBDD También
     * borrará los libros asociados
     *
     * @param idTransaccion
     */
    public static void borrarTransaccion(int idTransaccion) {
        inicializaFactory();
        em.getTransaction().begin();

        Transacciones tr = em.find(Transacciones.class, idTransaccion, LockModeType.PESSIMISTIC_READ);

        Libros libroOrigen = tr.getLibroidOrigen();
        Libros libroDestino = tr.getLibroidDestino();

        em.remove(tr);

        em.remove(libroOrigen);
        em.remove(libroDestino);

        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }

    /**
     * Pueden consultarse todas las transacciones que ofrezcan un libro con un
     * titulo en particular, comprobando que no sean del usuario que busca la transaccion
     *
     * @param tituloLibro
     * @param idUsuario
     */
    public static ArrayList<String> consultaIntercambiosPorTitulo(String tituloLibro, int idUsuario) {
        inicializaFactory();

        ArrayList<String> result = new ArrayList<>();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transacciones> query = cb.createQuery(Transacciones.class);

        Root<Transacciones> transRoot = query.from(Transacciones.class);
        Join<Transacciones, Libros> librosOrigenJoin = transRoot.join("libroidOrigen");
        Join<Transacciones, Usuarios> usuarioJoin = transRoot.join("usuarioid");

        query.select(transRoot).where(
            cb.and(
                cb.equal(librosOrigenJoin.get("titulo"), tituloLibro),
                cb.notEqual(usuarioJoin.get("usuarioid"), idUsuario)
            )
        );

        List<Transacciones> resultados = em.createQuery(query).getResultList();
        
        if (resultados.isEmpty()) {
            // No se encontraron transacciones, devuelve null
            em.getTransaction().commit();
            em.close();
            emf.close();
            return null;
        }
        
        for (Transacciones t : resultados) {
            String consulta = t.toString();
            System.out.println(consulta);
            result.add(consulta);
        }

        // Confirmar la transacción
        em.getTransaction().commit();

        em.close();
        emf.close();

        return result;
    }

    /**
     * Pueden consultarse todas las transacciones que ofrezcan un libro con una
     * categoria en particular, comprobando que no sean del usuario que busca la transaccion
     * 
     * @param nombreCategoria
     * @param idUsuario
     * @return 
     */
    public static ArrayList<String> consultaIntercambiosPorCategoria(String nombreCategoria, int idUsuario) {
        inicializaFactory();

        ArrayList<String> result = new ArrayList<>();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Transacciones> query = cb.createQuery(Transacciones.class);

        Root<Transacciones> transRoot = query.from(Transacciones.class);
        Join<Transacciones, Libros> librosOrigenJoin = transRoot.join("libroidOrigen");
        Join<Libros, Categorias> categoriasJoin = librosOrigenJoin.join("categoriaid");
        Join<Transacciones, Usuarios> usuarioJoin = transRoot.join("usuarioid");

        query.select(transRoot).where(
            cb.and(
                cb.equal(categoriasJoin.get("nombre"), nombreCategoria),
                cb.notEqual(usuarioJoin.get("usuarioid"), idUsuario)
            )
        );

        List<Transacciones> resultados = em.createQuery(query).getResultList();
        
        if (resultados.isEmpty()) {
            // No se encontraron transacciones, devuelve null
            em.getTransaction().commit();
            em.close();
            emf.close();
            return null;
        }
        
        for (Transacciones t : resultados) {
            String consulta = t.toString();
            System.out.println(consulta);
            result.add(consulta);
        }

        // Confirmar la transacción
        em.getTransaction().commit();

        em.close();
        emf.close();

        return result;
    }

    /**
     * Devuelve solo las transacciones del usuario 
     * 
     * @param idUsuario
     * @return 
     */
    public static ArrayList<String> consultaTransaccionesUsuario(int idUsuario) {
        System.out.println("[TRAZA] DENTRO");
        inicializaFactory();
        System.out.println("[TRAZA] INICIADO");
        String consulta = "";
        ArrayList<String> result = new ArrayList();
        em.getTransaction().begin();

        Usuarios usuario = em.find(Usuarios.class, idUsuario, LockModeType.PESSIMISTIC_READ);

        Transacciones t;
        Collection<Transacciones> coleccion = usuario.getTransaccionesCollection();
        Iterator<Transacciones> it = coleccion.iterator();

        while (it.hasNext()) {
            t = it.next();
            consulta = t.toString();
            System.out.println(consulta);
            result.add(consulta);
        }
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();

        return result;
    }
    
    /**
     * Modificado masivo con JPQL, un usuario podrá cambiar el estado de los libros cuyo estado 
     * y autor coincida con los pasados por parametro
     * 
     * @param estadoNuevo
     * @param estadoAnterior
     * @param autor
     * @param idUsuario 
     */
    public static boolean modificarEstadoLibros(String estadoNuevo, String estadoAnterior, String autor, int idUsuario) {
        inicializaFactory();
        em.getTransaction().begin();
        
        boolean cambioRealizado = false;

        TypedQuery<Transacciones> query = em.createQuery(
                "SELECT t " +
                        "FROM Transacciones t " +
                        "WHERE t.usuarioid.usuarioid = :idUsuario " +
                        "AND t.libroidOrigen.estado = :estadoAnterior " +
                        "AND t.libroidOrigen.autor = :autor",
                Transacciones.class);

        query.setParameter("idUsuario", idUsuario);
        query.setParameter("estadoAnterior", estadoAnterior);
        query.setParameter("autor", autor);


        for (Transacciones transaccion : query.getResultList()) {
            transaccion.getLibroidOrigen().setEstado(estadoNuevo);
            cambioRealizado = true;
        }

        em.getTransaction().commit();
        
        em.close();
        emf.close();
        
        return cambioRealizado;
    }

    /**
     * Llama al namedquery que busca un libro por su id
     * 
     * @param id
     * @return 
     */
    public static Libros buscarLibroPorId(int id) {
        inicializaFactory();
        em.getTransaction().begin();
        
        try {
            Query query = em.createNamedQuery("Libros.findByLibroid");
            query.setParameter("libroid", id);
        
            return (Libros) query.getSingleResult();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
                emf.close();
            }
        }
    }

    public static void inicializaFactory() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_Equipo3_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
    }

    public static void main(String[] args) {
        inicializaFactory();

        em.close();
        emf.close();
    }
}
