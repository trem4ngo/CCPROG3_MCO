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

    /*
     * when it is successful setReserved(true)
     * @reservation
     */
    public boolean addReservation(String guestName, int checkInDay, int checkOutDay, String roomName) {   // When a reservation is added room would be Reserved, set true
        // iterate through the index of reservation list 1-31 to see which days are reserved
        // check first if rooms are already reserved (Reserved)
        for (Room room : roomList) { // Iterate through the rooms


            //iterate through the rooms to check their reservationlist


        }
        // each room has 31 possible days to be reserved
    }

    public boolean removeReservation(String guestName) {

    }

    public double calculateEstimatedEarnings() {   // based on reservation ITERATE THROUGH ALL ROOMS
        for (Room room : roomList) {
            for (Reservation reservation : Room.getReservations()) {
                totalEarnings += reservation.getTotalPrice();
            }
        }
        return totalEarnings;
    }

}
