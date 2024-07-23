public class DeluxeRoom extends Room {

    public DeluxeRoom(String name) {
        super(name);
        this.basePrice = basePrice * 1.2;
    }
}
