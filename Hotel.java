import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has the details of the hotel and handles the rooms and reservations of the hotel.
 * The Hotel class contains details such as hotel ID, hotel name, room list, room number, total earnings, and total reservations in the hotel.
 */
public class Hotel {

    private final int hotelID;
    private final ArrayList<Room> roomList;
    private String hotelName;
    private int roomNumber;
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

    public int getHotelID() {
        return this.hotelID;
    }

    public String getHotelName() {
        return this.hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public int getNumberOfRooms() {
        return roomList.size();
    }

    public void addInitialRoom() {
        String roomName;

        roomName = "S" + this.hotelID + String.format("%03d", this.roomNumber++);
        this.roomList.add(new Room(roomName));
        // Print in actionEvent for validation
    }

    // combobox pick room
    // textbox number of rooms
    // finish then run method

    public void addRoom(int numberOfRooms, String roomType) {
        int i;
        String roomName;

        if ((numberOfRooms + getNumberOfRooms()) > 50)
            throw new IllegalArgumentException("Maximum number of rooms reached. Hotel can only accommodate 50 rooms.");
        if (roomType.equals("Hold"))
            return;

        // Confirm action before proceeding
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
        // Print in actionEvent for validation
    }

    // textbox numberofrooms

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

    public void updateRoomPrice(double basePrice) {
        if (this.hasReservation()) {
            System.out.println("Cannot update room prices while reservations are made.");
            return;
        }

        if (basePrice < 100) {
            System.out.println("Base price should be at least 100.");
            return;
        }

        System.out.println("\nNo rooms are Reserved. You can update the price.");

        // Repeat for validity in the controller?


    }

    public void addReservation() {

    }

    // pass list of reservation for combobox
    // confirmation

    public void cancelReservation() {

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


//cant have check in and check out on same day


// roomnumber ++ when rooms are added
// roomnumber -- when rooms are removed

}




