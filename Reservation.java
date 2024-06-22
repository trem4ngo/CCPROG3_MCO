import java.util.ArrayList;
/**
 * This Reservation class represents the details of the reservation in a hotel.
 * It has details like the guest name, check in date, check out date, total price, etc.
 */    
class Reservation {

    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private double totalPrice;

    /**
     * Constructor for the reservation
     * @param guestName name of the guest reserving
     * @param checkInDate the date when the guest will check in
     * @param checkOutDate the date when the guest will check out
     * @param room the room that the guest will stay at
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = 0;
    }

    /**
     * Gets the name of the guest
     * @return the guest name (String)
     */
    public String getGuestName() {
        return this.guestName;
    }

    /**
     * Gets the check out date of the reservation
     * @return the check out date (int)
     */
    public int getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Gets the check out date of the reservation
     * @return the check out date (int)
     */
    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Gets the room details of the reservation
     * @return the room details (Room)
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Gets the total price of the reservation
     * @return the total price (double)
     */
    public double getTotalPrice() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        return this.totalPrice = numOfDays * this.room.getBasePrice();
    }

    /**
     * Gets the total price breakdown of the reservation
     * @return a string of number of days, base price, and total price
     */
    /*
     * tostring method where we just show the number of days and multiply to base price to show the totalprice
     */
    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice();
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. Days * $" + basePrice + " per night = $" + this.totalPrice;
    }

    /**
     * A method that checks if a reservation is valid
     * @param checkInDate the date when the guest will check in
     * @param checkOutDate the date when the guest will check out
     */
    // Condition checking to verify if new reservation is possible. True if reservation is valid and false if not.
    public boolean checkReservation(int checkInDate, int checkOutDate) {
        int i;
        int[] reservedDays = room.getCalendar();

        if (checkOutDate == 1 || checkInDate == 31 || checkInDate == 0 || checkOutDate == 0)
            return false;
        else {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if (reservedDays[i] == 1)
                    return false;
            }
        }
        return true;
    }
}
