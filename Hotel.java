import java.util.ArrayList;
import java.util.Scanner;


public class HotelSystem {

    private ArrayList<Hotel> hotelList;

    /*
     * Initialize arraylist for hotels
     */
    public HotelSystem() {
        hotelList = new ArrayList<>();
    }

    public ArrayList<Hotel> getHotelList() {
        return hotelList;
    }

    /*
     * When it is constructed it should have a minimum of one room, the checking of other same names
     * @hotel
     */
    public void constructHotel(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println("Hotel with name '" + hotelName + "' already exists!");
                return;
            }
        }

        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        newHotel.addInitialRoom(1);        // Adds 1 room when creating a hotel
    }

    public void changeHotelName(Hotel selectedHotel) {  // The user is asked in main what hotel to change already print the list there
        Scanner scanner = new Scanner(System.in);
        String newName;

        do {
            System.out.println("Enter new hotel name: ");
            newName = scanner.next();

            if (selectedHotel.getHotelName().equals(newName)) // If equal to previous name
                System.out.println("Hotel with name '" + newName + "' already exists!");
            else
                for (Hotel h : hotelList)                      // Compares to other hotels
                {
                    if (h.getHotelName().equals(newName)) {
                        System.out.println("Hotel with name '" + newName + "' already exists!");
                        newName = null;
                    }
                }
        } while (newName == null);

        if (selectedHotel.confirmAction())
        {
            selectedHotel.setHotelName(newName);
            System.out.println("\nHotel name has been changed to '" + newName + "'!\n");
        }
    }

    public Hotel selectHotel() {
        Scanner scanner = new Scanner(System.in);
        int choice, i;
        Hotel selectedHotel = null;

        // List of hotels
        do {
            System.out.println("\nChoose a Hotel: ");
            for (i = 0; i < hotelList.size(); i++)
                System.out.println("[" + (i + 1) + "] " + hotelList.get(i).getHotelName());

            System.out.println("Choose a number from the List: ");
            choice = scanner.nextInt();

            if (choice >= 1 && choice <= hotelList.size())
                selectedHotel = hotelList.get(choice - 1);
            else
                System.out.println("Invalid choice!"); // selectedHotel stays null

        } while (selectedHotel == null);

        return selectedHotel;
    }

    public void viewHotel() {
        Scanner scanner = new Scanner(System.in);
        int choice, choice2, date;
        Hotel selectedHotel = selectHotel();

        do {
            System.out.println("""
                                       \s
                    ---HOTEL VIEWER---

                    [1] High-Level Information
                    [2] Low-Level Information
                    [0] Exit to menu
                   \s""");

            System.out.println("Choose a number: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // HIGH-LEVEL
                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    System.out.println("\n!!!!HIGH-LEVEL INFORMATION!!!!\n");
                    System.out.println("Name of the Hotel: " + selectedHotel.getHotelName());
                    System.out.println("\nTotal No. of Rooms for Hotel -- " + selectedHotel.getHotelName() + " is " + selectedHotel.getNumberOfRooms());
                    System.out.println("\nTotal Estimated Revenue for the Month: " + selectedHotel.calculateEstimatedEarnings());
                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                    break;
                case 2:
                    // LOW-LEVEL
                    do {
                        System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
                        System.out.println("\n####LOW-LEVEL INFORMATION####\n");
                        System.out.println("""
                                ---HOTEL VIEWER---

                                [1] Availability Checker (Day)
                                [2] Room Viewer
                                [3] Reservation Viewer
                                [0] Exit to menu
                                """);
                        System.out.println("Choose a number: ");
                        choice2 = scanner.nextInt();
                        switch (choice2) {
                            case 1: //I. Total number of available and booked rooms for a selected date
                                do {
                                    System.out.println("\nEnter a given date: (1-31)");
                                    date = scanner.nextInt();
                                } while (date < 0 || date > 31);
                                System.out.println("Total number of BOOKED rooms for Day#" + date + ": " + selectedHotel.checkSelectedDay(date));
                                System.out.println("\nTotal number of AVAILABLE rooms for Day#" + date + ": " + (selectedHotel.getTotalReservations() - selectedHotel.checkSelectedDay(date)));
                                break;

                            case 2: // II. Info about selected 'room', room's name, price, and availability (print days)
                                Room selectedRoom = selectedHotel.selectRoom();

                                if (selectedRoom != null) {
                                    System.out.println("\nRoom Name: " + selectedRoom.getRoomName());
                                    System.out.println("\nRoom Price: " + selectedRoom.getBasePrice() + " Per Night.");
                                    System.out.println("\nRoom Availability Calendar: ");
                                    selectedRoom.displayCalendar();
                                    System.out.println("\n\n1 - isReserved, 2 - isCheckInDate, 3 - isCheckOutDate, 4 - isOverlap, 0 isNotReserved");
                                } else
                                    System.out.println("\nRoom not found! Please input a proper value.");
                                break;

                            case 3: // Select a reservation among all the rooms and then show their info

                                if (!selectedHotel.hasReservation()){
                                    System.out.println("\nNo reservations found!");
                                    break;
                                } // Exits out if there are no reservation

                                Reservation selectedReservation = selectedHotel.selectReservation();

                                if (selectedReservation != null) {
                                    System.out.println("\nGuest Name: " + selectedReservation.getGuestName());
                                    System.out.println("\nCheck-In Date: " + selectedReservation.getCheckInDate());
                                    System.out.println("\nCheck-Out Date: " + selectedReservation.getCheckOutDate());
                                    System.out.println("\nRoom Name: " + selectedReservation.getRoom().getRoomName());
                                    System.out.println(selectedReservation.getPriceBreakdown());
                                } else
                                    System.out.println("\nReservation not found! Please input a proper Guest Name.");
                                break;
                            case 0: // Exit to go back to main loop
                                System.out.println("\nExiting Low-Level Information Viewer...");
                                break;

                            default:
                                System.out.println("\nInvalid choice!");
                                break;
                        }
                    } while (choice2 != 0);
                    break;

                case 0:
                    // EXIT
                    System.out.println("\nExiting Hotel Viewer...\n");
                    break;

                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        } while (choice != 0);
    }

    /*
    Pretty much done with this one
    */
    public void manageHotel() {
        Scanner scanner = new Scanner(System.in);
        int choice, numberOfRooms;
        boolean result, exit = true;
        Hotel selectedHotel = selectHotel();

        do {
            System.out.println("\nCurrent Hotel: " + selectedHotel.getHotelName());
            System.out.println("""
                                   \s
                    ---HOTEL MANAGER---

                    [1] Change Name of Hotel
                    [2] Add Room(s)
                    [3] Remove Room
                    [4] Update Room Base Price
                    [5] Remove Reservation
                    [6] Demolish Hotel
                    [0] Exit to menu
                   \s""");

            System.out.println("Choose a number: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1: // Change name of hotel
                    changeHotelName(selectedHotel);
                    break;

                case 2: // Add Room
                    do {
                        System.out.println("\nHow many Rooms do you want to add: ");
                        numberOfRooms = scanner.nextInt();
                        result = selectedHotel.addRoom(numberOfRooms);
                    } while (!result);
                    break;

                case 3: // Remove room
                    selectedHotel.removeRoom();
                    break;

                case 4: // Update base price of room (check conditions)
                    selectedHotel.updateRoomPrice();
                    break;

                case 5: // Remove reservation
                    selectedHotel.cancelReservation();
                    break;

                case 6: // Demolish hotel
                    if (selectedHotel.demolishHotel()) {
                        hotelList.remove(selectedHotel);
                        exit = false;
                    }
                    break;

                case 0:
                    // EXIT
                    System.out.println("\nExiting Hotel Manager...\n");
                    exit = false;
                    break;

                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        } while (exit);
    }

    public void simulateBooking() {
        Scanner scanner = new Scanner(System.in);
        Hotel selectedHotel = selectHotel();

        selectedHotel.addReservation();
    }

}
