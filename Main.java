import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		HotelSystem hotel = new HotelSystem();
		Scanner scanner = new Scanner(System.in);
		boolean exitPS = true, exitMS = true; //PS = Program switch, MS = Menu Switch
		
		do{
			System.out.println("\nHOTEL RESERVATION SYSTEM\n\n" 
						  +"1. Create Hotel\n"
						  +"2. View Hotel\n"
						  +"3. Manage Hotel\n"
						  +"4. Simulate Booking\n"
						  +"0. Exit\n");
						  
			System.out.print("Choose a number: ");
			int choice = scanner.nextInt();
			switch(){
				case "1":
					do{// Create Hotel Menu
					}while();
					break;
				case "2":
					do{// View Hotel Menu
					}while();
					break;
				case "3":
					do{// Manage Hotel Menu
					}while();
					break;
				case "4":
					do{// Booking Menu
					}while();
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