package paquete;

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

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void mostrarInfo() {
        System.out.printf("%-10d %-30s %-10d %-30s %-10d %-20s\n", idPelicula, titulo, duracion, director, puntuacion, genero);
    }
}





