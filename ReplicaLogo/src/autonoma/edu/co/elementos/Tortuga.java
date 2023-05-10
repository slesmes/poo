/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class Tortuga extends Sprite {

    private int angle;
    private int oldX;
    private int oldY;
    private List<Rastro> rastros;

    public Tortuga(int x, int y) {
        super(x - 25, y - 25, 50, 50);
        this.angle = 270;
        this.rastros = new ArrayList<>();
    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
        g.drawImage(imagen.getImage(), getX(), getY(), getWidth(), getHeight(), lenguajeVentana);
        Graphics2D g2d = (Graphics2D) g;
        addLine(oldX, oldY, x, y);
        dibujarRastros(g);
    }

    public void addLine(int x, int y, int oldx, int oldy) {
        Rastro line = new Rastro(oldx, oldy, x, y);
        rastros.add(line);
    }

    public void dibujarRastros(Graphics g) {
        for (Rastro actual : rastros) {
            g.drawLine(actual.getInitX(), actual.getInitY(), actual.getEndX(), actual.getEndY());
        }
    }

    public void forward(int distance) {
        int newX = x + (int) (distance * Math.cos(Math.toRadians(angle)));
        int newY = y + (int) (distance * Math.sin(Math.toRadians(angle)));
        oldY = y;
        oldX = x;
        x = newX;
        y = newY;
    }

    public void backWard(int distance) {
        forward(-distance);
    }

    public void leftTurn(int degrees) {
        angle = (angle - degrees + 360) % 360;
    }

    public void rightTurn(int degrees) {
        angle = (angle + degrees) % 360;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360;
    }

}
