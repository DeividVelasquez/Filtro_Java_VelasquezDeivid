/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class NinjaModel {
    private int ninjaID;
    private String nombre;
    private String rango;
    private String aldea;

    public NinjaModel(int ninjaID, String nombre, String rango, String aldea) {
        this.ninjaID = ninjaID;
        this.nombre = nombre;
        this.rango = rango;
        this.aldea = aldea;
    }

    public int getNinjaID() {
        return ninjaID;
    }

    public void setNinjaID(int ninjaID) {
        this.ninjaID = ninjaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRango() {
        return rango;
    }

    public void setRango(String rango) {
        this.rango = rango;
    }

    public String getAldea() {
        return aldea;
    }

    public void setAldea(String aldea) {
        this.aldea = aldea;
    }
    
}
