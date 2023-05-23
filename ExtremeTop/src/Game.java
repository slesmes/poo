
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import javax.swing.JFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Daniel Lesmes
 */
public class Game extends JFrame implements Runnable {
    public static final int WIDTH = 960, HEIGHT = 720, T_V = 10;
    public static double Gravity = 0.185;
    private Thread thread;
    private boolean running = false;
    
    public Menu manager;
    Level level;
    stores stores;
    public static boolean isfinal = false;
    
    public Game() throws IOException {
        stores = new stores();
        level = new Level("level.png");
        level.load(stores);
        manager = new Menu(this,stores);
        
        setTitle("Jump King - Space Oddyssey");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
        System.out.println("Game started");
    }
    
    public synchronized void stop() {
        try {
            thread.join(1000000);
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    @Override
    public void run() {
       long start = System.nanoTime();
        double delta = 0;
        final double ns = 1000000000.0 / 80.0;
        requestFocus();
        
        while (running) {
            long now = System.nanoTime();
            delta += (now - start) / ns;
            start = now;
            
            if (delta >= 1) {
                tick();
                delta--;
            }
            
            if (running) {
                render();
            }
        }
        
        stop();
    }

  private void tick() {
        manager.update();
    }
    
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        
        g.setColor(Color.white);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        
        manager.renderMenu(g);
        
        g.dispose();
        bs.show();
    }
    
    public static int limit(int maximum, int minimum, int value) {
        return Math.max(minimum, Math.min(value, maximum));
    }
    
    public static void main(String args[]) throws IOException {
        Game game = new Game();
        game.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
