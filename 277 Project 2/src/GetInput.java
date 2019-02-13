import java.util.Scanner;

public class GetInput {
	public static int getInt ( ) {
		Scanner in = new Scanner ( System.in );
		while ( ! in.hasNextInt ( ) ) {
			in.next ( );
			System.out.print ( "Enter an integer: " );
		}
		return in.nextInt ( );
	}
	
	public static int getIntRange ( int low, int high ) {
		Scanner in = new Scanner ( System.in );
		int input = 0;
		boolean valid = false;
		while ( ! valid ) {
			if ( in.hasNextInt ( ) ) {
				input = in.nextInt ( );
				if ( input >= low && input <= high ) {
					return input;
				} else {
					System.out.print ( "Enter a valid choice: " );
				}
			} else {
				in.next ( );
				System.out.print ( "Enter an integer: " );
			}
		}
		return input;
	}
	
	public static String getString ( ) {
		Scanner in = new Scanner ( System.in );
		return in.nextLine ( );
	}
}