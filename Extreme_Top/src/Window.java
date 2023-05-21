
import elements.Patio;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import elements.Drawable;
import elements.Platform;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ColorModel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Daniel Lesmes
 */
public class Window extends javax.swing.JFrame implements Drawable, KeyListener {

    private Patio patio;
    private Timer time;

    /**
     * Creates new form Window
     */
    public Window() {
        initComponents();
        time = new Timer(40, acciones);
    }

    public void setPatio(Patio patio) {
        this.patio = patio;
        patio.setdrawable(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        patio.draw(g, this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1100, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 700, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_Q) {
            System.exit(0);
        }

        if (evt.getKeyCode() == KeyEvent.VK_LEFT
                | evt.getKeyCode() == KeyEvent.VK_RIGHT) {
            patio.handleKey(evt.getKeyCode());
            time.start();
        }
        
       
        keyPressed(evt);
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        keyReleased(evt);
    }//GEN-LAST:event_formKeyReleased
    private ActionListener acciones = new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            patio.getPlayer().update();
            patio.getPlayer().setONGROUND(false);
            for (Platform actual : patio.getPlataformas()) {
                if (patio.getPlayer().getBounds().intersects(actual.getBounds())) {
                    patio.getPlayer().land(actual.getY());
                    time.stop();
                }
            }
            
            redraw();
        }
    };

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Window window = new Window();
        Patio patio = new Patio(window.getWidth(), window.getHeight());
        window.setPatio(patio);
        window.setVisible(true);
    }

    @Override
    public void redraw() {
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("asld");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            patio.handleKeyUp(e.getKeyCode());
            time.start();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            patio.getPlayer().setJumping(false);
            patio.getPlayer().jump();
            System.out.println(patio.getPlayer().getJUMP_FORCE());
            patio.getPlayer().restartJumpForce();
            patio.getPlayer().setJUMP_FORCE(-15);
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
