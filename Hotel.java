import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class has the details of the hotel and handles the rooms and reservations of the hotel. 
 * The Hotel class contains details such as hotel ID, hotel name, room list, room number, and total earnings.
 */  
public class Hotel {

    private final int hotelID;
    private String hotelName;
    private ArrayList<Room> roomList;
    private int roomNumber;
    private double totalEarnings;

    /**
     * Constructs a hotel and initializes a room and its total earnings.
     * @param hotelName the name of the hotel.
     * @param hotelID the id of the hotel.
     */  
    public Hotel(String hotelName, int hotelID) {
        this.hotelName = hotelName;
        this.hotelID = hotelID;
        roomList = new ArrayList<>();
        this.roomNumber = 1;                // When we create hotel, room number would be 1
        this.totalEarnings = 0;
    }

    /**
     * Sets the name of the hotel.
     * @param hotelName name of the hotel.
     */ 
    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    /**
     * Gets the name of the hotel.
     * @return the hotel's name.
     */ 
    public String getHotelName() {
        return hotelName;
    }

    /**
     * Gets the list of rooms of the hotel.
     * @return the list of rooms.
     */ 
    public ArrayList<Room> getRoomList() { // NEW NAME
        return roomList;
    }

    /**
     * Gets the number of rooms of the hotel.
     * @return the number of rooms.
     */ 
    public int getNumberOfRooms() {
        return roomList.size();
    }

