import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear el sistema de renta
        MovieRentalSystem rentalSystem = new MovieRentalSystem();
        Scanner scanner = new Scanner(System.in);

        // Instanciar películas de ejemplo
        Movie movie1 = new Movie("MOV01","El Padrino",  "Francis Ford Coppola", 175, 120, "Drama");
        Movie movie2 = new Movie("MOV02","Pulp Fiction", "Quentin Tarantino", 154, 160, "Crimen");
        Movie movie3 = new Movie("MOV03","El Señor de los Anillos",  "Peter Jackson", 180, 180, "Fantasía");
        Movie movie4 = new Movie("MOV04","Toy Story", "John Lasseter", 81, 100, "Animación");

        // Añadir películas al sistema
        rentalSystem.addItem(movie1);
        rentalSystem.addItem(movie2);
        rentalSystem.addItem(movie3);
        rentalSystem.addItem(movie4);

        // Registrar clientes de ejemplo
        Customer customer1 = new Customer("CUST01", "Pablo Sedano");
        Customer customer2 = new Customer("CUST02", "Alexander Corzo");
        Customer customer3 = new Customer("CUST03", "Samir Cordova");

        rentalSystem.registerCustomer(customer1);
        rentalSystem.registerCustomer(customer2);
        rentalSystem.registerCustomer(customer3);

        // Interfaz de consola
        int opcion;
        do {
            System.out.println("\n=== SISTEMA DE RENTA DE PELÍCULAS ===");
            System.out.println("1. Mostrar todas las películas");
            System.out.println("2. Mostrar todos los clientes");
            System.out.println("3. Rentar película");
            System.out.println("4. Devolver película");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    rentalSystem.showAllItems();
                    break;

                case 2:
                    rentalSystem.showAllCustomers();
                    break;

                case 3:
                    System.out.print("Ingrese ID del cliente: ");
                    String clienteRenta = scanner.nextLine();
                    System.out.print("Ingrese ID de la película: ");
                    String peliculaRenta = scanner.nextLine();
                    rentalSystem.rentMovieToCustomer(clienteRenta, peliculaRenta);
                    break;

                case 4:
                    System.out.print("Ingrese ID del cliente: ");
                    String clienteDevolucion = scanner.nextLine();
                    System.out.print("Ingrese ID de la película: ");
                    String peliculaDevolucion = scanner.nextLine();
                    rentalSystem.returnMovie(clienteDevolucion, peliculaDevolucion);
                    break;

                case 5:
                    System.out.println("¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();

    }
}
