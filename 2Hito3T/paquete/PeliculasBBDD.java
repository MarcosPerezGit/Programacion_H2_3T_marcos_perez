package paquete; 
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculasBBDD {

    public static List<Pelicula> obtenerPeliculas() {
        
        List<Pelicula> peliculas = new ArrayList<>(); 
        
        // Consulta SQL para mostrar todo lo que necesitamos
        String consulta = "SELECT p.id_pelicula, p.titulo, p.duracion, p.director, p.puntuacion, g.nombre_genero " +
                          "FROM peliculas p JOIN generos g ON p.id_genero = g.id_genero";

        // Conectamos y ejecutamos la consulta
        try (Connection conexion = Conexion.conectar();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            // Recorrido del resultado y creación de objetos Pelicula
            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                    rs.getInt("id_pelicula"),
                    rs.getString("titulo"),
                    rs.getInt("duracion"),
                    rs.getString("director"),
                    rs.getInt("puntuacion"),
                    rs.getString("nombre_genero")
                );
                peliculas.add(pelicula); // Añadimos la pelicula a la lista
            }

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage()); // Manejamos errores
        }

        return peliculas; // Devolvemos la lista de peliculas
    }
}


