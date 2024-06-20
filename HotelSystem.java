import java.util.ArrayList;
import java.util.Scanner;

class HotelSystem {

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
    public boolean constructHotel(String hotelName) {
        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                System.out.println("Hotel with name '" + hotelName + "' already exists!");
                return false;
            }
        }

        Hotel newHotel = new Hotel(hotelName, hotelList.size() + 1);
        hotelList.add(newHotel);
        newHotel.addRoom(1);        // Adds 1 room when creating a hotel
        return true;
    }

    public void demolishHotel() {
        Scanner scanner = new Scanner(System.in);
        String hotelName, confirm;

        System.out.println("Enter hotel name: ");
        hotelName = scanner.nextLine();


        for (Hotel hotel : hotelList) {
            if (hotel.getHotelName().equals(hotelName)) {
                do {
                    System.out.println("\n\nAre you sure you want to continue with this modification? (Y/N) ");
                    confirm = scanner.nextLine();
                } while (!confirm.equalsIgnoreCase("Y") && !confirm.equalsIgnoreCase("N"));

                if (confirm.equalsIgnoreCase("Y")) {
                    hotelList.remove(hotel);
                    System.out.println("\nHotel with name '" + hotelName + "' has been demolished!\n");
                }
            }
        }
        System.out.println("\nHotel with name '" + hotelName + "' has not been demolished.\n");
    }

    public void changeHotelName(Hotel selectedHotel) {  // The user is asked in main what hotel to change already print the list there
        Scanner scanner = new Scanner(System.in);
        String newName;

        do {
            System.out.println("Enter new hotel name: ");
            newName = scanner.nextLine();

            if (selectedHotel.getHotelName().equals(newName)) // If equal to previous name
                System.out.println("Hotel with name '" + newName + "' already exists!");
            else
                for (Hotel h : hotelList)                      // Compares to other hotels
                {
                    if (selectedHotel.getHotelName().equals(newName)) {
                        System.out.println("Hotel with name '" + newName + "' already exists!");
                        newName = null;
                    }
                }
        } while (newName == null);


        selectedHotel.setHotelName(newName);
        System.out.println("\nHotel name has been changed to '" + newName + "'!\n");
    }

    public Hotel selectHotel() {
        Scanner scanner = new Scanner(System.in);
        int choice, i;
        Hotel selectedHotel = null;

        // List of hotels
        do {
            System.out.println("\n Choose a hotel: ");
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
        int choice;
        Hotel selectedHotel = selectHotel();

        do {
            System.out.println("""
                    ---HOTEL VIEWER---

                    [1] High-Level Information
                    [2] Low-Level Information
                    [0] Exit to menu
                    """);

            System.out.println("Choose a number: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    // HIGH-LEVEL
                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
                    System.out.println("\n!!!!HIGH-LEVEL INFORMATION!!!!\n");
                    System.out.println("Name of the Hotel: " + selectedHotel.getHotelName());
                    System.out.println("\nTotal No. of Rooms for hotel" + selectedHotel.getHotelName() + " is " + selectedHotel.getNumberOfRooms());
                    System.out.println("\nTotal Estimated Revenue for the Month: " + selectedHotel.calculateEstimatedEarnings());
                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
                    break;
                case 2:
                    // LOW-LEVEL
                /*
                    I. Total number of available and booked rooms for a selected date (might need to make a function -- input a given start and end day to check and return if available)
                    II. Info about selected 'room', room's name, price, and availability (print days)
                    III. Info about selected reservation, guest info, room info, check in and out dates, total price of booking, and breakdown
                 */
                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
                    System.out.println("\n####LOW-LEVEL INFORMATION####\n");

                    System.out.println("\n+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
                    break;
                case 0:
                    // EXIT
                    System.out.println("\nExiting Hotel Viewer...\n");
                    break;

                default:
                    System.out.println("\nInvalid choice!\n");
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
        boolean result;
        Hotel selectedHotel = selectHotel();

        do {
            System.out.println("\nCurrent Hotel: " + selectedHotel.getHotelName() + "\n");
            System.out.println("""
                    ---HOTEL MANAGER---

                    [1] Change Name of Hotel
                    [2] Add Room
                    [3] Update Room's Base Price
                    [4] Remove Reservation
                    [5] Demolish Hotel
                    [0] Exit to menu
                    """);

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
                    demolishHotel();
                    break;
                case 0:
                    // EXIT
                    System.out.println("\nExiting Hotel Manager...\n");
                    break;

                default:
                    System.out.println("\nInvalid choice!\n");
                    break;
            }
        } while (choice != 0);
    }

    public void simulateBooking(Hotel hotel) {

        // Should be able to select a hotel and specify check in and check out dates
        // Mechanism to select room (manual from list)
        // Once a reservation is made, status of room should be updated and reservation details should be stored and viewable in viewhotel

    }


}
