import java.util.List;

public class Movie extends RentalItem{
    private String director;
    private float duration;
    private int ageRating;
    private String genre;


    public Movie(String itemID, String itemName, String director, float duration, int ageRating, String genre) {
        super(itemID, itemName);
        this.director = director;
        this.duration = duration;
        this.ageRating = ageRating;
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public int getAgeRating() {
        return ageRating;
    }

    public void setAgeRating(int ageRating) {
        this.ageRating = ageRating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void showDetails() {
        System.out.println("=== Detalles de la Película ===");
        System.out.println("ID: " + getItemID());
        System.out.println("Título: " + getItemName());
        System.out.println("Director: " + director);
        System.out.println("Duración: " + duration + " minutos");
        System.out.println("Clasificación: " + ageRating);
        System.out.println("Género: " + genre);
        System.out.println("Disponible: " + (isAvailable() ? "Sí" : "No"));
        System.out.println("===============================");
    }
}
