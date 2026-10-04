package edu.salesianos.lacuesta.actividad2;

import java.io.IOException;
import java.util.Scanner;

public class Actividad2 {

    public static void main(String[] args) {
        /*
         * Scanner permite leer la opción escrita por el usuario.
         * try-with-resources cierra el Scanner automáticamente al terminar.
         */
        try (Scanner scanner = new Scanner(System.in)) {
            boolean continuar = true;

            while (continuar) {
                mostrarMenu();
                System.out.print("Selecciona una opción: ");

                String entrada = scanner.nextLine();

                try {
                    int opcion = Integer.parseInt(entrada);
                    continuar = ejecutarOpcion(opcion);
                } catch (NumberFormatException e) {
                    System.out.println("Error: debes introducir un número del menú.");
                }

                System.out.println();
            }
        }

        System.out.println("Programa finalizado.");
    }

    private static void mostrarMenu() {
        System.out.println("===== HERRAMIENTAS DEL SISTEMA =====");
        System.out.println("1. Bloc de notas");
        System.out.println("2. Calculadora");
        System.out.println("3. Administrador de tareas");
        System.out.println("4. Salir");
    }

    private static boolean ejecutarOpcion(int opcion) {
        String herramienta;

        switch (opcion) {
            case 1:
                herramienta = "notepad.exe";
                break;
            case 2:
                herramienta = "calc.exe";
                break;
            case 3:
                herramienta = "taskmgr.exe";
                break;
            case 4:
                return false;
            default:
                System.out.println("Opción no válida. Elige una opción del 1 al 4.");
                return true;
        }

        abrirHerramienta(herramienta);
        return true;
    }

    private static void abrirHerramienta(String herramienta) {
        try {
            /*
             * ProcessBuilder prepara el comando y start() crea el proceso.
             * No se utiliza waitFor(), por lo que el menú vuelve a mostrarse
             * sin esperar a que se cierre la herramienta.
             */
            ProcessBuilder processBuilder = new ProcessBuilder(herramienta);
            Process proceso = processBuilder.start();

            System.out.println("Herramienta abierta: " + herramienta);
            System.out.println("PID del proceso creado: " + proceso.pid());
            System.out.println("¿La herramienta sigue en ejecución? "
                    + proceso.isAlive());
        } catch (IOException e) {
            System.out.println("No se pudo ejecutar " + herramienta + ": "
                    + e.getMessage());
        } catch (SecurityException e) {
            System.out.println("No hay permisos para ejecutar " + herramienta + ": "
                    + e.getMessage());
        }
    }
}
