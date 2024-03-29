/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.equipo3.View;

import com.mycompany.equipo3.Model.Usuarios;
import com.mycompany.equipo3.Silvia;
import java.util.ArrayList;
import javax.swing.DefaultListModel;

/**
 * Mostrará todos los intercambios empezados por otros usuarios, nunca el del propio usuario
 * 
 * @author b15-08m
 */
public class MostrarIntercambios extends javax.swing.JPanel {
    
    private int idUsuario=1;

    CamVis cv1;
    Usuarios usuario;
    private int idTransaccionSeleccionada;
    public MostrarIntercambios(CamVis cv1, Usuarios usu) {
        this.cv1 = cv1;
        this.usuario=usu;
        initComponents();
        lblNull.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();
        btnTitulo = new java.awt.Button();
        jLabel2 = new javax.swing.JLabel();
        txtTitulo = new java.awt.TextField();
        jLabel3 = new javax.swing.JLabel();
        txtCategoria = new java.awt.TextField();
        btnCategoria = new java.awt.Button();
        lblNull = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();

        jLabel1.setText("MOSTRAR INTERCAMBIOS");

        btnConfirmar.setText("Aceptar intercambio");
        btnConfirmar.setActionCommand("");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        btnTitulo.setActionCommand("btnBuscarTitulo");
        btnTitulo.setLabel("Buscar por título");
        btnTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTituloActionPerformed(evt);
            }
        });

        jLabel2.setText("Busque el título que quiera");

        jLabel3.setText("Busque por categoría");

        btnCategoria.setActionCommand("btnBuscarTitulo");
        btnCategoria.setLabel("Buscar por categoría");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        lblNull.setText("No se encontró ningún intercambio de su interés");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblNull, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfirmar))
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 152, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(174, 174, 174)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConfirmar)
                    .addComponent(lblNull))
                .addGap(22, 22, 22))
        );

        btnTitulo.getAccessibleContext().setAccessibleName("btnBuscarTitulo");
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String itemSeleccionado = (String) jList1.getSelectedValue();

        // Encontrar la posición del primer espacio en el texto
        int espacioIndex = itemSeleccionado.indexOf(' ');

        // Extraer la parte del texto correspondiente al ID de la transacción
        String idTransaccionString = itemSeleccionado.substring(0, espacioIndex);

        // Convertir el ID de transacción a entero
        idTransaccionSeleccionada = Integer.parseInt(idTransaccionString);
        
        Silvia.borrarTransaccion(idTransaccionSeleccionada);
        
        DefaultListModel<String> modeloLista = (DefaultListModel<String>) jList1.getModel();
        modeloLista.clear();
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTituloActionPerformed
        lblNull.setVisible(false);
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        modeloLista.clear();
    
        String titulo = txtTitulo.getText();
        ArrayList<String> consulta = Silvia.consultaIntercambiosPorTitulo(titulo, usuario.getUsuarioid());
        
        if(consulta==null){
            lblNull.setVisible(true);
        }else{
            for (String c : consulta) {
                modeloLista.addElement(c);
            }

            // Establecer el modelo de lista en el JList
            jList1.setModel(modeloLista);
        }
    }//GEN-LAST:event_btnTituloActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        lblNull.setVisible(false);
        DefaultListModel<String> modeloLista = new DefaultListModel<>();
        modeloLista.clear();
        
        String categoria=txtCategoria.getText().toString();
        ArrayList<String> consulta = Silvia.consultaIntercambiosPorCategoria(categoria, usuario.getUsuarioid());
        
        if(consulta==null){
            lblNull.setVisible(true);
        }else{
            for (String c : consulta) {
                modeloLista.addElement(c);
            }

            // Establecer el modelo de lista en el JList
            jList1.setModel(modeloLista);
        }
    }//GEN-LAST:event_btnCategoriaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnCategoria;
    private javax.swing.JButton btnConfirmar;
    private java.awt.Button btnTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNull;
    private java.awt.TextField txtCategoria;
    private java.awt.TextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
