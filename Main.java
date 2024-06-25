/**
 * @author CARIAGA, Josh Enrico P., DELA CRUZ, Tremayne Hope O.
 * Section: S18
 * Last Modified: 25/06/2024
 * Acknowledgements:
 * W3Schools.com. (n.d.). https://www.w3schools.com/java/java_foreach_loop.asp
 * W3Schools.com. (n.d.). Java Iterator. https://www.w3schools.com/java/java_iterator.asp
 * W3Schools.com. (n.d.). Java ArrayLists. https://www.w3schools.com/java/java_arraylist.asp
 * StackOverflow. (n.d.). How to generate Javadoc from command line. Stack Overflow. https://stackoverflow.com/questions/4592396/how-to-generate-javadoc-from-command-line/
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        HotelSystem hotelSystem = new HotelSystem();
        String hotelName;
        Scanner scanner = new Scanner(System.in);
        boolean exitPS = true;

        do {
            System.out.println("""

                    ---HOTEL RESERVATION SYSTEM---

                    [1] Create Hotel
                    [2] View Hotel
                    [3] Manage Hotel
                    [4] Simulate Booking
                    [0] Exit Program
                    """);

            System.out.print("Choose a number: ");
            int mainOptions = scanner.nextInt();
            switch (mainOptions) {
                case 1:
                    // Create Hotel Menu
                    System.out.println("""
                            
                            ---HOTEL CREATION MENU---

                            Type Hotel Name:""");
                    hotelName = scanner.next();
                    hotelSystem.constructHotel(hotelName);
                    break;
                case 2:
                    // View Hotel Menu
                    if (hotelSystem.getHotelList().isEmpty())
                        System.out.println("\nNo Hotel has been created yet.");
                    else
                        hotelSystem.viewHotel();
                    break;
                case 3:
                    // Manage Hotel Menu
                    if (hotelSystem.getHotelList().isEmpty())
                        System.out.println("No Hotel has been created yet.");
                    else
                        hotelSystem.manageHotel();
                    break;

                case 4:
                    // Booking Menu
                    if (hotelSystem.getHotelList().isEmpty())
                        System.out.println("No Hotel has been created yet.");
                    else
                        hotelSystem.simulateBooking();
                    break;

                case 0:
                    System.out.println("Program will be closing...");
                    exitPS = false;// Exits the program
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        } while (exitPS);

    }
}