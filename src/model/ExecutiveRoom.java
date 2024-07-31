package model;

/**
 * This class extends the base price of the Room class
 */
public class ExecutiveRoom extends Room {

    public ExecutiveRoom(String name) {
        super(name);
        this.basePrice = basePrice * 1.35;
    }

}
