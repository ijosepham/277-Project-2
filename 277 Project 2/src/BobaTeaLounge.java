import java.util.ArrayList;

public class BobaTeaLounge {
	public static void main ( String [ ] args ) {
		ArrayList < String > sales = new ArrayList < String > ( );
		CashRegister cashRegister  = new CashRegister ( );
		double grandTotal = 0;
		Object order = null;
		int menuChoice = 0;
		boolean done = false;
		
		while ( !done ) { // while day hasn't finished
			System.out.println ( "Welcome to Boba Tea Lounge! What may I get you?" + "\n" );
			menuChoice = getMain ( );
			while ( menuChoice != 3 ) {
				if ( menuChoice == 1 ) { // drink
					menuChoice = getDrink ( );
					if ( menuChoice == 1 ) { // tea
						order = orderTea ( );
					} else if ( menuChoice == 2 ) { // coffee
						order = orderCoffee ( );
					}
				} else { // dessert
					menuChoice = getDessert ( );
					if ( menuChoice == 1 ) { // pastry
						order = orderPastry ( );
					} else if ( menuChoice == 2 ) { // cookie
						order = orderCookie ( );
					} else { // mac
						order = orderMacaron ( );
					}
				}
				if ( confirmOrder ( order ) ) { // if user confirms that it's a correct order
					cashRegister.addOrder ( order );
				}
				System.out.println ( "Would you like anything else?" + "\n" );
				menuChoice = getMain ( ); // then asks if they want another item or to finsih up the sale
			}
			
			sales.add ( cashRegister.getSale ( ) ); // add sale to arraylist so at the end of day, prints out all sales
			grandTotal += cashRegister.getBalance ( );
			
			cashRegister.printReceipt ( ); // prints out the receipt of the just finished sale
			transaction ( cashRegister ); // asks user to cough up and gives change
			cashRegister.clearRegister ( ); // clears register to start a new sale with a new customer
			System.out.println ( "Thank you for coming to Boba Tea Lounge. Please come again!" );
			
			System.out.println ( "\n" + "Is the day over? (Y/N) " );
			done = GetInput.getYesOrNo ( );
			System.out.println ( "" );
		}
		printSales ( sales, grandTotal ); // print sales once the day is over
	}
	
	public static void transaction ( CashRegister c ) {
		double balance = ( ( ( int ) ( c.getBalance ( ) * 100 ) ) / 100.0 ); // this will round to two decimal palces
		double payment = getPayment ( balance );
		double change = payment - balance;
		System.out.printf ( "\n" + "Change: $" + "%.2f" + "\n" + "\n", change );
	}
	
	public static double getPayment ( double balance ) {
		System.out.println ( "Payment Amount" );
		double paid = GetInput.getDoubleRangeL ( balance );
		return paid;
	}
	
	public static void printSales ( ArrayList < String > sales, double grandTotal ) {
		for ( int i = 0; i < sales.size ( ); i ++ ) {
			System.out.println ( "Sale #" + ( i + 1 ) );
			System.out.println ( sales.get ( i ) + "\n" ); 
		}
		System.out.printf ( "Grand Total: $" + "%.2f", grandTotal );
	}
	
	public static BobaDrink orderTea ( ) {
		String tea = getTeaBase ( );
		String sweetness = getTeaSweetness ( );
		String milk = getTeaMilk ( );
		ArrayList < String > toppings = getTeaTopping ( );
		String size = getSize ( );
		BobaDrink order = new BobaDrink ( tea, sweetness, milk, toppings, size );
		return order;
	}
	
	public static CoffeeDrink orderCoffee ( ) {
		int teaspoons = getCoffeeSweetness ( );
		String sweetness = teaspoons + " Teaspoon";
		String milk = getCoffeeMilk ( );
		String size = getSize ( );
		CoffeeDrink order = new CoffeeDrink ( sweetness, size, milk );
		return order;
	}
	
	public static Pastry orderPastry ( ) {
		String pastry = getPastry ( );
		String temperature = getPastryTemperature ( );
		int quantity = getPastryQuantity ( );
		Pastry order = new Pastry ( pastry, quantity, temperature );
		return order;
	}

	public static Cookie orderCookie ( ) {
		String cookie = getCookie ( );
		int quantity = getCookieQuantity ( );
		Cookie order = new Cookie ( cookie, quantity );
		return order;
	}
	
	public static Macaron orderMacaron ( ) {
		String macaron = getMacaron ( );
		int quantity = getMacaronQuantity ( );
		Macaron order = new Macaron ( macaron, quantity );
		return order;
	}
	
	public static int getMacaronQuantity ( ) {
		System.out.println ( "\n" + "1 Macaron @ $1.00" );
		System.out.println ( "3 Macarons @ $2.50" );
		System.out.println ( "Macaron Amount" );
		return GetInput.getIntRangeL ( 1 );
	}
	
