package hn.uth.app.pantallas;

import hn.uth.app.modelos.Candidato;
import hn.uth.app.constantes.Constantes;
import hn.uth.app.util.Util;

import java.util.ArrayList;
import java.util.List;

// Clase para gestionar la interfaz de usuario del módulo de votación
public class ModuloVotacionPantalla {
    // Lista para almacenar los candidatos
    private List<Candidato> candidatos = new ArrayList<>();

    // Método para iniciar el programa
    public void iniciarPrograma() {
        // Variable para controlar el bucle principal. Cuando es falso, el programa termina.
        boolean continuar = true;
        // Bucle principal del programa. Muestra el menú y ejecuta las acciones elegidas por el usuario.
        while (continuar) {
            // Mostrar el menú principal al usuario
            printMenuPrincipal();
            // Leer la opción elegida por el usuario
            String opcion = Util.scanString("¿Qué acción desea realizar (a/b/s)? R// ");
            // Comprobar qué opción eligió el usuario y llamar al método correspondiente
            if (opcion.equals("a")) {
                // Si el usuario elige 'a', agregar candidatos
                agregarCandidatos();
            } else if (opcion.equals("b")) {
                // Si el usuario elige 'b', votar por candidatos
                votarPorCandidatos();
            } else if (opcion.equals("s")) {
                // Si el usuario elige 's', salir del programa
                continuar = false;
            } else {
                // Si el usuario ingresa una opción no válida, mostrar mensaje de error
                Util.print("Opción no válida, por favor intente de nuevo.");
            }
        }
        // Mensaje de despedida cuando el programa termina
        Util.print("Programa finalizado..... adios :)");
    }

    // Método para imprimir el menú principal en la consola
    private void printMenuPrincipal() {
        // Se imprimen las opciones disponibles del menú principal
        Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        Util.print("|||                         MENU UTH                       |||");
        Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        Util.print("a – Agregar Candidatos");
        Util.print("b – Votar por candidatos");
        Util.print("s – Salir");
    }

    // Método para agregar candidatos al sistema
    private void agregarCandidatos() {
        // Variable para controlar el bucle de agregar candidatos. Cuando es falso, se deja de agregar candidatos.
        boolean continuar = true;
        // Bucle para ingresar múltiples candidatos hasta que el usuario decida parar
        while (continuar) {
            // Mostrar encabezado de sección de agregar candidatos
            Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Util.print("|||                    AGREGANDO CANDIDATOS                |||");
            Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            // Leer los datos del nuevo candidato desde la entrada del usuario
            String nombre = Util.scanString("Nombre del candidato: ");
            int edad = Util.scanInt("Edad del candidato: ");
            String partido = Util.scanString("Partido del candidato: ");
            // Crear un nuevo objeto Candidato con los datos ingresados
            candidatos.add(new Candidato(nombre, edad, partido));

            // Preguntar al usuario si desea continuar ingresando más candidatos
            String respuesta = Util.scanString("¿Desea continuar ingresando candidatos (s/n)? R// ").toUpperCase();
            // Si la respuesta es "No", se sale del bucle
            continuar = Constantes.RESPUESTA_SI.equals(respuesta);
        }
    }

    // Método para manejar la votación por los candidatos
    private void votarPorCandidatos() {
        // Comprobar si hay candidatos disponibles para votar
        if (candidatos.isEmpty()) {
            // Si no hay candidatos, mostrar mensaje y regresar al menú principal
            Util.print("No hay candidatos disponibles para votar.");
            return;
        }

        // Variable para controlar el bucle de votación. Cuando es falso, se deja de votar.
        boolean continuar = true;
        // Bucle para permitir múltiples votaciones hasta que el usuario decida parar
        while (continuar) {
            // Mostrar encabezado de sección de votación
            Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            Util.print("|||                          VOTACION                      |||");
            Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
            // Mostrar la lista de candidatos con su número correspondiente
            for (int i = 0; i < candidatos.size(); i++) {
                Util.print((i + 1) + " - " + candidatos.get(i).getNombre());
            }

            // Leer el número del candidato por el que se desea votar
            int opcion = Util.scanInt("¿Por cuál número de candidato desea votar? R// ");
            // Comprobar si la opción ingresada es válida
            if (opcion > 0 && opcion <= candidatos.size()) {
                // Incrementar los votos del candidato seleccionado
                Candidato candidatoSeleccionado = candidatos.get(opcion - 1);
                candidatoSeleccionado.incrementarVotos();
                // Mostrar los resultados de la votación actualizados
                mostrarResultadosVotacion();
            } else {
                // Mostrar mensaje de error si la opción no es válida
                Util.print("Opción no válida, por favor intente de nuevo.");
            }

            // Preguntar al usuario si desea votar otra vez
            String respuesta = Util.scanString("¿Desea votar otra vez (s/n)? R// ").toUpperCase();
            // Si la respuesta es "No", se sale del bucle
            continuar = Constantes.RESPUESTA_SI.equals(respuesta);
        }
    }

    // Método para mostrar los resultados de la votación
    private void mostrarResultadosVotacion() {
        // Calcular el total de votos sumando los votos de todos los candidatos
        int totalVotos = candidatos.stream().mapToInt(Candidato::getVotos).sum();
        // Mostrar encabezado de sección de resultados
        Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        Util.print("|||                         RESULTADOS                     |||");
        Util.print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
        // Mostrar el porcentaje de votos de cada candidato
        for (Candidato candidato : candidatos) {
            // Calcular el porcentaje de votos del candidato y formatear a 2 decimales
            double porcentaje = totalVotos > 0 ? (candidato.getVotos() * 100.0) / totalVotos : 0;
            // Imprimir el nombre del candidato y su porcentaje de votos formateado
            Util.print(String.format("%s (%.2f%%)", candidato.getNombre(), porcentaje));
        }
        // Imprimir el total de votos
        Util.print("Total de votos: " + totalVotos);
    }
}
