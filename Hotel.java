import java.awt.desktop.SystemEventListener;
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

    public ArrayList<Room> getRoomList() { // NEW NAME
        return roomList;
    }

    public int getNumberOfRooms() {
        return roomList.size();
    }

    //NEW
    public Room getRoom(String roomNumber) {
        for (Room room : this.roomList) {
            if (room.getRoomName().equals(roomNumber)) {
                return room;
            }
        }
        return null;
    }

    public void addInitialRoom(int numberOfRooms) { // new
        int i;
        String roomName;

        if ((numberOfRooms + this.roomList.size()) > 50) { // If the number of rooms we want to add exceeds 50, don't add
            System.out.println("Cannot add more than 50 rooms");
            return;
        }

        for (i = 0; i < numberOfRooms; i++) {
            roomName = this.hotelID + String.format("%03d", this.roomNumber++); // So parang 1 (first hotel) then catenate 01, 02, 03, etc.
            this.roomList.add(new Room(roomName));
        }

        System.out.println("\n1 Room successfully added. Congrats on creating your Hotel!\n");
    }
    /*
     * unique naming convention
     * @room
     */
    public boolean addRoom(int numberOfRooms) {
        Scanner scanner = new Scanner(System.in);
        int i;
        String roomName, confirm;

        if ((numberOfRooms + this.roomList.size()) > 50) { // If the number of rooms we want to add exceeds 50, don't add
            System.out.println("Cannot add more than 50 rooms");
            return false;
        }

        do {
            System.out.println("\nAre you sure you want to continue with this modification? (Y/N) ");
            confirm = scanner.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        if (confirm.equalsIgnoreCase("Y")) {
            for (i = 0; i < numberOfRooms; i++) {
                roomName = this.hotelID + String.format("%03d", this.roomNumber++); // So parang 1 (first hotel) then catenate 01, 02, 03, etc.
                this.roomList.add(new Room(roomName));
            }
        } else
            return true; // The case where the user inputs N to end the loop in System

        System.out.println("\nRoom(s) successfully added.\n");
        return true;
    }

    /*
     * can only be removed if it does not have a active reservation.
     * @room
     */
    public void removeRoom() {
        Scanner scanner = new Scanner(System.in);
        int i;
        String roomName, confirm;

        System.out.println("List of rooms: \n");  // CAN BE REMOVED just for checking
        for (Room room : this.roomList) {
            System.out.println(room.getRoomName() + "\n");
        }

        System.out.println("\nEnter room name: ");
        roomName = scanner.nextLine();

        for (i = 0; i < this.roomList.size(); i++) {
            if (this.roomList.get(i).getRoomName().equals(roomName)) {
                if (this.roomList.get(i).isReserved())
                    System.out.println("\nCannot remove room that is Reserved/Reserved.\n");
                else {
                    do {
                        System.out.println("\n\nAre you sure you want to continue with this modification? (Y/N) ");
                        confirm = scanner.nextLine();
                    } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

                    if (confirm.equalsIgnoreCase("Y")) {
                        this.roomList.remove(i);
                        System.out.println("\nRoom is successfully removed.\n");
                    } else
                        System.out.println("\nYou cancelled the modification.\n");
                }
            } else
                System.out.println("\nRoom does not exist.\n");
        }
    }

    /*
     * can only update if all rooms are false (none are Reserved) and price must be >= 100.0
     * @room
     */
    public void updateRoomPrice() {
        Scanner scanner = new Scanner(System.in);
        double price = 0.0;
        boolean valid = false;
        String confirm;
        int i;

        for (i = 0; i < this.roomList.size(); i++) {
            if (this.roomList.get(i).isReserved()) {
                System.out.println("\nCannot update price there is a Reserved room. Remove the reservation first.\n");
                return;
            }
        }

        System.out.println("\nNo rooms are Reserved. You can update the price.\n");
        while (!valid) {
            System.out.println("Enter new price: ");
            price = scanner.nextDouble();

            if (price >= 100.0)
                valid = true;
            else
                System.out.println("\nPrice must be more than 100. Input a new value!\n");
        }

        do {
            System.out.println("\n\nAre you sure you want to continue with this modification? (Y/N) ");
            confirm = scanner.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        if (confirm.equalsIgnoreCase("Y")) {
            for (i = 0; i < this.roomList.size(); i++)
                this.roomList.get(i).setBasePrice(price);  // Sets all rooms to specified price
            System.out.println("\n All rooms have been set to" + price + " per night.\n");
        } else
            System.out.println("\nYou cancelled the modification.\n");
    }

    public void cancelReservation() {
        Scanner scanner = new Scanner(System.in);
        String guestName, confirm;

        System.out.println("Enter guest name: ");
        guestName = scanner.nextLine();

        do {
            System.out.println("\n\nAre you sure you want to continue with this modification? (Y/N) ");
            confirm = scanner.nextLine();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        if (confirm.equalsIgnoreCase("Y")) {
            for (Room room : this.roomList) {
                for (Reservation reservation : room.getReservations()) {
                    if (reservation.getGuestName().equals(guestName)) {
                        room.setReservationList(0, reservation.getCheckInDate(), reservation.getCheckOutDate());
                        room.getReservations().remove(reservation);
                        room.resetReservation(); // For resetting purposes, if there are no reservation
                        System.out.println("Successfully removed the reservation by " + guestName);
                        return;
                    }
                }
            }
        } else
            System.out.println("\nYou cancelled the modification.\n");
    }

    /*
     * when it is successful setReserved(true)
     * @reservation
     */
    public double calculateEstimatedEarnings() {   // based on reservation ITERATE THROUGH ALL ROOMS
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                totalEarnings += reservation.getTotalPrice();
            }
        }
        return totalEarnings;
    }


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

        for (Room r : this.getRoomList()) {
            if (r.getRoomName().equals(roomName))
                room = r;
        }

        if (room != null) {
            Reservation newReservation = new Reservation(guestName, checkInDate, checkOutDate, room);
            flag = newReservation.checkReservation(checkInDate, checkOutDate); //Check first

            if (flag) {
                room.getReservations().add(newReservation);                 // Adds reservation to reservationList
                room.setReservationList(1, checkInDate, checkOutDate); // Puts days reserved in the calendar
                room.setReserved(true); // Sets room to 'reserved' or 'true' for isReserved
                return true;
            } else
                return false;
        }

        System.out.println("\nInvalid date!");
        return false;
    }

    // NEW -- Checks and returns the number of rooms that have been reserved on a selected date
    public int checkSelectedDay(int day) {
        int count = 0;
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                if (day >= reservation.getCheckInDate() && day <= reservation.getCheckOutDate()) {
                    count++;
                }
            }
        }
        return count;
    }


}
