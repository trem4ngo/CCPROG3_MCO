public class Reservation {

    private final String guestName;
    private final int checkInDate;
    private final int checkOutDate;

    private double totalPrice;
    private String discountCode;

    private final Room room;

    /**
     * Creates a reservation.
     *
     * @param guestName    name of the guest.
     * @param checkInDate  the date when the guest will check in.
     * @param checkOutDate the date when the guest will check out.
     * @param room         link to the room that the guest will stay at.
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = 0;
        this.discountCode = "";
    }

    public String getGuestName() {
        return guestName;
    }

    public int getCheckInDate() {
        return checkInDate;
    }

    public int getCheckOutDate() {
        return checkOutDate;
    }

    public Room getRoom() {
        return room;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
        System.out.println("Discount Code applied.");
    }

    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice(), totalPrice = numOfDays * basePrice; // Take note of modifiers in total
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. Days * $" + basePrice + " per night = $" + totalPrice;
    }

    public double getTotalDiscountedPrice() {  // Revamp to incorporate the priceModifiers
        int i;
        this.totalPrice = 0.0;

        // Calculate the total price with price modifiers
        for (i = this.checkInDate - 1; i < this.checkOutDate; i++) {
            this.totalPrice += this.room.getBasePrice() * this.room.getPriceModifiers(i); // Reservation then Room access (level)
        }

        switch (this.discountCode) {
            case "I_WORK_HERE":
                totalPrice *= 0.9; // 10% discount
                break;
            case "STAY4_GET1":
                if (this.checkOutDate - this.checkInDate >= 4)
                    totalPrice -= this.room.getBasePrice(); // Free 1 Room
                break;
            case "PAYDAY":
                if (this.checkInDate != 15 || this.checkOutDate != 30)
                    totalPrice *= 0.93;
                break;
            default:
                System.out.println("\nDiscount Code Not Valid.");
                break;
        }

        return this.totalPrice;
    }

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