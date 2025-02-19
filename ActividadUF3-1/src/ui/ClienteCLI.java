package ui;

import java.util.Scanner;

public class ClienteCLI {

    private Scanner scanner;

    public ClienteCLI() {
        scanner = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("""
                ---     MENU     ---
                1.  Constelaciones
                2.  Planetas
                
                ('FIN' para salir del programa)
                
                ------------------------------
                """);
    }

    public void showMenuConstelaciones(){
        System.out.println("""
                ---     CONSTELACIONES     ---
                1.  Buscar por nombre
                2.  Lista de constelaciones
                
                ('SALIR' para salir del menú)
                
                ------------------------------
                """);
    }

    public void showMenuPlanetas() {
        System.out.println("""
                ---     PLANETAS     ---
                1.  Buscar por nombre
                2.  Lista de planetas
                
                ('SALIR' para salir del menú)
                
                ------------------------------
                """);
    }

    public String askName() {
        System.out.println("Introduzca el nombre: ");
        return scanner.nextLine().trim().toLowerCase();
    }


    public String askInput() {
        System.out.println("Elija una opcion: ");
        return scanner.nextLine().trim().toLowerCase();
    }

}


