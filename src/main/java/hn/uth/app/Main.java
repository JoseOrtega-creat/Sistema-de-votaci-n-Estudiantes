package hn.uth.app;

import hn.uth.app.pantallas.ModuloVotacionPantalla;

// Clase principal del programa
public class Main {
    // Método principal, punto de entrada del programa
    public static void main(String[] args) {
        // Crear una instancia de la clase ModuloVotacionPantalla
        ModuloVotacionPantalla votacionPantalla = new ModuloVotacionPantalla();
        // Iniciar el programa de votación
        votacionPantalla.iniciarPrograma();
    }
}
