/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.HabilidadDao;
import Model.HabilidadModel;
import java.sql.ResultSet;
import java.util.Scanner;

/**
 *
 * @author camper
 */
public class HabilidadController {
    private HabilidadDao habilidadDao;
    
    public HabilidadController(){
        this.habilidadDao = new HabilidadDao();
    }
    
    public void AsignarMision(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el id del ninja: ");
        int ninjaID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el nombre de la habilidad: ");
        String misionID = sc.nextLine();
        
        System.out.println("Ingrese descripcion de habilidad");
        String fechaFin = sc.nextLine();
        
        HabilidadModel mision = new HabilidadModel(ninjaID, misionID, fechaFin);
        if (habilidadDao.addHabilidad(mision)) {
            System.out.println("Mision añadida exitosamente.");
        } else {
            System.out.println("Error al añadir la Mision.");
        }
    }
    
    public ResultSet HabilidadesNinja(){
        return habilidadDao.HabilidadesNinja();
    }
}
