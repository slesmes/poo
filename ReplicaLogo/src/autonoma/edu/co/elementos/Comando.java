/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.edu.co.elementos;


/**
 *
 * @author Daniel Lesmes
 */
public abstract class Comando {
    protected Tortuga mitorTortuga;
    public abstract void execute(String parametro);

    /**
     * @return the mitorTortuga
     */
    public Tortuga getMitorTortuga() {
        return mitorTortuga;
    }

    /**
     * @param mitorTortuga the mitorTortuga to set
     */
    public void setMitorTortuga(Tortuga mitorTortuga) {
        this.mitorTortuga = mitorTortuga;
    }
}
