import java.util.ArrayList;

class Room {

    private final String roomName;
    private ArrayList<Reservation> reservationList; // Stores the reservation list
    private double basePrice;
    private boolean isReserved;                     // Just signifies if just one day is reserved for ease
    private int[] Calendar;         //new           // 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap, 0 isNotReserved

    public Room(String roomName) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.isReserved = false;
        reservationList = new ArrayList<>();
        this.Calendar = new int[31];
    }

    public ArrayList<Reservation> getReservations() {
        return reservationList;
    }

    public String getRoomName() {
        return this.roomName;
    }

    public int[] getCalendar() { // Array for the calendar
        return Calendar;
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

    public void displayCalendar() // new
    {
        int i;
        for (i = 0; i < this.Calendar.length; i++)
        {
            System.out.print(this.Calendar[i] + " ");
            if ((i + 1) % 7 == 0)
                System.out.println();
        }
    }

    public void setReservationList(int rTag, int checkInDate, int checkOutDate) {  // Sets all to 0 not reserved
        int i;

        if (rTag == 1) // Add Reservation
        {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if (i == checkInDate - 1)
                    this.Calendar[i] = 2;
                else if (i == checkOutDate - 1)
                    this.Calendar[i] = 3;
                else if (this.Calendar[i] == 3 || this.Calendar[i] == 2)
                    this.Calendar[i] = 4;
                else
                    this.Calendar[i] = 1;
            }
        }

        if (rTag == 0) // Cancel Reservation
        {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if (this.Calendar[i] != 4)
                    this.Calendar[i] = 0;
            }

        }
    }

    public int countCalendar() {
        int count = 0;
        for (Reservation reservation : this.reservationList) {
            count += reservation.getCheckOutDate() - reservation.getCheckInDate() + 1;
        }
        return count;
    }

    public void resetReservation() { // Check days reserved and if they are all 0, set reserved to false again
        if (this.countCalendar() == 0) {
            this.isReserved = false;
        }
    }

}
