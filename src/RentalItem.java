import java.util.ArrayList;
import java.util.List;

public abstract class RentalItem {
    private String itemID;
    private String itemName;
    private boolean available;

    // Constructor
    public RentalItem(String itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.available = true; // Por defecto disponible
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract void showDetails();
}
