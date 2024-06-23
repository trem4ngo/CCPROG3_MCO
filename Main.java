import java.util.Scanner;

/**
 * This class calls all of the methods from other classes and organizes them into a menu.
 */    
public class Main {
    public static void main(String[] args) {

        HotelSystem hotelSystem = new HotelSystem();
        String hotelName;
        Scanner scanner = new Scanner(System.in);
        boolean exitPS = true, exitMS = true; //PS = Program switch, MS = Menu Switch

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
