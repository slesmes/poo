/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package autonoma.edu.co.gui;

import autonoma.edu.co.elementos.Lector;
import autonoma.edu.co.elementos.Patio;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daniel Lesmes
 */
public class LenguajeVentana extends javax.swing.JFrame {

    private Patio patio;
    private Lector lector;

    /**
     * Creates new form LenguajeVentana
     */
    public LenguajeVentana() {
        initComponents();
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
    }
    
    public void setLector(Lector lector){
        this.lector = lector;
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreComando = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnSubirArchivo = new javax.swing.JButton();
        btnmostarlistacomandos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnSubirArchivo.setText("Subir Archivo");

        btnmostarlistacomandos.setText("mostrar lista ");
        btnmostarlistacomandos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmostarlistacomandosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(138, 138, 138)
                .addComponent(txtNombreComando, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSubirArchivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnmostarlistacomandos)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(473, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreComando, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAceptar)
                    .addComponent(btnSubirArchivo)
                    .addComponent(btnmostarlistacomandos))
                .addGap(94, 94, 94))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        String nombreComando=  txtNombreComando.getText();
        lector.runCommand(nombreComando);
        repaint();
        txtNombreComando.setText("");
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnmostarlistacomandosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmostarlistacomandosActionPerformed
        ListaComandos listacomandos = new ListaComandos(this, this.lector);
        listacomandos.setVisible(true);
    }//GEN-LAST:event_btnmostarlistacomandosActionPerformed

    
    public static void main(String args[]) {
        LenguajeVentana window = new LenguajeVentana();
        Patio patio = new Patio(window.getWidth(), window.getHeight());
        window.setPatio(patio);
        Lector lector = new Lector(patio.getTortuga(), window);
        window.setLector(lector);

        window.setTitle("Replica Logo");
        window.setVisible(true);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        patio.draw(g, this);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnSubirArchivo;
    private javax.swing.JButton btnmostarlistacomandos;
    private javax.swing.JTextField txtNombreComando;
    // End of variables declaration//GEN-END:variables
}