	public static int getPastryQuantity ( ) {
		System.out.println ( "\n" + "1 Pastry @ $1.00" );
		System.out.println ( "Pastry Amount" );
		return GetInput.getIntRangeL ( 1 );
	}
	
	public static int getCookieQuantity ( ) {
		System.out.println ( "1 Dozen Cookies @ $10.00." );
		System.out.println ( "Dozen Cookies Amount" );
		int dozens = GetInput.getIntRangeL ( 1 );
		return dozens;
	}
	
	public static boolean confirmOrder ( Object o ) {
		printOrder ( o );
		System.out.print ( "Confirm Order (Y/N): " );
		boolean confirmed = GetInput.getYesOrNo ( );
		System.out.println ( "" );
		return confirmed;
	}
	
	public static void printOrder ( Object o ) {
		System.out.println ( "\n" + "Your Order" );
		System.out.println ( o.toString ( ) );
		if ( o instanceof DrinkItem ) {
			DrinkItem d = ( DrinkItem ) o;
			System.out.printf ( "Price: $" + "%.2f" + "\n" + "\n", d.getCost ( ) );
		} else if ( o instanceof DessertItem ) {
			DessertItem d = ( DessertItem ) o;
			System.out.printf ( "Price: $" + "%.2f" + "\n" + "\n", d.getCost ( ) );
		}
	}
	
	public static int getMain ( ) {
		System.out.println ( "Boba Tea Lounge Menu" );
		System.out.println ( "1. Purchase Drink" );
		System.out.println ( "2. Purchase Dessert" );
		System.out.println ( "3. Finish Sale" );
		return GetInput.getIntRange ( 1, 3 );
	}
	
	public static int getDrink ( ) {
		System.out.println ( "\n" + "Drinks" );
		System.out.println ( "1. Tea" );
		System.out.println ( "2. Coffee" );
		return GetInput.getIntRange ( 1, 2 );
	}

	public static String getTeaBase ( ) {
		System.out.println ( "\n" + "Tea Bases" );
		System.out.println ( "1. Green Tea" );
		System.out.println ( "2. Black Tea" );
		System.out.println ( "3. Jasmine Green Tea" );
		System.out.println ( "4. Rose Tea" );
		System.out.println ( "5. Oolong Tea" );
		int input = GetInput.getIntRange ( 1, 5 );
		if ( input == 1 ) { 
			return "Green Tea";
		} else if ( input == 2 ) {
			return "Black Tea";
		} else if ( input == 3 ) {
			return "Jasmine Green Tea";
		} else if ( input == 4 ) {
			return "Rose Tea";
		} else {
			return "Oolong Tea";
		}
	}
	
	public static String getTeaSweetness ( ) {
		System.out.println ( "\n" + "Tea Sweetness" );
		System.out.println ( "1. Full Sweetness" );
		System.out.println ( "2. 75% Sweetness" );
		System.out.println ( "3. 50% Sweetness" );
		System.out.println ( "4. 25% Sweetness" );
		System.out.println ( "5. Unsweetened" );
		int input = GetInput.getIntRange ( 1, 5 );
		if ( input == 1 ) { 
			return "Full Sweetness";
		} else if ( input == 2 ) {
			return "75% Sweetness";
		} else if ( input == 3 ) {
			return "50% Sweetness";
		} else if ( input == 4 ) {
			return "25% Sweetness";
		} else {
			return "Unsweetened";
		}
	}
	
	public static String getTeaMilk ( ) {
		System.out.println ( "\n" + "Tea Milk Options" );
		System.out.println ( "1. Whole Milk" );
		System.out.println ( "2. Half-and-Half Milk" );
		System.out.println ( "3. Skim Milk" );
		System.out.println ( "4. Almond Milk" );
		System.out.println ( "5. Coconut Milk" );
		System.out.println ( "6. No Milk" );
		int input = GetInput.getIntRange ( 1, 6 );
		if ( input == 1 ) { 
			return "Whole Milk";
		} else if ( input == 2 ) {
			return "Half-and-Half Milk";
		} else if ( input == 3 ) {
			return "Skim Milk";
		} else if ( input == 4 ) {
			return "Almond Milk";
		} else if ( input == 5 ) {
			return "Coconut Milk";
		} else { 
			return "No Milk";
		}
	}
	
	public static void printTeaToppings ( ) {
		System.out.println ( "\n" + "Tea Toppings" );
		System.out.println ( "1. Honey Boba" );
		System.out.println ( "2. Popping Boba" );
		System.out.println ( "3. Grass Jelly" );
		System.out.println ( "4. Lychee Jelly" );
		System.out.println ( "5. Coconut Jelly" );
		System.out.println ( "6. Mini Mochi" );
		System.out.println ( "7. Done" );
	}
	
