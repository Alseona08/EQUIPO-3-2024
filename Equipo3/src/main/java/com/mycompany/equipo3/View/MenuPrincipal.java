/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.equipo3.View;

import com.mycompany.equipo3.Model.Usuarios;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author migue
 */
public class MenuPrincipal extends javax.swing.JPanel {

    CamVis cv1;
    Usuarios usuario;
    public MenuPrincipal(CamVis cv1, Usuarios usuario) {
        this.cv1 = cv1;
        this.usuario = usuario;
        initComponents();
        
        jListOpciones.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    String[] info=null;
                    String opc = jListOpciones.getSelectedValue();
                    cambiarContenido(opc);
                }
            }
        });
    }
    
    private void añadirIntercambios() {
        InserModiTrans inser = new InserModiTrans(cv1, "Insertar", usuario);
        
        //jContenido se ajusta a la nueva vista
        jContenido.setLayout(new FlowLayout());
        
        // Limpiar los componentes anteriores de jContenido
        jContenido.removeAll();
        
        // Añadir el contenido de InicioUsuario a jContenido
        jContenido.add(inser);
        
        // Revalidar y repintar jContenido
        jContenido.revalidate();
        jContenido.repaint();
        
        if (!jContenido.isVisible()) {
            jContenido.setVisible(true);
        }
    }
    
    private void borrarIntercambios() {
        BorrarTransaccion brrTran = new BorrarTransaccion(cv1, usuario);
        
        //jContenido se ajusta a la nueva vista
        jContenido.setLayout(new FlowLayout());
        
        // Limpiar los componentes anteriores de jContenido
        jContenido.removeAll();
        
        // Añadir el contenido de InicioUsuario a jContenido
        jContenido.add(brrTran);
        
        // Revalidar y repintar jContenido
        jContenido.revalidate();
        jContenido.repaint();
        
        if (!jContenido.isVisible()) {
            jContenido.setVisible(true);
        }
    }
    
    private void buscarIntercambios() {
        MostrarIntercambios mosTran = new MostrarIntercambios(cv1);
        
        //jContenido se ajusta a la nueva vista
        jContenido.setLayout(new FlowLayout());
        
        // Limpiar los componentes anteriores de jContenido
        jContenido.removeAll();
        
        // Añadir el contenido de InicioUsuario a jContenido
        jContenido.add(mosTran);
        
        // Revalidar y repintar jContenido
        jContenido.revalidate();
        jContenido.repaint();
        
        if (!jContenido.isVisible()) {
            jContenido.setVisible(true);
        }
    }
    
    private void reseñas() {
        ConsultarReseñas res = new ConsultarReseñas();
        
        //jContenido se ajusta a la nueva vista
        jContenido.setLayout(new FlowLayout());
        
        // Limpiar los componentes anteriores de jContenido
        jContenido.removeAll();
        
        // Añadir el contenido de InicioUsuario a jContenido
        jContenido.add(res);
        
        // Revalidar y repintar jContenido
        jContenido.revalidate();
        jContenido.repaint();
        
        if (!jContenido.isVisible()) {
            jContenido.setVisible(true);
        }
    }
    
    private void cerrarSesion() {
        cv1.cambiarVista(new InicioUsuario(cv1));
    }

    
    /**
     * Método que a través de un switch nos llevará a los métodos creados para
     * mostrar las diferentes opciones
     *
     * @param elegido que opción se debe crear
     */
    private void cambiarContenido(String opc) {
        jContenido.removeAll();

        switch (opc) {
            case "Añadir Intercambios":
                añadirIntercambios();
                break;
            case "Mis Intercambios":
                borrarIntercambios();
                break;

            case "Buscar Intercambios":
                buscarIntercambios();
                break;

            case "Reseñas":
                reseñas();
                break;

            case "Cerrar Sesión":
                System.out.println("[TRAZA] CERRAR SESION");
                cerrarSesion();
                break;
        }

        jContenido.revalidate();
        jContenido.repaint();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jListOpciones = new javax.swing.JList<>();
        jContenido = new javax.swing.JPanel();

        jListOpciones.setBackground(new java.awt.Color(204, 204, 255));
        jListOpciones.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Añadir Intercambios", "Mis Intercambios", "Buscar Intercambios", "Reseñas", "Cerrar Sesión" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListOpciones);

        jContenido.setBackground(new java.awt.Color(255, 255, 255));
        jContenido.setPreferredSize(new java.awt.Dimension(617, 420));

        javax.swing.GroupLayout jContenidoLayout = new javax.swing.GroupLayout(jContenido);
        jContenido.setLayout(jContenidoLayout);
        jContenidoLayout.setHorizontalGroup(
            jContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 678, Short.MAX_VALUE)
        );
        jContenidoLayout.setVerticalGroup(
            jContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jContenido;
    private javax.swing.JList<String> jListOpciones;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}


