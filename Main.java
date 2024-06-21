import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		HotelSystem hotel = new HotelSystem();
		Scanner scanner = new Scanner(System.in);
		boolean exitPS = true, exitMS = true; //PS = Program switch, MS = Menu Switch
		
		do{
			System.out.println("\n---HOTEL RESERVATION SYSTEM---\n\n" 
							  +"[1] Create Hotel\n"
							  +"[2] View Hotel\n"
							  +"[3] Manage Hotel\n"
							  +"[4] Simulate Booking\n"
							  +"[0] Exit Program\n");
						  
			System.out.print("Choose a number: ");
			int mainOptions = scanner.nextInt();
			switch(mainOptions){
				case "1":
					do{// Create Hotel Menu
						System.out.println("\n---HOTEL CREATION MENU---\n\n" 
										  +"Type Hotel Name: ");
						String hotelName = scanner.nextLine();
						boolean validHotelName = hotel.constructHotel(hotelName);
						if(validHotelName)
							exitMS = false;
						// Erase the previous text and re-run creation
					}while(exitMS);
					break;
				case "2":
						// View Hotel Menu
						viewHotel();
					}while(exitMS);
					break;
				case "3":
						// Manage Hotel Menu
						manageHotel();
					break;
				case "4":
					do{// Booking Menu
					
					}while(exitMS);
					break;
				case "0":
					System.out.println("Program will be closing...");
					exitPS = false;// Exits the program
					break;
				default:
					System.out.println("Invalid input");
					break;
			}
		}while(exitPS);
		
	}

}