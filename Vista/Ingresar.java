
package Vista;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import Controlador.AbrirNuevasVentanas;

import javax.swing.JOptionPane;

public class Ingresar extends javax.swing.JFrame {

    public Ingresar() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
        loadIcons();
        loadLabel1();
        loadLabel2();
        btnTrans1();
        btnTrans2();
        btnTrans3();
        
    }
    
    private Controlador.RegistroUsuarios controlador;
    
    private void loadIcons(){
        JpanelImage mImagen = new JpanelImage(ImgPanel, "/Imagenes/Interfaz.jpg");
        ImgPanel.add(mImagen).repaint();
    }
    
    private void loadLabel1(){
        Icon mIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Ingresar.png")).getImage()
                .getScaledInstance(ImgLabel.getWidth(), ImgLabel.getHeight(), 0));
        ImgLabel.setIcon(mIcono);
    }
    
    private void loadLabel2(){
        Icon mIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Usuario.png")).getImage()
                .getScaledInstance(ImgLabel1.getWidth(), ImgLabel1.getHeight(), 0));
        ImgLabel1.setIcon(mIcono);
    }
    
    private void btnTrans1(){
        NuevoUs.setContentAreaFilled(false);
        NuevoUs.setBorderPainted(false);
    }
    
    private void btnTrans2(){
        ExisUs.setContentAreaFilled(false);
        ExisUs.setBorderPainted(false);
    }
    
    private void btnTrans3(){
        Volver.setContentAreaFilled(false);
        Volver.setBorderPainted(false);
    }
    
     public void mostrarMensaje(String mensaje, boolean esError) {
        int tipo = esError ? JOptionPane.ERROR_MESSAGE : JOptionPane.INFORMATION_MESSAGE;
        JOptionPane.showMessageDialog(this, mensaje, "Aviso", tipo);
    }
    
    public void setControlador(Controlador.RegistroUsuarios controlador) {
        this.controlador = controlador;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImgPanel = new javax.swing.JPanel();
        NuevoUs = new javax.swing.JButton();
        Volver = new javax.swing.JButton();
        ExisUs = new javax.swing.JButton();
        ImgLabel = new javax.swing.JLabel();
        ImgLabel1 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NuevoUs.setBackground(new java.awt.Color(0, 0, 0));
        NuevoUs.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        NuevoUs.setForeground(new java.awt.Color(255, 255, 255));
        NuevoUs.setText("Nuevo Usuario");
        NuevoUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                NuevoUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                NuevoUsMouseExited(evt);
            }
        });
        NuevoUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NuevoUsActionPerformed(evt);
            }
        });

        Volver.setBackground(new java.awt.Color(0, 0, 0));
        Volver.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        Volver.setForeground(new java.awt.Color(255, 255, 255));
        Volver.setText("Volver");
        Volver.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                VolverMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                VolverMouseExited(evt);
            }
        });
        Volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VolverActionPerformed(evt);
            }
        });

        ExisUs.setBackground(new java.awt.Color(0, 0, 0));
        ExisUs.setFont(new java.awt.Font("Monospaced", 1, 16)); // NOI18N
        ExisUs.setForeground(new java.awt.Color(255, 255, 255));
        ExisUs.setText("Usuario Existente");
        ExisUs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ExisUsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ExisUsMouseExited(evt);
            }
        });
        ExisUs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExisUsActionPerformed(evt);
            }
        });

        ImgLabel.setText("INGRESAR");

        ImgLabel1.setText("jLabel1");

        Usuario.setBackground(new java.awt.Color(0, 0, 0));
        Usuario.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        Usuario.setForeground(new java.awt.Color(204, 204, 204));
        Usuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        Usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImgPanelLayout = new javax.swing.GroupLayout(ImgPanel);
        ImgPanel.setLayout(ImgPanelLayout);
        ImgPanelLayout.setHorizontalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ImgPanelLayout.createSequentialGroup()
                        .addGap(198, 198, 198)
                        .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(ImgPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ImgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(NuevoUs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ImgPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ExisUs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(ImgPanelLayout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 61, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ImgPanelLayout.setVerticalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(ImgPanelLayout.createSequentialGroup()
                        .addComponent(ImgLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1))
                    .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NuevoUs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ExisUs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ImgPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        anv.Interfaz();
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    private void VolverMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseEntered
        Volver.setForeground(Color.red);
        Volver.setContentAreaFilled(true);
        Volver.setBorderPainted(true);        
    }//GEN-LAST:event_VolverMouseEntered

    private void VolverMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_VolverMouseExited
        Volver.setForeground(Color.white);
        Volver.setContentAreaFilled(false);
        Volver.setBorderPainted(false);  
    }//GEN-LAST:event_VolverMouseExited

    private void NuevoUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoUsMouseEntered
        NuevoUs.setForeground(Color.CYAN);
        NuevoUs.setContentAreaFilled(true);
        NuevoUs.setBorderPainted(true); 
    }//GEN-LAST:event_NuevoUsMouseEntered

    private void NuevoUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NuevoUsMouseExited
        NuevoUs.setForeground(Color.white);
        NuevoUs.setContentAreaFilled(false);
        NuevoUs.setBorderPainted(false); 
    }//GEN-LAST:event_NuevoUsMouseExited

    private void ExisUsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExisUsMouseEntered
        ExisUs.setForeground(Color.CYAN);
        ExisUs.setContentAreaFilled(true);
        ExisUs.setBorderPainted(true); 
    }//GEN-LAST:event_ExisUsMouseEntered

    private void ExisUsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExisUsMouseExited
        ExisUs.setForeground(Color.white);
        ExisUs.setContentAreaFilled(false);
        ExisUs.setBorderPainted(false); 
    }//GEN-LAST:event_ExisUsMouseExited

    private void UsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UsuarioActionPerformed

    private void NuevoUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NuevoUsActionPerformed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String nombre = Usuario.getText();
        if (controlador == null) {
            System.out.println("El controlador es null");
        } else {
            if (controlador.procesarLogin(nombre) == true){
                this.dispose();
            }
        }
    }//GEN-LAST:event_NuevoUsActionPerformed

    private void ExisUsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExisUsActionPerformed
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        String nombre = Usuario.getText().trim();
        if (controlador == null) {
            System.out.println("Controlador es null");
            return;
        }
        if(controlador.procesarIngresoExistente(nombre) == true){
            this.dispose();
        }

    }//GEN-LAST:event_ExisUsActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ExisUs;
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JLabel ImgLabel1;
    private javax.swing.JPanel ImgPanel;
    private javax.swing.JButton NuevoUs;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton Volver;
    // End of variables declaration//GEN-END:variables
}
