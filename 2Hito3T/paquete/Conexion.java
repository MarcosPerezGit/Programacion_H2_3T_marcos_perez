package paquete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection conectar() {
        String url = "jdbc:mysql://localhost:3306/cine_MarcosPerezRamirez";  //Aqui le estamos indicando la ruta de la base de datos
        String usuario = "root"; // Aqui escribimos el usuario 
        String contraseña = "root123"; // Aqui escribimos la contraseña

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println("¡CONEXION EXITOSA!"); // Si la conexion funciona nos escribe esto para que nos demos cuenta
            return conexion;
        } catch (SQLException e) {
            System.out.println("ERROR DE CONEXION: " + e.getMessage()); // Si la conexion no nos funciona nos mostrará este mensaje junto con el del error
            return null;
        }
    }
}
