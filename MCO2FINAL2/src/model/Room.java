package model;

import java.util.ArrayList;

/**
 * This class has details about a room of the hotel.
 * Details such as room name, base price, reservation list, reservation status, and a reservation calendar for each room.
 */
public class Room {

    private final String roomName;
    private final ArrayList<Reservation> reservationList; // Stores the reservation list

    protected double basePrice;
    private boolean isReserved;                           // Just signifies if just one day is reserved

    private final int[] isReservedTable;                  // 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap, 5 isSameDay, 0 isNotReserved
    private final double[] priceModifiers;                // Calendar for the price modifier


    /**
     * Constructs and initializes a room.
     *
     * @param roomName the name of the room.
     */
    public Room(String roomName) {
        this.roomName = roomName;
        this.basePrice = 1299.0;
        this.isReserved = false;
        reservationList = new ArrayList<>();
        this.isReservedTable = new int[31];
        this.priceModifiers = new double[31];

        for (int i = 0; i < 31; i++)
            this.priceModifiers[i] = 1.0; // All at 100% or base price
    }

    public String getRoomName() {
        return this.roomName;
    }

    public ArrayList<Reservation> getReservations() {
        return reservationList;
    }

    public double getBasePrice() {
        return this.basePrice;
    }

    public double getPriceModifiers(int index) {
        return this.priceModifiers[index];
    }

    public String[] getReservationNames() {
        String[] names = new String[reservationList.size()];
        int i;
        for (i = 0; i < reservationList.size(); i++) {
            Reservation reservation = reservationList.get(i);
            names[i] = reservation.getGuestName();
        }
        return names;
    }

    public String getReservationInfo(int selectedIndex) {
        if (selectedIndex < 0 || selectedIndex >= reservationList.size())
            return "No reservation selected.";

        Reservation selectedReservation = reservationList.get(selectedIndex);
        Room room = selectedReservation.getRoom(); // Room Link
        return "Guest Name: " + selectedReservation.getGuestName() +
                "\n\nCheck-in Date: " + selectedReservation.getCheckInDate() +
                "\nCheck-out Date: " + selectedReservation.getCheckOutDate() +
                "\n\nRoom Name: " + room.getRoomName() +
                "\n\n" + selectedReservation.getPriceBreakdown();
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }

    public void setReserved(boolean reserved) {
        this.isReserved = reserved;
    }

    public boolean isReserved() {
        return this.isReserved;
    }

    public void setReservationList(int rTag, int checkInDate, int checkOutDate) {  // Sets all to 0 not reserved
        int i;

        if (rTag == 1) // Add model.Reservation
        {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if ((this.isReservedTable[i] == 3 && checkInDate - 1 == i) || (this.isReservedTable[i] == 2 && checkOutDate - 1 == i) || (this.isReservedTable[i] == 5 && checkOutDate - 1 == i) || (this.isReservedTable[i] == 5 && checkInDate - 1 == i))
                    this.isReservedTable[i] = 4;
                else if (i == checkInDate - 1)
                    this.isReservedTable[i] = 2;
                else if (i == checkOutDate - 1)
                    this.isReservedTable[i] = 3;
                else
                    this.isReservedTable[i] = 1;
            }
        }

        if (rTag == 0) // Cancel model.Reservation
        {
            for (i = checkInDate - 1; i < checkOutDate; i++) {
                if (this.isReservedTable[i] != 4)
                    this.isReservedTable[i] = 0;
            }

        }
    }

    public void setPriceModifiers (int checkInDate, int checkOutDate, double modifier)
    {
        int i;
        if (modifier < 0.50 || modifier > 1.50 || checkInDate < 1 || checkInDate > 30 || checkOutDate < 2 || checkOutDate > 31)
        {
            System.out.println("Modifier must be greater than or equal to 50% and dates must be valid.");
            return;
        }

        for (i = checkInDate - 1; i < checkOutDate; i++)
            this.priceModifiers[i] = modifier;
        System.out.println("Date Modifier changed successfully.");
    }


    public void resetReservation() {
        if (this.countCalendar() == 0 && this.isReserved)
            this.isReserved = false;
    }

    public int countCalendar() {
        int count = 0;
        for (Reservation reservation : this.reservationList) {
            count += reservation.getCheckOutDate() - reservation.getCheckInDate() + 1;
        }
        return count;
    }

    public String displayIsReservedTable() {
        StringBuilder sb = new StringBuilder();
        int i;
        for (i = 0; i < this.isReservedTable.length; i++) {
            sb.append(this.isReservedTable[i]).append(" ");
            if ((i + 1) % 7 == 0)
                sb.append("\n");
        }
        return sb.toString();
    }

}


