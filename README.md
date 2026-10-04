# UD1 PSP T1

Ejercicios de la primera unidad de **Procesos y Servicios** realizados en Java.

## Contenido

### Actividad 1

`Actividad1_padre` crea dos procesos Java que ejecutan `Actividad1_hijo`:

- El primer proceso se inicia durante 10 segundos y se finaliza desde el proceso padre después de 5 segundos.
- El segundo proceso se deja terminar por sí solo después de 2 segundos.
- Se muestran los PID, el estado de los procesos y el código de salida.

### Actividad 2

`Actividad2` presenta un menú para abrir herramientas del sistema:

1. Bloc de notas (`notepad.exe`)
2. Calculadora (`calc.exe`)
3. Administrador de tareas (`taskmgr.exe`)
4. Salir

La aplicación utiliza `ProcessBuilder` para crear los procesos y muestra su PID y estado.

## Requisitos

- Java JDK 21 o compatible con `ProcessHandle` y `ProcessBuilder`.
- En la Actividad 2, las herramientas indicadas deben estar disponibles en Windows.

## Compilación

Desde la raíz del proyecto:

```powershell
javac -d out $(Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName)
```

## Ejecución

Actividad 1:

```powershell
java -cp out edu.salesianos.lacuesta.actividad1.Actividad1_padre
```

Actividad 2:

```powershell
java -cp out edu.salesianos.lacuesta.actividad2.Actividad2
```
