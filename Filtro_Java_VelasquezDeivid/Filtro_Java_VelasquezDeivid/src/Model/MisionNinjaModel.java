/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class MisionNinjaModel {
    private int ninjaID;
    private int misionID;
    private String fechaInicio;
    private String fechaFin;

    public MisionNinjaModel(int ninjaID, int misionID, String fechaInicio, String fechaFin) {
        this.ninjaID = ninjaID;
        this.misionID = misionID;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getNinjaID() {
        return ninjaID;
    }

    public void setNinjaID(int ninjaID) {
        this.ninjaID = ninjaID;
    }

    public int getMisionID() {
        return misionID;
    }

    public void setMisionID(int misionID) {
        this.misionID = misionID;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }
    
    
}
