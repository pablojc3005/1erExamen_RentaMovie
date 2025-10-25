import java.util.ArrayList;
import java.util.List;

public class MovieRentalSystem {
    private List<RentalItem> rentalItems;
    private List<Customer> customers;

    // Constructor
    public MovieRentalSystem() {
        this.rentalItems = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    // Añadir ítems al sistema
    public void addItem(RentalItem item) {
        rentalItems.add(item);
        System.out.println("Ítem añadido: " + item.getItemName());
    }

    // Registrar cliente
    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Cliente registrado: " + customer.getCustomerName());
    }

    // Rentar película a cliente
    public void rentMovieToCustomer(String customerID, String movieID) {
        Customer customer = findCustomerByID(customerID);
        Movie movie = findMovieByID(movieID);

        if (customer == null) {
            System.out.println("Error: Cliente no encontrado.");
            return;
        }

        if (movie == null) {
            System.out.println("Error: Película no encontrada.");
            return;
        }

        if (!movie.isAvailable()) {
            System.out.println("Error: La película no está disponible.");
            return;
        }

        // Realizar la renta
        movie.setAvailable(false);
        customer.addRentedMovies(movie);
        System.out.println("Película '" + movie.getItemName() + "' rentada a " + customer.getCustomerName());
    }

    // Procesar devolución de película
    public void returnMovie(String customerID, String movieID) {
        Customer customer = findCustomerByID(customerID);
        Movie movie = findMovieByID(movieID);

        if (customer == null || movie == null) {
            System.out.println("Error: Cliente o película no encontrados.");
            return;
        }

        if (!customer.getRentedMovies().contains(movie)) {
            System.out.println("Error: El cliente no tiene esta película rentada.");
            return;
        }

        // Procesar devolución
        movie.setAvailable(true);
        customer.removeRentedMovies(movie);
        System.out.println("Película '" + movie.getItemName() + "' devuelta por " + customer.getCustomerName());
    }

    // Mostrar todos los ítems
    public void showAllItems() {
        System.out.println("\n=== TODOS LOS ÍTEMS DISPONIBLES ===");
        if (rentalItems.isEmpty()) {
            System.out.println("No hay ítems en el sistema.");
        } else {
            for (RentalItem item : rentalItems) {
                item.showDetails();
            }
        }
    }

    // Mostrar todos los clientes
    public void showAllCustomers() {
        System.out.println("\n=== TODOS LOS CLIENTES REGISTRADOS ===");
        if (customers.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            for (Customer customer : customers) {
                customer.showCustomerDetails();
            }
        }
    }

    // Métodos auxiliares privados
    private Customer findCustomerByID(String customerID) {
        for (Customer customer : customers) {
            if (customer.getCustomerID().equals(customerID)) {
                return customer;
            }
        }
        return null;
    }

    private Movie findMovieByID(String movieID) {
        for (RentalItem item : rentalItems) {
            if (item instanceof Movie && item.getItemID().equals(movieID)) {
                return (Movie) item;
            }
        }
        return null;
    }

    // Getters para las listas (opcionales)
    public List<RentalItem> getRentalItems() {
        return rentalItems;
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
