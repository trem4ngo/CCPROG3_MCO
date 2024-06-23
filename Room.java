public class Reservation {

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
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        this.totalPrice = numOfDays * this.room.getBasePrice();
        return this.totalPrice;
    }


    /*
     * tostring method where we just show the number of days and multiply to base price to show the totalprice
     */
    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice(), totalPrice = this.getTotalPrice();
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. Days * $" + basePrice + " per night = $" + totalPrice;
    }

    // Condition checking to verify if new reservation is possible. True if reservation is valid and false if not.
    public boolean checkReservation(int checkInDate, int checkOutDate) {
        for (Reservation reservation : this.room.getReservations()) {
            if (reservation != this) { // Exclude the current reservation
                if ((checkInDate >= reservation.getCheckInDate() && checkInDate < reservation.getCheckOutDate())
                 || (checkOutDate > reservation.getCheckInDate() && checkOutDate <= reservation.getCheckOutDate())
                 || (checkInDate == reservation.getCheckInDate() && checkOutDate == reservation.getCheckOutDate())) {
                    return false;
                }
            }
        }
        return true;
    }
}
