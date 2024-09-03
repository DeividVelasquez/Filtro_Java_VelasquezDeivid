/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.MisionDao;
import Model.MisionModel;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class MisionController {
    private MisionDao misionDao;
    private static final String[] rango = {"Principiante", "Intermedio", "Maestro"};
    
    public MisionController(){
        this.misionDao = new MisionDao();
    }
    
    public void addMision(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese la descripcion de la misión: ");
        String descripcion = sc.nextLine();
        
        System.out.println("Seleccione el rango de la misión:");
        for (int i = 0; i < rango.length; i++) {
            System.out.println((i + 1) + ". " + rango[i]);
        }
        int genderChoice = sc.nextInt();
        String Rango = (genderChoice > 0 && genderChoice <= rango.length) ? rango[genderChoice - 1] : "Maestro";
        
        System.out.println("Ingrese la recompensa: ");
        double recompensa = sc.nextDouble();
        
        MisionModel mision = new MisionModel(0, descripcion, Rango, recompensa);
        if (misionDao.addMision(mision)) {
            System.out.println("Mision añadida exitosamente.");
        } else {
            System.out.println("Error al añadir la Mision.");
        }
    }
}
