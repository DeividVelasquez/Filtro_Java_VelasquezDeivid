/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.util.Scanner;
import Model.NinjaModel;
import Dao.NinjaDao;

public class NinjaController {
    private NinjaDao ninjaDao;
    private static final String[] rango = {"Principiante", "Intermedio", "Maestro"};
    
    public NinjaController(){
        this.ninjaDao = new NinjaDao();
    }
    
    public void addNinja(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el nombre del ninja: ");
        String nombre = sc.nextLine();
        
        System.out.println("Seleccione el rango del Ninja:");
        for (int i = 0; i < rango.length; i++) {
            System.out.println((i + 1) + ". " + rango[i]);
        }
        int genderChoice = sc.nextInt();
        String Rango = (genderChoice > 0 && genderChoice <= rango.length) ? rango[genderChoice - 1] : "Maestro";
        
        System.out.println("Ingrese el nombre de la aldea: ");
        String aldea = sc.nextLine();
        
        NinjaModel ninja = new NinjaModel(0, nombre, Rango, aldea);
        if (ninjaDao.addNinja(ninja)) {
            System.out.println("Ninja añadido exitosamente.");
        } else {
            System.out.println("Error al añadir el Ninja.");
        }
    }
}
