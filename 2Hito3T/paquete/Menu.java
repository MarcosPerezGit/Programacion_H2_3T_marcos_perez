package paquete;

import java.util.List;
import java.util.Scanner;

public class Menu {

	// Aqui creamos el metodo mostrarMenu para poder mostrar el menu de la aplicacion
    public void mostrarMenu() {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
        	System.out.println("------- MENU -------");
            System.out.println("1 – VER PELICULAS");
            System.out.println("2 – SALIR");
            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = entrada.nextInt();

            switch (opcion) { // Creamos un switch case y dependiendo de la opcion que se seleccione pues hara una cosa u otra
                case 1:
                    verPeliculas();
                    break;
                case 2:
                    System.out.println("SALIENDO DE LA APLICACION...");
                    System.out.println("HASTA LUEGO!!");
                    break;
                default:
                    System.out.println("SELECCIONE UNA OPCION VALIDA");
            }

        } while (opcion != 2);
    }

    // Creamos otro metodo para poder mostrar las peliculas en nuestro menu
    public void verPeliculas() {
        List<Pelicula> peliculas = PeliculasBBDD.obtenerPeliculas();

        System.out.printf("%-10s %-30s %-10s %-30s %-10s %-20s\n", "ID", "TITULO", "DURACION", "DIRECTOR", "PUNTUACION", "GENERO");
        System.out.println("----------------------------------------------------------------------------");

        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo(); 
        }
    }
}
