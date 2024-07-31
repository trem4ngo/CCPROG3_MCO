package model;

/**
 * This class extends the base price of the Room class.
 */
public class DeluxeRoom extends Room {

    public DeluxeRoom(String name) {
        super(name);
        this.basePrice = basePrice * 1.2;
    }
}
