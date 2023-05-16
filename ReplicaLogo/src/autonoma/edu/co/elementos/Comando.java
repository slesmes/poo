/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;

/**
 * Son las ordenes que la tortuga no puede ejecutar pero que el usuario puede solicitar.
 *
 * @author Santiago Lesmes Marín
 * @author María José Muñoz Posada
 * @version 1.0.0
 */
public abstract class Comando {
    /**
     * Figura que se dibuja en el patio.
     */
    protected Tortuga mitorTortuga;

    public Tortuga getMitorTortuga() {
        return mitorTortuga;
    }

    public void setMitorTortuga(Tortuga mitorTortuga) {
        this.mitorTortuga = mitorTortuga;
    }
}
