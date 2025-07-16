package Vista;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controlador.RegistroUsuarios;
import Controlador.AbrirNuevasVentanas;
import Modelo.Usuarios;

public class Interfaz extends javax.swing.JFrame {

    public Interfaz() {
        initComponents();
        loadIcons();
        loadLabel();
        btnTrans1();
        btnTrans2();
        btnTrans3();
    }
    
    private void loadIcons(){
        JpanelImage mImagen = new JpanelImage(ImgPanel, "/Imagenes/Interfaz.jpg");
        ImgPanel.add(mImagen).repaint();
    }
    
    private void loadLabel(){
        Icon mIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Título.png")).getImage()
                .getScaledInstance(ImgLabel.getWidth(), ImgLabel.getHeight(), 0));
        ImgLabel.setIcon(mIcono);
    }
    
    private void btnTrans1(){
        Ingresar.setContentAreaFilled(false);
        Ingresar.setOpaque(false);
        Ingresar.setBorderPainted(false);
    }
    
    private void btnTrans2(){
        Puntajes.setContentAreaFilled(false);
        Puntajes.setOpaque(false);
        Puntajes.setBorderPainted(false);
    }
    
    private void btnTrans3(){
        Salir.setContentAreaFilled(false);
        Salir.setOpaque(false);
        Salir.setBorderPainted(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImgPanel = new javax.swing.JPanel();
        Ingresar = new javax.swing.JButton();
        Puntajes = new javax.swing.JButton();
        Salir = new javax.swing.JButton();
        ImgLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Ingresar.setBackground(new java.awt.Color(0, 0, 0));
        Ingresar.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Ingresar.setForeground(new java.awt.Color(255, 255, 255));
        Ingresar.setText("Ingresar");
        Ingresar.setBorderPainted(false);
        Ingresar.setContentAreaFilled(false);
        Ingresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                IngresarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                IngresarMouseExited(evt);
            }
        });
        Ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IngresarActionPerformed(evt);
            }
        });

        Puntajes.setBackground(new java.awt.Color(0, 0, 0));
        Puntajes.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Puntajes.setForeground(new java.awt.Color(255, 255, 255));
        Puntajes.setText("Puntajes");
        Puntajes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                PuntajesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                PuntajesMouseExited(evt);
            }
        });
        Puntajes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PuntajesActionPerformed(evt);
            }
        });

        Salir.setBackground(new java.awt.Color(0, 0, 0));
        Salir.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Salir.setForeground(new java.awt.Color(255, 255, 255));
        Salir.setText("Salir");
        Salir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SalirMouseExited(evt);
            }
        });
        Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalirActionPerformed(evt);
            }
        });

        ImgLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Título.png"))); // NOI18N

        javax.swing.GroupLayout ImgPanelLayout = new javax.swing.GroupLayout(ImgPanel);
        ImgPanel.setLayout(ImgPanelLayout);
        ImgPanelLayout.setHorizontalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImgPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(ImgPanelLayout.createSequentialGroup()
                                .addComponent(Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Puntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ImgPanelLayout.createSequentialGroup()
                        .addGap(144, 144, 144)
                        .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        ImgPanelLayout.setVerticalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ingresar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Puntajes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Salir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_SalirActionPerformed

    private void IngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IngresarActionPerformed
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        anv.Ingreso();
        this.dispose();
    }//GEN-LAST:event_IngresarActionPerformed

    private void IngresarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarMouseEntered
        Ingresar.setForeground(Color.CYAN);
        Ingresar.setContentAreaFilled(true);
        Ingresar.setBorderPainted(true);
    }//GEN-LAST:event_IngresarMouseEntered

    private void IngresarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_IngresarMouseExited
        Ingresar.setForeground(Color.white);
        Ingresar.setContentAreaFilled(false);
        Ingresar.setBorderPainted(false);
    }//GEN-LAST:event_IngresarMouseExited

    private void PuntajesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PuntajesMouseEntered
        Puntajes.setForeground(Color.CYAN);
        Puntajes.setContentAreaFilled(true);
        Puntajes.setBorderPainted(true);
    }//GEN-LAST:event_PuntajesMouseEntered

    private void PuntajesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PuntajesMouseExited
        Puntajes.setForeground(Color.white);
        Puntajes.setContentAreaFilled(false);
        Puntajes.setBorderPainted(false);
    }//GEN-LAST:event_PuntajesMouseExited

    private void SalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseExited
        Salir.setForeground(Color.white);
        Salir.setContentAreaFilled(false);
        Salir.setBorderPainted(false);
    }//GEN-LAST:event_SalirMouseExited

    private void SalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SalirMouseEntered
        Salir.setForeground(Color.red);
        Salir.setContentAreaFilled(true);
        Salir.setBorderPainted(true);
    }//GEN-LAST:event_SalirMouseEntered

    private void PuntajesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PuntajesActionPerformed
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        anv.Puntajes();
        this.dispose();
    }//GEN-LAST:event_PuntajesActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JPanel ImgPanel;
    private javax.swing.JButton Ingresar;
    private javax.swing.JButton Puntajes;
    private javax.swing.JButton Salir;
    // End of variables declaration//GEN-END:variables
}
