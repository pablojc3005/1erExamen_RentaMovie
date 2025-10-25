import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerID;
    private String customerName;
    private List<Movie> rentedMovies;

    public Customer(String customerID, String customerName) {
        this.customerName = customerName;
        this.customerID = customerID;
        this.rentedMovies = new ArrayList<>();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public List<Movie> getRentedMovies() {
        return rentedMovies;
    }

    public void setRentedMovies(List<Movie> rentedMovies) {
        this.rentedMovies = rentedMovies;
    }

    // METODOS
    public void addRentedMovies(Movie movie) {
        if (rentedMovies != null) {
            rentedMovies.add(movie);
        }
    }

    public void removeRentedMovies(Movie movie) {
        if (rentedMovies != null) {
            rentedMovies.remove(movie);
        }
    }
    public void showCustomerDetails() {
        System.out.println("=== Detalles del Cliente ===");
        System.out.println("ID: " + customerID);
        System.out.println("Nombre: " + customerName);
        System.out.println("Películas rentadas: " + rentedMovies.size());

        if (!rentedMovies.isEmpty()) {
            System.out.println("Lista de películas rentadas:");
            for (Movie movie : rentedMovies) {
                System.out.println("  - " + movie.getItemName() + " (ID: " + movie.getItemID() + ")");
            }
        }
        System.out.println("============================");
    }
}
