package edu.salesianos.lacuesta.actividad1;

public class Actividad1_hijo {

    public static void main(String[] args) throws InterruptedException {
        // ProcessHandle.current() devuelve el proceso en el que se está ejecutando
        // actualmente esta clase, es decir, el proceso hijo.
        System.out.println("PID del proceso hijo: " + ProcessHandle.current().pid());

        // El padre envía los segundos que debe permanecer activo.
        // Si no se recibe ningún argumento, se usan 10 segundos por defecto.
        long segundos = args.length > 0 ? Long.parseLong(args[0]) : 10;

        // sleep() pausa el proceso, simulando un proceso que tarda en terminar.
        Thread.sleep(segundos * 1000);

        System.out.println("El proceso hijo termina por sí solo.");
    }
}
