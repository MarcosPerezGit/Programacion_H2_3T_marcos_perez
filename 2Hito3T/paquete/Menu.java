package paquete;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void mostrarMenu() {
        Scanner entrada = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("------- MENU -------");
            System.out.println("1 – VER PELICULAS");
            System.out.println("2 – AÑADIR PELICULA");
            System.out.println("3 – ELIMINAR PELICULA");
            System.out.println("4 – MODIFICAR PELICULA");
            System.out.println("5 – SALIR");
            System.out.print("SELECCIONE UNA OPCION: ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                    verPeliculas();
                    break;
                case 2:
                    anadirPelicula();
                    break;
                case 3:
                    eliminarPelicula();
                    break;
                case 4:
                    modificarPelicula();
                    break;
                case 5:
                    System.out.println("SALIENDO DE LA APLICACION...");
                    System.out.println("HASTA LUEGO!!");
                    break;
                default:
                    System.out.println("SELECCIONE UNA OPCION VALIDA");
            }

        } while (opcion != 5);
    }

    // Mostrar las películas
    public void verPeliculas() {
        List<Pelicula> peliculas = PeliculasBBDD.obtenerPeliculas();

        System.out.printf("%-10s %-30s %-10s %-30s %-10s %-20s\n", "ID", "TITULO", "DURACION", "DIRECTOR", "PUNTUACION", "GENERO");
        System.out.println("----------------------------------------------------------------------------");

        for (Pelicula pelicula : peliculas) {
            pelicula.mostrarInfo();
        }
    }

    // Añadir una nueva película
    public void anadirPelicula() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("AÑADE LOS DATOS NECESARIOS PARA REGISTRAR LA PELICULA:");

        System.out.print("ID DE LA PELICULA: ");
        int idPelicula = entrada.nextInt();
        entrada.nextLine();  

        System.out.print("TITULO: ");
        String titulo = entrada.nextLine();

        System.out.print("DURACION DE LA PELICULA EN MINUTOS: ");
        int duracion = entrada.nextInt();
        entrada.nextLine(); 

        System.out.print("DIRECTOR: ");
        String director = entrada.nextLine();

        System.out.print("PUNTUACION DE LA PELICULA (1-10): ");
        int puntuacion = entrada.nextInt();
        entrada.nextLine();

        System.out.print("GENERO DE LA PELICULA(1-3): ");
        String genero = entrada.nextLine();

        Pelicula pelicula = new Pelicula(idPelicula, titulo, duracion, director, puntuacion, genero);

        boolean exito = PeliculasBBDD.anadirPelicula(pelicula);
        if (exito) {
            System.out.println("SE HA AÑADIDO LA PELICULA");
        } else {
            System.out.println("ERROR!! YA EXISTE UNA PELICULA CON EL MISMO ID");
        }
    }

    // Eliminar una película
    public void eliminarPelicula() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("INTRODUZCA EL ID DE LA PELICULA QUE QUIERE ELIMINAR: ");
        int idPelicula = entrada.nextInt();

        boolean exito = PeliculasBBDD.eliminarPelicula(idPelicula);
        if (exito) {
            System.out.println("SE HA ELIMINADO LA PELICULA");
        } else {
            System.out.println("ERROR!! NO EXISTE NINGUNA PELICULA CON ESE ID");
        }
    }

    // Modificar una película
    public void modificarPelicula() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("INTRODUZCA EL ID DE LA PELICULA QUE QUIERE MODIFICAR: ");
        int idPelicula = entrada.nextInt();
        entrada.nextLine(); 

        Pelicula pelicula = PeliculasBBDD.obtenerPeliculaPorId(idPelicula);
        if (pelicula == null) {
            System.out.println("ERROR!! NO EXISTE NINGUNA PELICULA CON ESE ID");
            return;
        }

        System.out.println("ESTA ES LA PELICULA QUE BUSCA: ");
        pelicula.mostrarInfo();

        int camposModificados = 0;

        // Modificación del título
        System.out.print("NUEVO TÍTULO (DEJAR EN BLANCO PARA NO MODIFICAR): ");
        String nuevoTitulo = entrada.nextLine();
        if (!nuevoTitulo.isEmpty()) {
            pelicula.setTitulo(nuevoTitulo);
            camposModificados++; 
        }

        // Modificación de la puntuación
        System.out.print("NUEVA PUNTUACIÓN (DEJAR EN BLANCO PARA NO MODIFICAR): ");
        String nuevaPuntuacionStr = entrada.nextLine();
        if (!nuevaPuntuacionStr.isEmpty()) {
            int nuevaPuntuacion = Integer.parseInt(nuevaPuntuacionStr);
            pelicula.setPuntuacion(nuevaPuntuacion);
            camposModificados++; 
        }

        // Modificación de la duración
        System.out.print("NUEVA DURACIÓN (EN MINUTOS, DEJAR EN BLANCO PARA NO MODIFICAR): ");
        String nuevaDuracionStr = entrada.nextLine();
        if (!nuevaDuracionStr.isEmpty()) {
            int nuevaDuracion = Integer.parseInt(nuevaDuracionStr);
            pelicula.setDuracion(nuevaDuracion);
            camposModificados++; 
        }

        // Modificación del director
        System.out.print("NUEVO DIRECTOR (DEJAR EN BLANCO PARA NO MODIFICAR): ");
        String nuevoDirector = entrada.nextLine();
        if (!nuevoDirector.isEmpty()) {
            pelicula.setDirector(nuevoDirector);
            camposModificados++; 
        }

        // Modificación del género
        System.out.print("NUEVO GÉNERO (DEJAR EN BLANCO PARA NO MODIFICAR)(1-3): ");
        String nuevoGenero = entrada.nextLine();
        if (!nuevoGenero.isEmpty()) {
            pelicula.setGenero(nuevoGenero);
            camposModificados++; 
        }

        // Verificar si al menos dos campos han sido modificados
        if (camposModificados >= 2) {
            boolean exito = PeliculasBBDD.modificarPelicula(pelicula);
            if (exito) {
                System.out.println("PELICULA MODIFICADA EXITOSAMENTE.");
            } else {
                System.out.println("ERROR AL MODIFICAR LA PELICULA.");
            }
        } else {
            // Si no se modificaron al menos dos campos, mostramos un mensaje de error
            System.out.println("ERROR!! DEBE MODIFICAR AL MENOS DOS CAMPOS.");
        }
    }
}

