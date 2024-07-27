package model;

public class ExecutiveRoom extends Room {

    public ExecutiveRoom(String name) {
        super(name);
        this.basePrice = basePrice * 1.35;
    }

}
