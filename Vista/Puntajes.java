package Vista;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import Modelo.Usuarios;
import java.util.List;
import javax.swing.table.DefaultTableModel;


import Controlador.AbrirNuevasVentanas;
import java.awt.Font;

public class Puntajes extends javax.swing.JFrame {

    public Puntajes(List<Usuarios> rankingUsuarios) {
        initComponents();
        loadIcons();
        loadLabel();
        btnTrans();
        llenarTabla(rankingUsuarios);
    }
    
    private void loadIcons(){
        JpanelImage mImagen = new JpanelImage(ImgPanel, "/Imagenes/Interfaz.jpg");
        ImgPanel.add(mImagen).repaint();
    }
    
    private void loadLabel(){
        Icon mIcono = new ImageIcon(new ImageIcon(getClass().getResource("/Imagenes/Puntajes.png")).getImage()
                .getScaledInstance(ImgLabel.getWidth(), ImgLabel.getHeight(), 0));
        ImgLabel.setIcon(mIcono);
    }
    
    private void btnTrans(){
        Volver.setContentAreaFilled(false);
        Volver.setBorderPainted(false);
    }
    
    private void llenarTabla(List<Usuarios> lista) {
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Usuario");
        modelo.addColumn("Puntaje");
        for (Usuarios u : lista) {
            modelo.addRow(new Object[]{u.getUsuario(), u.getMax_Puntaje()});
        }

        Puntajes.setModel(modelo);

        Puntajes.setFont(new Font("Monospaced", Font.PLAIN, 16));
        Puntajes.setBackground(Color.BLACK);
        Puntajes.setForeground(Color.WHITE);
        Puntajes.setSelectionBackground(Color.DARK_GRAY);
        Puntajes.setSelectionForeground(Color.WHITE);

        Puntajes.getTableHeader().setFont(new Font("Monospaced", Font.BOLD, 18));
        Puntajes.getTableHeader().setBackground(Color.BLACK);
        Puntajes.getTableHeader().setForeground(Color.CYAN);

        jScrollPane1.getViewport().setBackground(Color.BLACK);

    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ImgPanel = new javax.swing.JPanel();
        ImgLabel = new javax.swing.JLabel();
        Volver = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Puntajes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ImgLabel.setText("p");

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

        Puntajes.setBackground(new java.awt.Color(0, 0, 0));
        Puntajes.setFont(new java.awt.Font("Monospaced", 1, 14)); // NOI18N
        Puntajes.setForeground(new java.awt.Color(255, 255, 255));
        Puntajes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(Puntajes);

        javax.swing.GroupLayout ImgPanelLayout = new javax.swing.GroupLayout(ImgPanel);
        ImgPanel.setLayout(ImgPanelLayout);
        ImgPanelLayout.setHorizontalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImgPanelLayout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(Volver, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        ImgPanelLayout.setVerticalGroup(
            ImgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImgPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(ImgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(Volver)
                .addGap(26, 26, 26))
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
            .addComponent(ImgPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void VolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VolverActionPerformed
        AbrirNuevasVentanas anv = new AbrirNuevasVentanas();
        anv.Interfaz();
        this.dispose();
    }//GEN-LAST:event_VolverActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImgLabel;
    private javax.swing.JPanel ImgPanel;
    private javax.swing.JTable Puntajes;
    private javax.swing.JButton Volver;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
