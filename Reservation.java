import java.util.ArrayList;

/**
 * This class has the details of a reservation and checks if the reservation is valid.
 * It has details such as guest name, check in date, check out date, selected room of the reservation, and total price of the reservation.
 */    
public class Reservation {

    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private double totalPrice;

    /**
     * Creates a reservation.
     * @param guestName name of the guest.
     * @param checkInDate the date when the guest will check in.
     * @param checkOutDate the date when the guest will check out.
     * @param room the room that the guest will stay at.
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = 0;
    }

    /**
     * Gets the name of the guest.
     * @return the guest's name.
     */
    public String getGuestName() {
        return this.guestName;
    }

    /**
     * Gets the check out date of the reservation
     * @return the check in date.
     */
    public int getCheckInDate() {
        return this.checkInDate;
    }

    /**
     * Gets the check out date of the reservation
     * @return the check out date.
     */
    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    /**
     * Gets the room selected.
     * @return the room.
     */
    public Room getRoom() {
        return this.room;
    }

    /**
     * Gets the total price of the reservation.
     * @return the total price.
     */
    public double getTotalPrice() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        return this.totalPrice = numOfDays * this.room.getBasePrice();
    }

    /**
     * Gets the total price breakdown of the reservation.
     * @return a string of number of days, base price, and total price.
     */
    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice();
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. Days * $" + basePrice + " per night = $" + this.totalPrice;
    }

    /**
     * A method that checks if a reservation is valid.
     * @param checkInDate the date when the guest will check in.
     * @param checkOutDate the date when the guest will check out.
     * @return a true if reservation is valid, false otherwise.
     */
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
