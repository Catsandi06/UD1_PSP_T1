package edu.salesianos.lacuesta.actividad1;

import java.io.File;
import java.io.IOException;

public class Actividad1_padre {

    public static void main(String[] args) throws IOException, InterruptedException {
        // PID del proceso que ejecuta este programa.
        System.out.println("PID del programa padre: " + ProcessHandle.current().pid());

        // Localizamos el ejecutable Java y el classpath del programa actual.
        String java = System.getProperty("java.home")
                + File.separator + "bin"
                + File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        /*
         * ProcessBuilder prepara un proceso Java independiente que ejecutará
         * la clase Actividad1_hijo durante 10 segundos.
         */
        ProcessBuilder primerBuilder = new ProcessBuilder(
                java, "-cp", classpath, Actividad1_hijo.class.getName(), "10");
        primerBuilder.inheritIO();

        Process primerProceso = primerBuilder.start();
        System.out.println("PID del primer proceso creado: " + primerProceso.pid());

        // isAlive() informa de si el proceso todavía se está ejecutando.
        System.out.println("¿El primer proceso sigue activo? " + primerProceso.isAlive());

        // Esperamos cinco segundos antes de volver a comprobar su estado.
        Thread.sleep(5000);
        System.out.println("¿El primer proceso sigue activo después de 5 segundos? "
                + primerProceso.isAlive());

        // Si sigue activo, solicitamos su finalización.
        if (primerProceso.isAlive()) {
            primerProceso.destroy();
        }

        // Esperamos a que termine completamente y recogemos su finalización.
        primerProceso.waitFor();
        System.out.println("El primer proceso ha finalizado.");

        /*
         * Creamos un segundo hijo, que tardará solo dos segundos.
         * Esta vez esperamos a que termine por sí solo.
         */
        ProcessBuilder segundoBuilder = new ProcessBuilder(
                java, "-cp", classpath, Actividad1_hijo.class.getName(), "2");
        segundoBuilder.inheritIO();

        Process segundoProceso = segundoBuilder.start();
        System.out.println("PID del segundo proceso creado: " + segundoProceso.pid());
        segundoProceso.waitFor();

        // exitValue() devuelve el código de salida: normalmente, 0 significa éxito.
        int codigoSalida = segundoProceso.exitValue();
        System.out.println("Código de salida del segundo proceso: " + codigoSalida);
        System.out.println("¿El segundo proceso ha terminado correctamente? "
                + (codigoSalida == 0 ? "Sí" : "No"));
    }
}
