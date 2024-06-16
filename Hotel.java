import java.util.ArrayList;
import java.util.Scanner;

class Hotel {

    private final int hotelID;
    private String hotelName;
    private ArrayList<Room> roomList;
    private int roomNumber;
    private double totalEarnings;

    public Hotel(String hotelName, int hotelID) {
        this.hotelName = hotelName;
        this.hotelID = hotelID;
        roomList = new ArrayList<>();
        this.roomNumber = 1;                // When we create hotel, room number would be 1
        this.totalEarnings = 0;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public ArrayList<Room> getRooms() {
        return roomList;
    }

    /*
     * unique naming convention
     * @room
     */
    public boolean addRoom(int numberOfRooms) {
        int i;

        if ((numberOfRooms + roomList.size()) > 50) { // If the number of rooms we want to add exceeds 50, don't add
            System.out.println("Cannot add more than 50 rooms");
            return false;
        }

        for (i = 0; i < numberOfRooms; i++) {
            String roomName = hotelID + String.format("%03d", roomNumber++); // So parang 1 (first hotel) then catenate 01, 02, 03, etc.
            roomList.add(new Room(roomName));
        }

        return true;
    }

    /*
     * can only be removed if it does not have a active reservation.
     * @room
     */
    public void removeRoom(String roomName) {
        int i;
        boolean result = false;

        for (i = 0; i < roomList.size(); i++)
            if (roomList.get(i).getRoomName().equals(roomName)) {
                if (roomList.get(i).isReserved())
                    System.out.println("Cannot remove room that is Reserved/Reserved.");
                else {
                    roomList.remove(i);
                    result = true;
                }
            }

        if (result)
            System.out.println("Room is successfully removed.");
        else
            System.out.println("Room does not exist.");
    }

    /*
     * can only update if all rooms are false (none are Reserved) and price must be >= 100.0
     * @room
     */
    public boolean updateRoomPrice() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        double price = 0.0;
        int i;

        for (i = 0; i < roomList.size(); i++) {
            if (roomList.get(i).isReserved()) {
                System.out.println("Cannot update price there is a Reserved room. Remove the reservation first.");
                return false;
            }
        }

        System.out.println("No rooms are Reserved. You can update the price.");

        while (!valid) {
            System.out.println("Enter new price: ");
            price = scanner.nextDouble();

            if (price >= 100.0)
                valid = true;
            else
                System.out.println("Price must be more than 100. Input a new value!");
        }

        for (i = 0; i < roomList.size(); i++)
            roomList.get(i).setBasePrice(price);  // Sets all rooms to specified price

        return true;
    }

    // Reserves the days that customers reserved. 1 isReserved, 2 isCheckInDate, 3 isCheckOutDate, 4 isOverlap
    // NEED CHANGES
    public boolean addReservation() {
        Scanner scanner = new Scanner(System.in);
        String guestName, roomName;
        int checkInDate, checkOutDate;
        Room room = null;
        boolean flag = false;

        System.out.println("Enter guest name: ");
        guestName = scanner.nextLine();

        System.out.println("Enter check in date: ");
        checkInDate = scanner.nextInt();

        System.out.println("Enter check-out date: ");
        checkOutDate = scanner.nextInt();

        System.out.println("Enter room name: (Please input exact name)");
        roomName = scanner.next();

        for (Room rHold : roomList)
        {
            if (rHold.getRoomName().equals(roomName))
                room = rHold;
        }

        if (room != null) {
            Reservation newReservation = new Reservation(guestName, checkInDate, checkOutDate, room);
            flag = newReservation.checkReservation(checkInDate, checkOutDate); //Check first

            if (flag) {
                room.getReservations().add(newReservation);                 // Adds reservation to reservationList
                room.setReservationList(1, checkInDate, checkOutDate); // Puts days reserved in the calendar
                room.setReserved(true);                                     // Sets room to 'reserved' or 'true' for isReserved
            } else
                return false;
        }
        return true; // Set nalang sa main the print statement that it is successful or not
    }

    // Need to do something about overlaps. Might need a method to check other reservations and make sure the dates are always reserved or reuse addReservation.
    public boolean cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        String guestName;

        System.out.println("Enter guest name: ");
        guestName = scanner.nextLine();

        for (Room room : roomList) {
            for (Reservation reservation : room.getReservations()) {
                if (reservation.getGuestName().equals(guestName)) {
                    room.getReservations().remove(reservation);
                    room.setReservationList(0, reservation.getCheckInDate(), reservation.getCheckOutDate());
                    return true;
                }
            }
        }
        return false;
    }

    /*
     * when it is successful setReserved(true)
     * @reservation
     */

    public double calculateEstimatedEarnings() {   // based on reservation ITERATE THROUGH ALL ROOMS
        double totalEarnings = 0;
        for (Room room : roomList) {
            for (Reservation reservation : room.getReservations()) {
                totalEarnings += reservation.getTotalPrice();
            }
        }
        return totalEarnings;
    }

}
