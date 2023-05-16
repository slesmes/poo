/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel Lesmes
 */
public class Tortuga extends Sprite implements drawable {
    private drawable drawable;
    private int angle;
    private int oldX;
    private int oldY;
    private int posicioninicialx;
    private int posicioninicialy;
    private List<Rastro> rastros;
    private String ColorRastro = "000000";

    public Tortuga(int x, int y) {
        super(x - 25, y - 25, 50, 50);
        this.angle=270;
        this.rastros = new ArrayList<>();
        posicioninicialx=x-25;
        posicioninicialy=y-25;
        
    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
        ImageIcon rotatedIcon = rotateImageIcon(imagen, angle);
        g.drawImage(rotatedIcon.getImage(), getX(), getY(), getWidth(), getHeight(), lenguajeVentana); 
        dibujarRastros(g);
    }

    public void addLine(int x, int y, int oldx, int oldy) {
        Rastro line = new Rastro(oldx, oldy, x, y);
        line.setColor(ColorRastro);
        getRastros().add(line);
    }

    public void dibujarRastros(Graphics g) {
        for (Rastro actual : getRastros()) {
            g.setColor(Color.decode(this.pasar_a_codigo(actual.getColor())));
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
        if (x<this.area.getX()){
            x = this.area.getX();
        }
        if (y< this.area.getY()){
            y= this.area.getY();
        }
        if(x+this.width>this.area.getWidth()){
            x=this.area.getWidth()-this.width;
        }
        if(y+this.height>this.area.getHeight()){
            y=this.area.getHeight()-this.height;
        }
        
        addLine(oldX, oldY, x, y);
        drawable.redraw();
    }

    public void backWard(int distance) {
        forward(-distance);
    }

    public void leftTurn(int degrees) {
        angle = (angle - degrees + 360) % 360;
        redraw();
    }

    public void rightTurn(int degrees) {
        angle = (angle + degrees) % 360;
        redraw();
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360;
    }


    public String pasar_a_codigo(String color) {
        switch (color) {
            case "magenta":
                return "#FF00FF";
            case "orange":
                return "#FF8000";
            case "pink":
                return "#FF0080";
            case "white":
                return "#FFFFFF";
            case "yellow":
                return "#FFFF00";
            case "black":
                return "#000000";
            case "blue":
                return "#0000FF";
            case "cyan":
                return "#00FFFF";
            case "gray":
                return "#9B9B9B";
            case "green":
                return "#00FF00";
            case "red":
                return "#FF0000";
            default:
                return "#000000";
        }
    }

    public void repetir_movimientos(String comandos, String repeticiones) {
        String[] instrucciones = comandos.split(";");
        for (int j = 0; j < Integer.parseInt(repeticiones); j++) {
            for (int i = 0; i < instrucciones.length; i++) {
                interpretar_movimiento(instrucciones[i]);
            }
        }
    }

    public void interpretar_movimiento(String comando) {
        String[] componentes = comando.toLowerCase().split(" ");
        if (componentes[0].equals("forward") || componentes[0].equals("fd")){
            int distance = Integer.parseInt(componentes[1]);
            forward(distance);
        }else if(componentes[0].equals("backward") || componentes[0].equals("bd")){
            int distance2 = Integer.parseInt(componentes[1]);
            backWard(distance2);
        }else if (componentes[0].equals("rightturn") || componentes[0].equals("rt")){
            int grado = Integer.parseInt(componentes[1]);
            rightTurn(grado);
        }else if (componentes[0].equals("leftturn") || componentes[0].equals("lt")){
            int grado2 = Integer.parseInt(componentes[1]);
            leftTurn(grado2);
        }else if (componentes[0].equals("setcolor") || componentes[0].equals("sc")){
            setColor(componentes[1]);
        }else if (componentes[0].equals("repeat")){
            String block = comando.substring(comando.indexOf("[") + 1, comando.indexOf("]"));
            repetir_movimientos(block,componentes[1]);
        }

    }

    @Override
    public void redraw() {
         drawable.redraw();
    }
    public void setdrawable(drawable drawable){
        this.drawable = drawable;
    }

    public void setColor(String color) {
        this.ColorRastro=color;
    }

    /**
     * @return the posicioninicialx
     */
    public int getPosicioninicialx() {
        redraw();
        return posicioninicialx;
    }

    /**
     * @return the posicioninicialy
     */
    public int getPosicioninicialy() {
        redraw();
        return posicioninicialy;
    }

    /**
     * @return the rastros
     */
    public List<Rastro> getRastros() {
        return rastros;
    }
    
    public static ImageIcon rotateImageIcon(ImageIcon icon, int angle) {
        Image image = icon.getImage();
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        AffineTransform transform = new AffineTransform();
        transform.rotate(Math.toRadians(angle), image.getWidth(null) / 2, image.getHeight(null) / 2);
        g2d.drawImage(image, transform, null);
        g2d.dispose();
        ImageIcon rotatedIcon = new ImageIcon(bufferedImage);
        return rotatedIcon;
    }
}
