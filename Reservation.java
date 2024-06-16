import java.util.ArrayList;

class Reservation {

    private String guestName;
    private int checkInDate;
    private int checkOutDate;
    private Room room;
    private double totalPrice;

    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = 0;

    }

    /*
     * overlaps method (allows check in and out on the same day)
     */

    public String getGuestName() {
        return this.guestName;
    }

    public int getCheckInDate() {
        return this.checkInDate;
    }

    public int getCheckOutDate() {
        return this.checkOutDate;
    }

    public Room getRoom() {
        return this.room;
    }

    public double getTotalPrice() {
        return this.totalPrice;
    }

    /*
     * if lets say check in and out is in the same day make a condition that it would equal to 1
     */
    public double calculateTotalPrice() {  // Total price for only one reservation

    }

    // we should have a calculation for the total price of one reservation and the total price of reservation through all rooms

    /*
     * tostring method where we just show the number of days and multiply to base price to show the totalprice
     */
    public String getPriceBreakdown() {
        return "Total Price Breakdown: " + "You applied to total (days) and your total cost for this reservation would be....";
    }


}