    /**
     * Gets the total number of reservations of the hotel.
     * @return the total number of reservations.
     */ 
    public int getTotalReservations() // new
    {
        int totalReservations = 0;
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                totalReservations++;
            }
        }
        return totalReservations;
    }

    /**
     * A menu that allows the user to choose what reservation to cancel.
     * @return the selected reservation to be cancelled.
     */ 
    public Reservation selectReservation() { // new
        Scanner scanner = new Scanner(System.in);
        int choice, i, j;
        Reservation selectedReservation = null;

        // List of Reservations on all rooms for cancelling
        do {
            System.out.println("\nChoose a Reservation: "); // Just to show the options iterates through roomList and reservationList
            j = 1;
            for (i = 0; i < this.roomList.size(); i++)
                for (Reservation reservation : this.roomList.get(i).getReservations()) {
                    System.out.println("[" + j + "] Guest Name: " + reservation.getGuestName());
                    j++;
                }

            System.out.println("Choose a number from the List: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= j - 1) { // For the logic of getting the reservation
                j = 1; // Reset counter
                for (i = 0; i < this.roomList.size(); i++) {
                    for (Reservation reservation : this.roomList.get(i).getReservations()) {
                        if (j == choice) {
                            selectedReservation = reservation;
                            break;
                        }
                        j++;
                    }
                }
            } else
                System.out.println("Invalid choice!");

        } while (selectedReservation == null);

        return selectedReservation;
    }

    /**
     * Confirms if the hotel will be demolished.
     * @return a true if the hotel got demolished, false otherwise.
     */  
    public boolean demolishHotel() { // new

        if (confirmAction()) {
            System.out.println("\nHotel '" + this.getHotelName() + "' has been demolished!");
            return true;
        } else {
            System.out.println("\nHotel '" + this.getHotelName() + "' has not been demolished.");
            return false;
        }
    }

    /**
     * Asks the user to select a room in the hotel.
     * @return the room selected by the user.
     */  
    public Room selectRoom() { // new
        Scanner scanner = new Scanner(System.in);
        int choice, i;
        Room selectedRoom = null;

        System.out.println("Select a room:");
        for (i = 0; i < this.roomList.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + this.roomList.get(i).getRoomName());
        }

        System.out.println("Enter the number of the room you want to select: ");
        choice = scanner.nextInt();

        if (choice >= 1 && choice <= this.roomList.size()) {
            selectedRoom = this.roomList.get(choice - 1);
        } else {
            System.out.println("Invalid room selection.");
        }

        return selectedRoom;
    }

    /**
     * Adds the initial room for the hotel.
     * @param numberOfRooms the number of rooms in the hotel.
     */  
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

    /**
     * Adds rooms to the hotel with unique naming convention.
     * @param numberOfRooms the number of rooms to be added.
     * @return a true if rooms were added, false otherwise.
     */
    public boolean addRoom(int numberOfRooms) {
        int i;
        String roomName;

        if ((numberOfRooms + this.roomList.size()) > 50) { // If the number of rooms we want to add exceeds 50, don't add
            System.out.println("Cannot add more than 50 rooms");
            return false;
        }

        if (confirmAction()) {
            for (i = 0; i < numberOfRooms; i++) {
                roomName = this.hotelID + String.format("%03d", this.roomNumber++); // So parang 1 (first hotel) then catenate 01, 02, 03, etc.
                this.roomList.add(new Room(roomName));
            }
        } else
            return true; // The case where the user inputs N to end the loop in System

        System.out.println("Room(s) successfully added.\n");
        return true;
    }

    /**
     * Removes a room only if it does not have an active reservation and if it is not the last room.
     */
    public void removeRoom() {
        if (this.roomList.size() == 1) {
            System.out.println("\nCannot remove last room.");
            return;
        }

        Room selectedRoom = selectRoom();

        if (selectedRoom == null) {
            System.out.println("\nRoom not found! Please input a proper value.");
            return;
        }

        if (selectedRoom.isReserved()) {
            System.out.println("\nCannot remove room that is Reserved/Reserved.\n");
        } else {
            if (confirmAction()) {
                this.roomList.remove(selectedRoom);
                System.out.println("\nRoom is successfully removed.\n");
            } else
                System.out.println("\nYou cancelled the modification.\n");
        }
    }

    /**
     * Updates the pricing of the rooms only if there is no reservations and the new price is >= 100.0.
     */
    public void updateRoomPrice() {
        Scanner scanner = new Scanner(System.in);
        double price = 0.0;
        boolean valid = false;
        int i;


        if (this.hasReservation()) {
            System.out.println("\nCannot update price there is a Reserved room. Remove the reservation first.\n");
            return;
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

        if (confirmAction()) {
            for (i = 0; i < this.roomList.size(); i++)
                this.roomList.get(i).setBasePrice(price);  // Sets all rooms to specified price
            System.out.println("\n All rooms have been set to " + price + " per night.\n");
        } else
            System.out.println("\nYou cancelled the modification.\n");
    }

    /**
     * A menu for cancelling/removing a reservation.
     */ 
    public void cancelReservation() {

        //if null condition
        if (!this.hasReservation())
            System.out.println("\nThere is no reservation to cancel.\n");
        else {
            Reservation selectedReservation = this.selectReservation();
            Room room = selectedReservation.getRoom(); // Linked room from the reservation

            if (confirmAction()) {
                room.setReservationList(0, selectedReservation.getCheckInDate(), selectedReservation.getCheckOutDate());
                room.getReservations().remove(selectedReservation);
                this.totalEarnings -= selectedReservation.getTotalPrice();
                room.resetReservation(); // For resetting purposes, if there are no reservation
                System.out.println("Successfully removed the reservation by" + selectedReservation.getGuestName());
            } else
                System.out.println("\nYou cancelled the modification.\n");
        }
    }

    /**
     * Calculates the earnings of the hotel.
     * @return the total earnings.
     */
    public double calculateEstimatedEarnings() {   // based on reservation ITERATE THROUGH ALL ROOMS
        double totalEarnings = 0.0;
        for (Room room : this.roomList) {
            for (Reservation reservation : room.getReservations()) {
                totalEarnings += reservation.getTotalPrice();
            }
        }
        return totalEarnings;
    }

    /**
     * Asks the user for their name, check in date, check out date.
     * It checks if these details are valid, if valid it adds the reservation.
     */    
    public void addReservation() {
        Scanner scanner = new Scanner(System.in);

        String guestName;
        int checkInDate, checkOutDate;
        boolean flag = false, validDates = false;

        System.out.println("Enter guest name: ");
        guestName = scanner.next();

        do {
            System.out.println("Enter check in date: (1-30) "); // make do while conditions for these and fix the overlap
            checkInDate = scanner.nextInt();

            System.out.println("Enter check-out date: (2-31)");
            checkOutDate = scanner.nextInt();

            if (checkInDate >= 1 && checkOutDate > 1 && checkOutDate <= 31 && checkInDate <= checkOutDate)
                validDates = true;
            else
                System.out.println("\nInvalid dates. Please input a proper value within the boundary and make sure the check-in date must be before the check-out date. \n");
        } while (!validDates);


        Room selectedRoom = this.selectRoom();

        if (selectedRoom != null) {
            Reservation newReservation = new Reservation(guestName, checkInDate, checkOutDate, selectedRoom);
            flag = newReservation.checkReservation(checkInDate, checkOutDate); //Check first

            if (flag) {
                selectedRoom.getReservations().add(newReservation);                 // Adds reservation to reservationList
                selectedRoom.setReservationList(1, checkInDate, checkOutDate); // Puts days reserved in the calendar
                selectedRoom.setReserved(true); // Sets room to 'reserved' or 'true' for isReserved
                System.out.println("\nReservation is successfully added.\n");
            } else
                System.out.println("\nRoom is already reserved on the selected dates.\n");
            return;
        }
        System.out.println("\nRoom not found! Please input a proper value.\n");
    }

    /**
     * Checks the number of rooms that have been reserved on a selected date
     * @param day the selected date to check.
     * @return the number of rooms reserved.
     */
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

    /**
     * A method that confirms any action that the user is trying to take.
     * @return confirm case Y.
     */    
    public boolean confirmAction() {
        Scanner scanner = new Scanner(System.in);
        String confirm;

        do {
            System.out.println("\nAre you sure you want to continue with this modification? (Y/N) ");
            confirm = scanner.next();
        } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

        return confirm.equalsIgnoreCase("Y");
    }

    /**
     * Checks the rooms if there are reservations.
     * @return a true if there are reserved rooms.
     */  
    public boolean hasReservation() { // new
        for (Room room : this.roomList) {
            if (room.isReserved()) {
                return true;
            }
        }
        return false;
    }
}
