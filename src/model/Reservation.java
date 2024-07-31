package model;

/**
 * This class has the details of a reservation and checks if the reservation is valid.
 * It has details such as guest name, check in date, check out date, selected room of the reservation, and total price of the reservation.
 */
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
     * @param guestName name of the guest
     * @param checkInDate the date when the guest will check in
     * @param checkOutDate the date when the guest will check out
     * @param room link to the room that the guest will stay at
     */
    public Reservation(String guestName, int checkInDate, int checkOutDate, Room room) {
        this.guestName = guestName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.room = room;
        this.totalPrice = 0;
        this.discountCode = "";
    }

    /**
     * Gets the guest name.
     *
     * @return the guest name
     */
    public String getGuestName() {
        return guestName;
    }

    /**
     * Gets the check in date.
     *
     * @return the check in date
     */
    public int getCheckInDate() {
        return checkInDate;
    }

    /**
     * Gets the check-out date.
     *
     * @return the check-out date
     */
    public int getCheckOutDate() {
        return checkOutDate;
    }

    /**
     * Gets the room.
     *
     * @return the room
     */
    public Room getRoom() {
        return room;
    }

    /**
     * Sets a discount code.
     *
     * @param discountCode the discount code
     */
    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
        System.out.println("Discount Code applied.");
    }

    /**
     * Gets the price breakdown.
     *
     * @return a string of total price breakdown, reserved days, price per night, total price, and total price with modifier.
     */
    public String getPriceBreakdown() {
        int numOfDays = this.checkOutDate - this.checkInDate + 1;
        double basePrice = this.room.getBasePrice(), total = numOfDays * basePrice;
        return "Total Price Breakdown: " + "You reserved for a total of " + numOfDays + " days. \nDays * $" + basePrice + " per night = $" + total
                + "\nWith Modifiers/Discount applied: " + getTotalDiscountedPrice();
    }

    /**
     * Gets the total discounted price.
     *
     * @return the total price after the discounts
     */
    public double getTotalDiscountedPrice() {
        int i;
        this.totalPrice = 0.0;

        // Calculate the total price with price modifiers
        for (i = this.checkInDate - 1; i < this.checkOutDate; i++) {
            this.totalPrice += this.room.getBasePrice() * this.room.getPriceModifiers(i); // model.Reservation then model.Room access (level)
        }

        switch (this.discountCode) {
            case "I_WORK_HERE":
                totalPrice *= 0.9; // 10% discount
                break;
            case "STAY4_GET1":
                if (this.checkOutDate - this.checkInDate >= 4)
                    totalPrice -= this.room.getBasePrice(); // Free 1 model.Room
                break;
            case "PAYDAY":
                if ((this.checkInDate <= 15 && this.checkOutDate > 15) || (this.checkInDate <= 30 && this.checkOutDate > 30)) 
                    totalPrice *= 0.93; // 7% discount
                break;
            default:
                System.out.println("\nDiscount Code Not Valid.");
                break;
        }

        return this.totalPrice;
    }

    /**
     * Checks the reservation dates if valid, returns true, else false.
     *
     * @param checkInDate the check-in date of the reservation
     * @param checkOutDate the check-out date of the reservation
     * @return false if the reservation already exists
     */
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
