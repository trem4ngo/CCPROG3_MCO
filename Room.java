import java.util.ArrayList;

/**
 * This class has details about a room of the hotel.
 * Details such as room name, base price, reservation list, reservation status, and a reservation calendar.
 */
public class Room {

    private final String roomName;
    private ArrayList<Reservation> reservationList; // Stores the reservation list
    private double basePrice;
    private boolean isReserved;                     // Just signifies if just one day is reserved for ease
    private int[] Calendar;         //new           // 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap, 5 isSameDay, 0 isNotReserved

    /**
     * Constructs and initializes a room.
     * @param roomName the name of the room.
     */
    public Room(String roomName) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.isReserved = false;
        reservationList = new ArrayList<>();
        this.Calendar = new int[31];
    }

    /**
     * Gets the list of reservations.
     * @return the reservation list.
     */
    public ArrayList<Reservation> getReservations() {
        return reservationList;
    }

    /**
     * Gets the name of the room.
     * @return the room name.
     */
    public String getRoomName() {
        return this.roomName;
    }

    /**
     * Gets the calendar with the reservations in it.
     * @return the calendar.
     */
    public int[] getCalendar() { // Array for the calendar
        return Calendar;
    }

    /**
     * Gets the base price of the room.
     * @return the base price.
     */
    public double getBasePrice() {
        return this.basePrice;
    }

    /**
     * Sets the new price for the room.
     * @param newPrice the new base price of the room.
     */
    public void setBasePrice(double newPrice) { // remove if no usage
        this.basePrice = newPrice;
    }

    /**
     * Gets the status of the room.
     * @return a true if the room is reserved, false otherwise.
     */
    public boolean isReserved() {
        return this.isReserved;
    }

    /**
     * Sets the room to be reserved or not.
     * @param reserved the reserve status of a room.
     */
    public void setReserved(boolean reserved) {     // Sets a room to true (isReserved)
        this.isReserved = reserved;
    }

    
    /**
     * Displays a calendar with reservations in it.
     */
    public void displayCalendar() // new
    {
        int i;
        for (i = 0; i < this.Calendar.length; i++) {
            System.out.print(this.Calendar[i] + " ");
            if ((i + 1) % 7 == 0)
                System.out.println();
        }
    }

    /**
     * Sets the reservations for the room.
     * @param rTag a mode to know if a reservation will be added or canceled.
     * @param checkInDate the check in date of the reservation.
     * @param checkOutDate the check out date of the reservation.
     */
    public void setReservationList(int rTag, int checkInDate, int checkOutDate) {  // Sets all to 0 not reserved
        int i;

        if (rTag == 1) // Add Reservation
        {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if ((this.Calendar[i] == 3 && checkInDate - 1 == i) || (this.Calendar[i] == 2 && checkOutDate - 1 == i)
                 || (this.Calendar[i] == 5 && checkOutDate - 1 == i) || (this.Calendar[i] == 5 && checkInDate - 1 == i))
                    this.Calendar[i] = 4;
                else if (checkInDate == checkOutDate)
                    this.Calendar[i] = 5;
                else if (i == checkInDate - 1)
                    this.Calendar[i] = 2;
                else if (i == checkOutDate - 1)
                    this.Calendar[i] = 3;
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

    /**
     * Counts how many days are reserved the room is reserved for.
     * @return the number of days that the rooms is reserved.
     */
    public int countCalendar() {
        int count = 0;
        for (Reservation reservation : this.reservationList) {
            count += reservation.getCheckOutDate() - reservation.getCheckInDate() + 1;
        }
        return count;
    }

    /**
     * Checks if there are no more reservations for the room, this is to set isReserved (boolean) to false.
     */
    public void resetReservation() { // Check days reserved and if they are all 0, set reserved to false again
        if (this.countCalendar() == 0 && this.isReserved) {
            this.isReserved = false;
        }
    }

}
