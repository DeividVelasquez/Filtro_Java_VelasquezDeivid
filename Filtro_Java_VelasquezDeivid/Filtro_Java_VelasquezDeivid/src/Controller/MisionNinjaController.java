/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.MisionDao;
import Model.MisionNinjaModel;
import Dao.MisionNinjaDao;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class MisionNinjaController {
    private MisionNinjaDao misionDao;
    
    public MisionNinjaController(){
        this.misionDao = new MisionNinjaDao();
    }
    
    public void AsignarMision(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingrese el id del ninja: ");
        int ninjaID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese el id de la mision: ");
        int misionID = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese la fecha de Inicio (YYYY-MM-DD):");
        sc.nextLine(); 
        String fechaInicio = sc.nextLine();
        Date fechaInicion = null;
        try {
            fechaInicion = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Se usará la fecha actual.");
            fechaInicion = new Date();
        }
        
        String fechaFin = "null";
        
        MisionNinjaModel mision = new MisionNinjaModel(ninjaID, misionID, fechaInicio, fechaFin);
        if (misionDao.AsignarMision(mision)) {
            System.out.println("Mision añadida exitosamente.");
        } else {
            System.out.println("Error al añadir la Mision.");
        }
    }
    
    public boolean FinalizarMision() {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Ingresa el id de la mision a finalizar:");
        int mision = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Ingrese la fecha de finalizacion (YYYY-MM-DD):");
        sc.nextLine(); 
        String fechaInicio = sc.nextLine();
        Date fechaInicion = null;
        try {
            fechaInicion = new SimpleDateFormat("yyyy-MM-dd").parse(fechaInicio);
        } catch (ParseException e) {
            System.out.println("Formato de fecha incorrecto. Se usará la fecha actual.");
            fechaInicion = new Date();
        }
        
        return misionDao.FinalizarMision(fechaInicio, mision);
    }
    
    public ResultSet MisionCompletasNinja(int ninjaID){
        return misionDao.MisionesCompletadasNinja(ninjaID);
    }
    
    public ResultSet MisionDisponibleNinja(int ninjaID){
        return misionDao.MisionesDisponiblesNinja(ninjaID);
    }
    
    public ResultSet MisionCompletas(){
        return misionDao.MisionesCompletadas();
    }
}
