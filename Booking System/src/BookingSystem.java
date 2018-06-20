//This  imports the Java Packages Necessary.
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BookingSystem {

	static Seats_Page Seats[];
	static int choiceentry;

	// Main Method
	public static void main(String[] args) throws IOException {
		
		// Final scanner introduced to the console
		final Scanner CONSOLE = new Scanner(System.in);
		final String SEATS = "seating.txt";// String

		Seats = new Seats_Page[43]; //
		Scanner input;
		input = new Scanner(new FileReader(SEATS)); // Scanner used to read the file
		int index = 0;

		while (input.hasNext()) {
			int num = input.nextInt();
			String type = input.next();
			String window = input.next();
			String direction = input.next();
			boolean table = input.nextBoolean();
			boolean access = input.nextBoolean();

			Seats[index] = new Seats_Page(num, type, window, direction, table,
					access);
			index++;
		}
		do {

			// Menu Options
			System.out.println("| Main Menu:");
			System.out.println("| 1.) Reserve A Seat");
			System.out.println("| 2.) Cancel A Seat!");
			System.out.println("| 3.) View Seat Reservations");
			System.out.println("| 4.) View Waiting List");
			System.out.println("| 5.) Exit!");

			choiceentry = -1;

			// Limits the menu to have 5 Menu Options.
			while (choiceentry < 1 || choiceentry > 5) {

				// Take User Input
				if (CONSOLE.hasNextInt())
					choiceentry = CONSOLE.nextInt();

				// Each Case Represents a Menu Options
			}

			switch (choiceentry) {

			// Reserve a Seat.
			case 1:
				Scanner mail = new Scanner(System.in);
				System.out.println("Please enter your email address.");

				// Takes the Users Email and puts in into a String called "Email."
				String email;
				email = mail.nextLine();
				System.out.println("You have entered " + email);
				
				// Asks the user for the criteria of the seat.
				System.out.println("Enter 1 for First Class, Enter 2 For Second Class");
				String classtype = CONSOLE.next();
				System.out.println("Enter 'window' or 'aisle'");
				String windoworaisle = CONSOLE.next();
				System.out.println("Please enter 'forward' or 'backward' for your seat position");
				String forwardorbackward = CONSOLE.next();
				System.out.println("Enter true for 'with table' or false for 'without table'");
				boolean tableorwithout = CONSOLE.nextBoolean();
				System.out.println("Enter true for 'ease of access seat' or false for 'normal seat'");
				boolean easeofaccess = CONSOLE.nextBoolean();
				System.out.println("\n");
				
				//Match the seat and print the seat number.

				for (Seats_Page seat : Seats) {
					if (!seat.isReserved()
							&& seat.match(classtype, windoworaisle,
									forwardorbackward, tableorwithout,
									easeofaccess)) {
						seat.setEmail(email);
						System.out.println("You have Reserved Seat "
								+ seat.getNum());
						System.out.println("\n");
						break;
					}
				}
				break;

			// Cancel A Seat.
			case 2:
				System.out.println("This Is To Cancel The Seat");
				String emailc = CONSOLE.next();
				for (Seats_Page seat : Seats) {
					if (emailc.equals(seat.getEmail())) {
						seat.setEmail("");
						System.out.println("You have Cancelled Seat "
								+ seat.getNum());
						break;
					}
				}
				break;
				
			// View Seat Reservations
			case 3:
				//Under construction
				break;

			// View Waiting List.
			case 4:
				try (BufferedReader br = new BufferedReader(new FileReader(
						"waitinglist.txt"))) {
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}
				}
				break;

			// Exit Program.
			case 5:
				System.out
						.println("You have chosen to quit the program.Goodbye!");
				CONSOLE.close();
				input.close();

				System.exit(0);
				break;

			default:
				System.out.println("Invalid selection.");
				break;
			}
		} while (choiceentry != -1);

	}
}
