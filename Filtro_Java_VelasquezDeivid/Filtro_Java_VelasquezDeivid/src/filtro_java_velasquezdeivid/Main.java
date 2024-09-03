/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filtro_java_velasquezdeivid;

import Controller.*;
import java.util.Scanner;

public class Main {
    private HabilidadController habilidadController;
    private MisionController misionController;
    private MisionNinjaController misionninjaController;
    private NinjaController ninjaController;
    private Scanner scanner;

    public Main() {
        this.habilidadController = new HabilidadController();
        this.misionController = new MisionController();
        this.misionninjaController = new MisionNinjaController();
        this.ninjaController = new NinjaController();
        this.scanner = new Scanner(System.in);
    }
    
    public void showMenu() {
        int option;

        do {
            System.out.println("-----------------------------------------");
            System.out.println("'     Menú de Gestión de konoha         '");
            System.out.println("'   1. Crear nuevo ninja                '");
            System.out.println("'   2. Crear nueva Mision               '");
            System.out.println("'   3. Crear habilidad                  '");
            System.out.println("'   4. Asignar Mision                   '");
            System.out.println("'   5. Finalizar Mision                 '");
            System.out.println("'   6. Misiones Disponibles de un ninja '");
            System.out.println("'   7. Misiones Completas de un ninja   '");
            System.out.println("'   8. Misiones Completas               '");
            System.out.println("'   9. Habilidades de ninja             '");
            System.out.println("'   0. Salir                            '");
            System.out.println("-----------------------------------------");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    ninjaController.addNinja();
                    break;
                case 2:
                    misionController.addMision();
                    break;
                case 3:
                    habilidadController.AsignarMision();
                case 4:
                    misionninjaController.AsignarMision();
                    break;
                case 5:
                    misionninjaController.FinalizarMision();
                case 6:
                    System.out.println("Ingrese el id del ninja");
                    int ninjaID1 = scanner.nextInt();
                    misionninjaController.MisionDisponibleNinja(ninjaID1);
                    break;
                case 7:
                    System.out.println("Ingrese el id del ninja");
                    int ninjaID2 = scanner.nextInt();
                    misionninjaController.MisionCompletasNinja(ninjaID2);
                    break;
                case 8:
                    misionninjaController.MisionCompletas();
                case 9:
                    habilidadController.HabilidadesNinja();
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
                    break;
            }

        } while (option != 3);
    }
    
    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
    }
    
}
