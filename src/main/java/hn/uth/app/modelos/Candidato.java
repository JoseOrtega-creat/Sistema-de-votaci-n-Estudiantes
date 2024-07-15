package hn.uth.app.modelos;

// Clase que representa a un candidato
public class Candidato {
    // Atributos del candidato. Guardan la información sobre el candidato.
    private String nombre; // Nombre del candidato
    private int edad; // Edad del candidato
    private String partido; // Partido al que pertenece el candidato
    private int votos; // Número de votos recibidos por el candidato

    // Constructor de la clase Candidato. Inicializa los atributos con los valores dados.
    public Candidato(String nombre, int edad, String partido) {
        this.nombre = nombre;
        this.edad = edad;
        this.partido = partido;
        this.votos = 0; // Inicialmente, el candidato no tiene votos
    }

    // Métodos getter para obtener los atributos del candidato

    // Devuelve el nombre del candidato
    public String getNombre() {
        return nombre;
    }

    // Devuelve la edad del candidato
    public int getEdad() {
        return edad;
    }

    // Devuelve el partido del candidato
    public String getPartido() {
        return partido;
    }

    // Devuelve el número de votos del candidato
    public int getVotos() {
        return votos;
    }

    // Método para incrementar los votos del candidato en 1
    public void incrementarVotos() {
        this.votos++;
    }
}
