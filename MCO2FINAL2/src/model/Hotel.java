package model;

import java.util.ArrayList;

/**
 * This class has the details of the hotel and handles the rooms and reservations of the hotel.
 * The model.Hotel class contains details such as hotel ID, hotel name, room list, room number, total earnings, and total reservations in the hotel.
 */
public class Hotel {

    private final int hotelID;
    private String hotelName;

    private final ArrayList<Room> roomList;
    private int roomNumber;
    private Room selectedRoom;

    private double totalEarnings;
    private int totalReservations;

    /**
     * Constructs a hotel and initializes a room and its total earnings.
     *
     * @param hotelName the name of the hotel.
     * @param hotelID   the id of the hotel.
     */
    public Hotel(String hotelName, int hotelID) {
        this.hotelName = hotelName;
        this.hotelID = hotelID;
        roomList = new ArrayList<>();
        this.roomNumber = 1;                // When we create hotel, room number would be 1
        this.totalEarnings = 0;
        this.totalReservations = 0;
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public int getNumberOfRooms() {
        return roomList.size();
    }

    public Room getSelectedRoom() {
        return selectedRoom;
    }

    public String[] getRoomNames() {
        String[] names = new String[roomList.size()];
        int i;
        for (i = 0; i < roomList.size(); i++) {
            Room room = roomList.get(i);
            names[i] = room.getRoomName();
        }
        return names;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public boolean setPriceModifiersForAllRooms(int checkInDate, int checkOutDate, double modifier) {
        if (this.hasReservation()) {
            System.out.println("Cannot update room prices while reservations are made."); // Error as well for GUI
            return false;
        }

        for (Room room : this.roomList)
            room.setPriceModifiers(checkInDate, checkOutDate, modifier);
        return true;
    }

    public void setSelectedRoom (String roomName) {
        for (Room room : roomList)
            if (room.getRoomName().equalsIgnoreCase(roomName)) {
                this.selectedRoom = room;
                break;
            }
    }

    public void addRoom(int numberOfRooms, String roomType) {
        int i;
        String roomName;

        if ((numberOfRooms + getNumberOfRooms()) > 50)
            throw new IllegalArgumentException("Maximum number of rooms reached. Hotel can only accommodate 50 rooms.");

        for (i = 0; i < numberOfRooms; i++) {
            roomName = Character.toString(roomType.charAt(0)).toUpperCase() + this.hotelID + String.format("%03d", this.roomNumber++);

            switch (roomType) {
                case "Standard":
                    roomList.add(new Room(roomName));
                    break;
                case "Deluxe":
                    roomList.add(new DeluxeRoom(roomName));
                    break;
                case "Executive":
                    roomList.add(new ExecutiveRoom(roomName));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid room type: " + roomType);
            }
        }
        System.out.println("Created " + numberOfRooms + " " + roomType + " " + "room(s).");
    }


    public void removeRoom(int numberOfRooms) {
        int i, numOfRooms = numberOfRooms;

        if (numberOfRooms <= 0 || numberOfRooms >= this.roomList.size()) {
            System.out.println("Invalid number of rooms to remove.");
            return;
        }

        // Confirm action
        for (i = this.roomList.size() - 1; i >= 0 && numOfRooms > 0; i--) {
            Room roomToRemove = this.roomList.get(i); // Remove the last room each time loop iterates but checks first
            if (!roomToRemove.isReserved()) {
                this.roomList.remove(roomToRemove);
                System.out.println("Room " + roomToRemove.getRoomName() + " is successfully removed.");
                numOfRooms--;
            } else {
                System.out.println("Cannot remove room " + roomToRemove.getRoomName() + " that is Reserved.");
            }
        }
    }

    //textbox number of rooms
    public boolean updateRoomPrice(double basePrice) {
        if (this.hasReservation()) {
            System.out.println("Cannot update room prices while reservations are made."); // Error as well for GUI
            return false;
        }
        if (basePrice < 100) {
            System.out.println("Base price should be at least 100.");
            return false;
        }

        System.out.println("\nNo rooms are Reserved. You can update the price."); // Back-end validation purposes

        for (Room room : this.roomList) {
            room.setBasePrice(basePrice);
        }
        return true;
    }

    public boolean addReservation(String guestName, int checkInDate, int checkOutDate, String discountCode) {
        boolean flag;
        if (checkInDate < 1 || checkOutDate < 2 || checkOutDate > 31 || checkOutDate <= checkInDate)
            throw new IllegalArgumentException("Invalid dates.");

        Reservation newReservation = new Reservation(guestName, checkInDate, checkOutDate, this.selectedRoom);
        flag = newReservation.checkReservation(checkInDate, checkOutDate);

        if (flag)
        {
            selectedRoom.getReservations().add(newReservation);                 // Adds reservation to reservationList
            selectedRoom.setReservationList(1, checkInDate, checkOutDate); // Puts days reserved in the calendar
            this.totalReservations++;
            selectedRoom.setReserved(true); // Sets room to 'reserved' or 'true' for isReserved
            newReservation.setDiscountCode(discountCode);
            System.out.println("\nReservation is successfully added.\n");
            return true;
        } else
            System.out.println("\nRoom is already reserved on the selected dates.\n");
        return false;
    }

    public boolean cancelReservation(String selectedGuestName) {
        if (!this.hasReservation())
        {
            System.out.println("\nThere is no reservation to cancel.\n");
            return false;
        }

        Reservation selectedReservation = null;
        for (Reservation reservation : selectedRoom.getReservations()) {
            if (reservation.getGuestName().equalsIgnoreCase(selectedGuestName)) {
                selectedReservation = reservation;
                break;
            }
        }

        if (selectedReservation == null) {
            System.out.println("\nNo reservation found for the given Guest Name.\n");
            return false;
        }

        // Remove the selected reservation from the room and update the total reservations
        this.totalReservations--;
        this.totalEarnings -= selectedReservation.getTotalDiscountedPrice();
        selectedRoom.getReservations().remove(selectedReservation);
        selectedRoom.setReservationList(0, selectedReservation.getCheckInDate(), selectedReservation.getCheckOutDate());
        selectedRoom.resetReservation(); // For resetting purposes, if there are no reservation
        System.out.println("\nSuccessfully removed the reservation by " + selectedReservation.getGuestName());
        System.out.println("\nTotal Reservations left in the Hotel: " + this.totalReservations);

        return true;
    }

    public double calculateEstimatedEarnings() {   // based on reservation ITERATE THROUGH ALL ROOMS
        double totalEarnings = 0.0;
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                totalEarnings += reservation.getTotalDiscountedPrice();
            }
        }
        this.totalEarnings = totalEarnings; // Update

        return this.totalEarnings;
    }

    public Room findRoomByName(String roomName) {
        for (Room room : roomList) {
            if (room.getRoomName().equals(roomName)) {
                return room;
            }
        }
        return null;
    }

    public Reservation findReservationByGuestName(Room room, String guestName) {
        for (Reservation reservation : room.getReservations()) {
            if (reservation.getGuestName().equalsIgnoreCase(guestName)) {
                return reservation;
            }
        }
        return null;
    }

    public int checkSelectedDay(int day) {
        int count = 0;
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                if (day >= reservation.getCheckInDate() && day <= reservation.getCheckOutDate()) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    public boolean hasReservation() {
        for (Room room : this.roomList) {
            if (room.isReserved()) {
                return true;
            }
        }
        return false;
    }

}




