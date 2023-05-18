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
 * Clase que representa una tortuga en el lenguaje Logo. Esta se mueve y deja un
 * rastro mientras se desplaza.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public class Tortuga extends Sprite implements drawable {

    /**
     * Es la interfaz que permite redibujar los cambios
     */
    private drawable drawable;
    /**
     * Es el ángulo de orientación de la tortuga.
     */
    private int angle;
    /**
     * Es la coordenada en X,en la que estaba la tortuga antes de realizar el
     * movimiento
     */
    private int oldX;
    /**
     * Es la coordenada en Y,en la que estaba la tortuga antes de realizar el
     * movimiento
     */
    private int oldY;
    /**
     * Es la coordenada en X,con la que la toruga inicia al empezar el programa.
     */
    private int posicioninicialx;
    /**
     * Es la coordenada en Y,con la que la toruga inicia al empezar el programa.
     */
    private int posicioninicialy;
    /**
     * Son todos los movimientos que ya ha realizado la figura.
     */
    private List<Rastro> rastros;
    /**
     * Color por defecto del camino, este cambia cuando el usuario ingresa la
     * instrucción de "setColor"
     */
    private String ColorRastro = "000000";

    public Tortuga(int x, int y) {
        super(x - 25, y - 25, 50, 50);
        this.angle = 270;
        this.rastros = new ArrayList<>();
        posicioninicialx = x - 25;
        posicioninicialy = y - 25;

    }

    @Override
    public void draw(Graphics g, ImageObserver lenguajeVentana) {
        ImageIcon imagen = new ImageIcon(getClass().getResource("tortugaLogo.png"));
        ImageIcon rotatedIcon = rotateImageIcon(imagen, getAngle());
        g.drawImage(rotatedIcon.getImage(), getX(), getY(), getWidth(), getHeight(), lenguajeVentana);
        dibujarRastros(g);
    }

    /**
     * Cada la que toruga realiza un movimiento, este agrega una línea al rastro
     * de la tortuga.
     *
     * @param x La coordenada X del punto final de la línea.
     * @param y La coordenada Y del punto final de la línea.
     * @param oldx La coordenada X del punto inicial de la línea.
     * @param oldy La coordenada Y del punto inicial de la línea.
     */
    public void addLine(int x, int y, int oldx, int oldy) {
        Rastro line = new Rastro(oldx, oldy, x, y);
        line.setColor(getColorRastro());
        getRastros().add(line);
    }

    /**
     * Dibuja los rastros dejados por la tortuga en un contexto gráfico dado.
     *
     * @param g el contexto gráfico en el que se dibujarán los rastros.
     */
    public void dibujarRastros(Graphics g) {
        for (Rastro actual : getRastros()) {
            g.setColor(Color.decode(this.pasar_a_codigo(actual.getColor())));
            g.drawLine(actual.getInitX(), actual.getInitY(), actual.getEndX(), actual.getEndY());
        }
    }

    /**
     * Mueve la tortuga hacia adelante en la dirección actual por una distancia
     * especificada.
     *
     * @param distance El número de pasos a avanzar hacia adelante.
     */
    public void forward(int distance) {
        int newX = x + (int) (distance * Math.cos(Math.toRadians(getAngle())));
        int newY = y + (int) (distance * Math.sin(Math.toRadians(getAngle())));
        oldY = y;
        oldX = x;
        x = newX;
        y = newY;
        if (x < this.area.getX()) {
            x = this.area.getX();
        }
        if (y < this.area.getY()) {
            y = this.area.getY();
        }
        if (x + this.width > this.area.getWidth()) {
            x = this.area.getWidth() - this.width;
        }
        if (y + this.height > this.area.getHeight()) {
            y = this.area.getHeight() - this.height;
        }

        addLine(oldX, oldY, x, y);
        drawable.redraw();
    }

    /**
     * Mueve la tortuga hacia atrás en la dirección actual retrocediendo una
     * distancia dada.
     *
     * @param distance El número de pasos a retroceder.
     */
    public void backWard(int distance) {
        forward(-distance);
    }

    /**
     * Gira la tortuga hacia la izquierda un cierto número de grados.
     *
     * @param degrees Gira la tortuga hacia la izquierda un cierto número de
     * grados.
     */
    public void leftTurn(int degrees) {
        setAngle((getAngle() - degrees + 360) % 360);
        redraw();
    }

    /**
     * Gira la tortuga hacia la derecha un cierto número de grados.
     *
     * @param degrees Gira la tortuga hacia la derecha un cierto número de
     * grados.
     */
    public void rightTurn(int degrees) {
        setAngle((getAngle() + degrees) % 360);
        redraw();
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle % 360;
    }

    /**
     * Convierte un nombre de color en una representación hexadecimal de color.
     *
     * @param color El nombre del color a convertir.
     * @return La representación hexadecimal del color.
     */
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

    /**
     * Ejecuta una secuencia de instrucciones repetidamente un número
     * determinado de veces.
     *
     * @param comandos Las instrucciones a ejecutar, separados por punto y coma
     * (;).
     * @param repeticiones El número de repeticiones de la secuencia de
     * instrucciones.
     */
    public void repetir_movimientos(String comandos, String repeticiones) {
        String[] instrucciones = comandos.split(";");
        for (int j = 0; j < Integer.parseInt(repeticiones); j++) {
            for (int i = 0; i < instrucciones.length; i++) {
                interpretar_movimiento(instrucciones[i]);
            }
        }
    }

    /**
     * Interpreta y ejecuta una instruccion de movimiento.
     *
     * @param comando la instruccion a interpretar y ejecutar.
     */
    public void interpretar_movimiento(String comando) {
        String[] componentes = comando.toLowerCase().split(" ");
        if (componentes[0].equals("forward") || componentes[0].equals("fd")) {
            int distance = Integer.parseInt(componentes[1]);
            forward(distance);
        } else if (componentes[0].equals("backward") || componentes[0].equals("bd")) {
            int distance2 = Integer.parseInt(componentes[1]);
            backWard(distance2);
        } else if (componentes[0].equals("rightturn") || componentes[0].equals("rt")) {
            int grado = Integer.parseInt(componentes[1]);
            rightTurn(grado);
        } else if (componentes[0].equals("leftturn") || componentes[0].equals("lt")) {
            int grado2 = Integer.parseInt(componentes[1]);
            leftTurn(grado2);
        } else if (componentes[0].equals("setcolor") || componentes[0].equals("sc")) {
            setColor(componentes[1]);
        } else if (componentes[0].equals("repeat")) {
            String block = comando.substring(comando.indexOf("[") + 1, comando.indexOf("]"));
            repetir_movimientos(block, componentes[1]);
        }
    }

    @Override
    public void redraw() {
        drawable.redraw();
    }

    public void setdrawable(drawable drawable) {
        this.drawable = drawable;
    }

    public void setColor(String color) {
        this.setColorRastro(color);
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

    /**
     * Rota un ImageIcon según un ángulo especificado.En este caso rota la figura de
     * tortuga.
     *
     * @param icon El ImageIcon a rotar. 
     * @param angle El ángulo de rotación en grados.
     * @return La figura de tortuga rotada.
     */
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

    /**
     * @param ColorRastro the ColorRastro to set
     */
    public void setColorRastro(String ColorRastro) {
        this.ColorRastro = ColorRastro;
    }

    /**
     * @return the ColorRastro
     */
    public String getColorRastro() {
        return ColorRastro;
    }

}
