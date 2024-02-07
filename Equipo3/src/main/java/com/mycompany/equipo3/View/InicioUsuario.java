
package com.mycompany.equipo3.View;

import com.mycompany.equipo3.Miguel;

public class InicioUsuario extends javax.swing.JPanel {

    CamVis cv1;
    public InicioUsuario(CamVis cv1) {
        this.cv1 = cv1;
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TFUsuario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        PFContraseña = new javax.swing.JPasswordField();
        ButtonInicioSesionToAlbum = new javax.swing.JButton();
        ButtonIraRegistro = new javax.swing.JButton();
        TFMensaje = new javax.swing.JTextField();

        jLabel1.setText("Inicio Sesión");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        ButtonInicioSesionToAlbum.setText("Iniciar Sesion");
        ButtonInicioSesionToAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonInicioSesionToAlbumActionPerformed(evt);
            }
        });

        ButtonIraRegistro.setText("No tengo cuenta");
        ButtonIraRegistro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonIraRegistroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(TFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(108, 108, 108)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ButtonInicioSesionToAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ButtonIraRegistro))
                .addGap(105, 105, 105))
            .addGroup(layout.createSequentialGroup()
                .addGap(238, 238, 238)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TFUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PFContraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonIraRegistro)
                    .addComponent(ButtonInicioSesionToAlbum))
                .addGap(18, 18, 18)
                .addComponent(TFMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonInicioSesionToAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonInicioSesionToAlbumActionPerformed
        //Crear metodo que compruebe si dicho usuario esta, si esta deja continuar y si no muestre un mensaje de usuario no registrado
        String nombre = TFUsuario.getText();
        char[] password = PFContraseña.getPassword();
        String passw = new String(password);
        if(!nombre.isBlank() && !nombre.isEmpty() &&
           !passw.isBlank() && !passw.isEmpty()){
            if(Miguel.checkUsuarioLogin(nombre, passw)){
                cv1.cambiarVista(new Menu(cv1));
            }else{
                TFMensaje.setText("Usuario no encontrado, registrese");
            }
        }else{
            TFMensaje.setText("Usuario o contraseña vacios");
        }
    }//GEN-LAST:event_ButtonInicioSesionToAlbumActionPerformed

    private void ButtonIraRegistroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonIraRegistroActionPerformed
        cv1.cambiarVista(new RegistroUsuario(cv1));
    }//GEN-LAST:event_ButtonIraRegistroActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonInicioSesionToAlbum;
    private javax.swing.JButton ButtonIraRegistro;
    private javax.swing.JPasswordField PFContraseña;
    private javax.swing.JTextField TFMensaje;
    private javax.swing.JTextField TFUsuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
