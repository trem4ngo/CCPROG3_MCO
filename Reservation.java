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
    
    // Reserves the days that customers reserved. 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap
    public void addReservation() {
        int i;
        int cID = reservation.getCheckInDate()-1;
        int cOD = reservation.getCheckOutDate()-1;

        for (i = cID; i < cOD; i++){
            if(i == cID)
                daysReserved[i] = 2;
            else if(i == cOD)
                daysReserved[i] = 3;
            else if(daysReserved[i] == 3 || daysReserved[i] == 2)
                daysReserved[i] = 4;
            else
                daysReserved[i] = 1;
        } 
    }

    // Need to do something about overlaps. Might need a method to check other reservations and make sure the dates are always reserved or reuse addReservation.
    public void cancelReservation() {
	    int i;
        int cID = reservation.getCheckInDate()-1;
        int cOD = reservation.getCheckOutDate()-1;

        for (i = cID; i < cOD; i++)
                daysReserved[i] = 0;
    }

    /*
     * if lets say check in and out is in the same day make a condition that it would equal to 1
     */
    public boolean checkValidity() {

    }

}
