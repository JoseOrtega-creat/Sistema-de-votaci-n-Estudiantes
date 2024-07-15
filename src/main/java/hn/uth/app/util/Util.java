package hn.uth.app.util;

import java.util.Scanner;

// Clase utilitaria para manejar la entrada y salida de datos
public class Util {
    // Scanner para leer la entrada del usuario desde la consola
    static Scanner scan = new Scanner(System.in);

    // Método para capturar un string desde la entrada del usuario
    public static String scanString(String mensaje) {
        // Imprimir el mensaje para pedir al usuario que ingrese un valor
        print(mensaje);
        // Leer y devolver la entrada del usuario
        return scan.nextLine();
    }

    // Método para capturar un int desde la entrada del usuario
    public static int scanInt(String mensaje) {
        // Imprimir el mensaje para pedir al usuario que ingrese un valor
        print(mensaje);
        // Comprobar si la entrada es un número válido
        while (!scan.hasNextInt()) {
            // Si la entrada no es válida, mostrar mensaje de error y pedir nuevamente
            print("Por favor, ingrese un número válido.");
            scan.next();
        }
        // Leer y devolver el número ingresado por el usuario
        int number = scan.nextInt();
        scan.nextLine(); // Limpiar el buffer de entrada
        return number;
    }

    // Método para imprimir mensajes en la consola
    public static void print(String mensaje) {
        // Imprimir el mensaje proporcionado
        System.out.println(mensaje);
    }
}
