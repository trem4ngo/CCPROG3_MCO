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

    public void calculateTotalPrice() {  // Total price for only one reservation
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        this.totalPrice = numOfDays * this.room.getBasePrice();
    }

    /*
     * tostring method where we just show the number of days and multiply to base price to show the totalprice
     */
    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice();
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. Days * $" + basePrice + " per night = $" + this.totalPrice;
    }

    // Condition checking to verify if new reservation is possible. True if reservation is valid and false if not.
    // CHECKING
    public boolean checkReservations() {
        int i;
        int[] reservedDays == room.getDaysReserved();

        if (this.CheckOutDate == 1 || this.CheckInDate == 31 || this.CheckInDate == 0 || this.CheckOutDate == 0)
            return false;
        else{
            for (i = this.CheckInDate-1; i < this.CheckOutDate; i++){
                if (reservedDays[i] != 0)
                    return false;
            }
        }

        return true;
    }

}
