/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class HabilidadModel {
    private int ninjaID;
    private String nombre;
    private String descripcion;

    public HabilidadModel(int ninjaID, String nombre, String descripcion) {
        this.ninjaID = ninjaID;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
}
