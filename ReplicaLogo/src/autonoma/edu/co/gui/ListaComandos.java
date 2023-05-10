/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package autonoma.edu.co.gui;

import autonoma.edu.co.elementos.Lector;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

/**
 *
 * @author Daniel Lesmes
 */
public class ListaComandos extends javax.swing.JDialog {

    /**
     * Creates new form ListaComandos
     */
    public ListaComandos(java.awt.Frame parent,Lector lector) {
        super(parent, true);
        initComponents();
        String nombresColumnas[]={"comandos"};
        DefaultTableModel miModelo= new DefaultTableModel(null, nombresColumnas);
        this.tblComandos.setModel(miModelo);
        for(String comandoactual:lector.getCommandHistory()) {
        	String fila[]=new String[nombresColumnas.length];
        	fila[0]=comandoactual;
                miModelo.addRow(fila);
        }
        crear(lector);
    }
   
    
    public void crear(Lector lector){
        tblComandos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int filaSeleccionada = tblComandos.getSelectedRow();
                if (filaSeleccionada != -1) { 
                    Object dato1 = tblComandos.getValueAt(filaSeleccionada, 0);
                    lector.runCommand((String) dato1);
                }
            }
        });

    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblComandos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblComandos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "comando"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblComandos);
        if (tblComandos.getColumnModel().getColumnCount() > 0) {
            tblComandos.getColumnModel().getColumn(0).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblComandos;
    // End of variables declaration//GEN-END:variables
}
