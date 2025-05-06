package paquete;

// Atributos de la clase Pelicula
public class Pelicula {
    private int idPelicula;
    private String titulo;
    private int duracion;
    private String director;
    private int puntuacion;
    private String genero;
    
// Constructor de la clase Pelicula
    
    public Pelicula(int idPelicula, String titulo, int duracion, String director, int puntuacion, String genero) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.duracion = duracion;
        this.director = director;
        this.puntuacion = puntuacion;
        this.genero = genero;
    }

// Definimos un metodo para mostrar la informacion de la pelicula utiliazndo un printf
    public void mostrarInfo() {
        System.out.printf("%-10d %-30s %-10d %-30s %-10d %-20s\n", idPelicula, titulo, duracion, director, puntuacion, genero);
    }
}

