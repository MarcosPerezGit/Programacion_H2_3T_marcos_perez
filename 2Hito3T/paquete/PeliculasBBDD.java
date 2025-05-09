package paquete;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PeliculasBBDD {

    // Método para obtener la lista de películas
    public static List<Pelicula> obtenerPeliculas() {
        List<Pelicula> peliculas = new ArrayList<>();
        String consulta = "SELECT p.id_pelicula, p.titulo, p.duracion, p.director, p.puntuacion, g.nombre_genero " +
                          "FROM peliculas p JOIN generos g ON p.id_genero = g.id_genero";

        try (Connection conexion = Conexion.conectar();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(consulta)) {

            while (rs.next()) {
                Pelicula pelicula = new Pelicula(
                    rs.getInt("id_pelicula"),
                    rs.getString("titulo"),
                    rs.getInt("duracion"),
                    rs.getString("director"),
                    rs.getInt("puntuacion"),
                    rs.getString("nombre_genero")
                );
                peliculas.add(pelicula);
            }

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
        }

        return peliculas;
    }

    // Método para agregar una película
    public static boolean anadirPelicula(Pelicula pelicula) {
        String consulta = "INSERT INTO peliculas (id_pelicula, titulo, duracion, director, puntuacion, id_genero) " +
                          "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {

            stmt.setInt(1, pelicula.getIdPelicula());
            stmt.setString(2, pelicula.getTitulo());
            stmt.setInt(3, pelicula.getDuracion());
            stmt.setString(4, pelicula.getDirector());
            stmt.setInt(5, pelicula.getPuntuacion());
            stmt.setString(6, pelicula.getGenero());  // Para el género

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
            return false;
        }
    }

    // Método para eliminar una película
    public static boolean eliminarPelicula(int idPelicula) {
        String consulta = "DELETE FROM peliculas WHERE id_pelicula = ?";
        try (Connection conexion = Conexion.conectar();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {

            stmt.setInt(1, idPelicula);
            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
            return false;
        }
    }

    // Método para modificar una película
    public static boolean modificarPelicula(Pelicula pelicula) {
        String consulta = "UPDATE peliculas SET titulo = ?, duracion = ?, director = ?, puntuacion = ?, id_genero = ? WHERE id_pelicula = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {

            stmt.setString(1, pelicula.getTitulo());
            stmt.setInt(2, pelicula.getDuracion());
            stmt.setString(3, pelicula.getDirector());
            stmt.setInt(4, pelicula.getPuntuacion());
            stmt.setString(5, pelicula.getGenero()); 
            stmt.setInt(6, pelicula.getIdPelicula());

            int filasAfectadas = stmt.executeUpdate();
            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
            return false;
        }
    }

    // Método para obtener una película por su id
    public static Pelicula obtenerPeliculaPorId(int idPelicula) {
        String consulta = "SELECT p.id_pelicula, p.titulo, p.duracion, p.director, p.puntuacion, g.nombre_genero " +
                          "FROM peliculas p JOIN generos g ON p.id_genero = g.id_genero WHERE p.id_pelicula = ?";

        try (Connection conexion = Conexion.conectar();
             PreparedStatement stmt = conexion.prepareStatement(consulta)) {

            stmt.setInt(1, idPelicula); 
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Pelicula pelicula = new Pelicula(
                    rs.getInt("id_pelicula"),
                    rs.getString("titulo"),
                    rs.getInt("duracion"),
                    rs.getString("director"),
                    rs.getInt("puntuacion"),
                    rs.getString("nombre_genero")
                );
                return pelicula; 
            } else {
                return null; 
            }

        } catch (SQLException e) {
            System.out.println("ERROR EN LA BASE DE DATOS: " + e.getMessage());
            return null; 
        }
    }
}