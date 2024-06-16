import java.util.ArrayList;

class Room {

    private ArrayList<Reservation> reservationList; // Stores the reservation list -- static is used to be used in other classes
    private final String roomName;
    private double basePrice;
    private boolean isReserved;                     // Just signifies if just one day is reserved for ease
    private int[] daysReserved;                     // 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap, 0 isNotReserved

    public Room(String roomName) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.isReserved = false;
        reservationList = new ArrayList<>();
        this.daysReserved = new int[31];
    }

    public ArrayList<Reservation> getReservations() {
        return reservationList;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public void setReservationList(int rTag, int checkInDate, int checkOutDate) {  // Sets all to 0 not reserved
        int i;

        if (rTag != 0) {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if (i == checkInDate - 1)
                    this.daysReserved[i] = 2;
                else if (i == checkOutDate - 1)
                    this.daysReserved[i] = 3;
                else if (this.daysReserved[i] == 3 || this.daysReserved[i] == 2)
                    this.daysReserved[i] = 4;
                else
                    this.daysReserved[i] = 1;
            }
        }

        if (rTag == 0)
        {
            for (i = checkInDate - 1; i < checkOutDate; i++)
                this.daysReserved[i] = 0;
        }
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

    // Create a method to check days reserved and if they are all 0, set reserved to false again

}