	public static ArrayList < String > getTeaTopping ( ) {
		ArrayList < String > toppings = new ArrayList < String > ( );
		printTeaToppings ( );
		int input = GetInput.getIntRange ( 1, 7 );
		while ( input != 7 ) {
			if ( input == 1 ) { 
				if ( ! toppings.contains( "Honey Boba" ) ) {
					toppings.add ( "Honey Boba" );
				}
			} else if ( input == 2 ) {
				if ( ! toppings.contains( "Popping Boba" ) ) {
					toppings.add ( "Popping Boba" );
				}
			} else if ( input == 3 ) {
				if ( ! toppings.contains( "Grass Jelly" ) ) {
					toppings.add ( "Grass Jelly" );
				}
			} else if ( input == 4 ) {
				if ( ! toppings.contains( "Lychee Jelly" ) ) {
					toppings.add ( "Lychee Jelly" );
				}
			} else if ( input == 5 ) {
				if ( ! toppings.contains( "Coconut Jelly" ) ) {
					toppings.add ( "Coconut Jelly" );
				}
			} else if ( input == 6 ){
				if ( ! toppings.contains( "Mini Mochi" ) ) {
					toppings.add ( "Mini Mochi" );
				}
			}
			printTeaToppings ( );
			input = GetInput.getIntRange ( 1, 7 ) ;
		}
		return toppings;
	}
	
	public static int getCoffeeSweetness ( ) {
		System.out.println ( "\n" + "Teaspoons of Sugar" );
		int sw = GetInput.getIntRangeL ( 0 );
		return sw;
	}
	
	public static String getCoffeeMilk ( ) {
		System.out.println ( "\n" + "Coffee Bases" );
		System.out.println ( "1. Water" );
		System.out.println ( "2. Whole Milk" );
		System.out.println ( "3. Almond Milk" );
		int input = GetInput.getIntRange ( 1, 3 );
		if ( input == 1 ) {
			return "Water";
		} else if ( input == 2 ) {
			return "Whole Milk";
		} else {
			return "Almond Milk";
		}
	}
	
	public static String getSize ( ) {
		System.out.println ( "\n" + "Sizes" );
		System.out.println ( "1. Small   $3.00" );
		System.out.println ( "2. Medium  $3.50" );
		System.out.println ( "3. Large   $4.00" );
		int input = GetInput.getIntRange ( 1, 3 );
		if ( input == 1 ) {
			return "Small";
		} else if ( input == 2 ) {
			return "Medium";
		} else {
			return "Large";
		}
	}
	
	public static int getDessert ( ) {
		System.out.println ( "\n" + "Desserts" );
		System.out.println ( "1. Pastry" );
		System.out.println ( "2. Cookie" );
		System.out.println ( "3. Macaron" );
		return GetInput.getIntRange ( 1, 3 );
	}
	
	public static String getPastry ( ) {
		System.out.println ( "\n" + "Pastries" );
		System.out.println ( "1. Croissant" );
		System.out.println ( "2. Muffin" );
		System.out.println ( "3. Doughnut" );
		int input = GetInput.getIntRange ( 1, 3 );
		if ( input == 1 ) {
			return "Croissant";
		} else if ( input == 2 ) {
			return "Muffin";
		} else {
			return "Doughnut";
		}
	}
	
	public static String getPastryTemperature ( ) {
		System.out.println ( "\n" + "Temperature" );
		System.out.println ( "1. Hot" );
		System.out.println ( "2. Warm" );
		System.out.println ( "3. Cool" );
		System.out.println ( "4. Cold" );
		int input = GetInput.getIntRange ( 1, 4 );
		if ( input == 1 ) {
			return "Hot";
		} else if ( input == 2 ) {
			return "Warm";
		} else if ( input == 3 ) {
			return "Cool";
		} else {
			return "Cold";
		}
	}
	
	public static String getCookie ( ) {
		System.out.println ( "\n" + "Cookie Varieties" );
		System.out.println ( "1. Chocolate Chip" );
		System.out.println ( "2. Oatmeal" );
		System.out.println ( "3. Sugar" );
		int input = GetInput.getIntRange ( 1, 3 );
		if ( input == 1 ) {
			return "Chocolate Chip Cookie";
		} else if ( input == 2 ) {
			return "Oatmeal Cookie";
		} else {
			return "Sugar Cookie";
		}
	}
	
	public static String getMacaron ( ) {
		System.out.println ( "\n" + "Macaron Flavors" );
		System.out.println ( "1. Green Tea" );
		System.out.println ( "2. Chocolate" );
		System.out.println ( "3. Vanilla" );
		int input = GetInput.getIntRange ( 1, 3 );
		if ( input == 1 ) {
			return "Green Tea Macaron";
		} else if ( input == 2 ) {
			return "Chocolate Macaron";
		} else {
			return "Vanilla Macaron";
		}
	}
}
