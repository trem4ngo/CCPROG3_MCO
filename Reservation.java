import java.util.ArrayList;

class Room {

    private final String roomName;
    private double basePrice;
    private boolean isReserved;                     // Just signifies if just one day is reserved for ease
    private static ArrayList<Reservation> reservationList; // Stores the reservation list -- static is used to be used in other classes
    private int[] daysReserved;                     // 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap, 0 isNotReserved

    public Room(String roomName) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.isReserved = false;
        reservationList = new ArrayList<>();
        this.daysReserved = new int[31];
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setReservationList() {  // Sets all to 0 not reserved
        int i;
        for (i = 0; i < daysReserved.length; i++)
            daysReserved[i] = 0;
    }

    public static ArrayList<Reservation> getReservations() {
        return reservationList;
    }

    public int[] getDaysReserved() {
        return daysReserved;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(double newPrice) {
        this.basePrice = newPrice;
    }

    public boolean isReserved() {
        return this.isReserved;
    } // Checks and returns if room is reserved

    public void setReserved(boolean reserved) {     // Sets a room to true (isReserved)
        this.isReserved = reserved;
    }

    public int countDaysReserved() {
        int count = 0;
        for (Reservation reservation : reservationList) {
            count += reservation.getCheckOutDate() - reservation.getCheckInDate() + 1;
        }
        return count;
    }


}
