import java.util.ArrayList;
/**
 * @author joey pham
 * @date 21 feb 19
 * @desc user takes orders of customers' drinks and desserts they'd like to buy. 
 */

public class BobaTeaLounge {
	public static void main ( String [ ] args ) {
		ArrayList < String > sales = new ArrayList < String > ( ); // contains all the receipts from al lsales
		CashRegister cashRegister  = new CashRegister ( ); // hurrdurr
		double grandTotal = 0;
		Object order = null;
		int menuChoice = 0;
		boolean done = false; // keep track if the day is done or not
		
		while ( !done ) { // while day hasn't finished
			System.out.println ( "Welcome to Boba Tea Lounge! What may I get you?" + "\n" );
			menuChoice = getMain ( ); // prompts user if they want a drink, desser, or to finish their sale
			while ( menuChoice != 3 ) { // while user wants to keep buying items
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
				if ( confirmOrder ( order ) ) { 
					cashRegister.addOrder ( order ); // add the order if the user confirms it
				}
				System.out.println ( "Would you like anything else?" + "\n" );
				menuChoice = getMain ( ); // then asks if they want another item or to finsih up the sale
			}
			// reaches here once user says they're done with their sale
			sales.add ( cashRegister.getSale ( ) ); // add receipt to arraylist
			grandTotal += cashRegister.getBalance ( ); // increase grandtotal by sale balance
			
			cashRegister.printReceipt ( ); // prints out the receipt of the just finished sale
			transaction ( cashRegister ); // asks user to cough up and program gives change
			cashRegister.clearRegister ( ); // clears register to start a new sale with a new customer
			System.out.println ( "Thank you for coming to Boba Tea Lounge. Please come again!" ); // cya@
			
			System.out.println ( "\n" + "Is the day over? (Y/N)" ); // asks if day is over, if not, keep looping
			done = GetInput.getYesOrNo ( ); // if day is over, print all sales from the day
			System.out.println ( "" );
		}
		printSales ( sales, grandTotal ); // print sales once the day is over
	}

	/**
	 * @desc gets customer's money to pay for their order and gives change if due. only happens after user finishes their sale
	 * @param c - cash register so you can pull the balance of the order from
	 */
	public static void transaction ( CashRegister c ) {
		double balance = ( ( ( int ) ( c.getBalance ( ) * 100 ) ) / 100.0 ); // this will round to two decimal palces
		double payment = getPayment ( balance );
		double change = payment - balance;
		System.out.printf ( "\n" + "Change: $" + "%.2f" + "\n" + "\n", change );
	}
	
	/**
	 * @desc gets customer's money, verifying that they're paying enough
	 * @param balance - makes sure that the user will pay at least the amount owed
	 * @return double - validated amount due for their order
	 */
	public static double getPayment ( double balance ) {
		System.out.println ( "Payment Amount" );
		double payment = GetInput.getDoubleRangeL ( balance );
		return payment;
	}
	
	/**
	 * @desc prints all sales made that day and the total amount made; only happens when the day is over
	 * @param sales - list of all the sales that day to print out
	 * @param grandTotal - the amount of money made that day
	 */
	public static void printSales ( ArrayList < String > sales, double grandTotal ) {
		for ( int i = 0; i < sales.size ( ); i ++ ) {
			System.out.println ( "Sale #" + ( i + 1 ) );
			System.out.println ( sales.get ( i ) + "\n" ); 
		}
		System.out.printf ( "Grand Total: $" + "%.2f", grandTotal );
	}
	
	/**
	 * @desc gets flavor, sweetness, milk, toppings, and size of tea the user wants
	 * @return boba - order they just made
	 */
	public static BobaDrink orderTea ( ) {
		String tea = getTeaBase ( );
		String sweetness = getTeaSweetness ( );
		String milk = getTeaMilk ( );
		ArrayList < String > toppings = getTeaTopping ( );
		String size = getSize ( );
		BobaDrink order = new BobaDrink ( tea, sweetness, milk, toppings, size );
		return order;
	}
	
	/**
	 * @desc gets sweetness, coffeebase, and size of the coffee the user wants
	 * @return coffee - the drink the user just ordered
	 */
	public static CoffeeDrink orderCoffee ( ) {
		int teaspoons = getCoffeeSweetness ( );
		String sweetness = teaspoons + " Teaspoon";
		String milk = getCoffeeBase ( );
		String size = getSize ( );
		CoffeeDrink order = new CoffeeDrink ( sweetness, size, milk );
		return order;
	}
	
	/**
	 * @desc gets pastry type, temp, and quantity, then makes an order out of it
	 * @return pastry - type, temp, and amount of pastry they wanted
	 */
	public static Pastry orderPastry ( ) {
		String pastry = getPastry ( );
		String temperature = getPastryTemperature ( );
		int quantity = getPastryQuantity ( );
		Pastry order = new Pastry ( pastry, quantity, temperature );
		return order;
	}

	/**
	 * @desc gets cookie type and quantity , then makes an oreder out of it
	 * @return cookie - type and amount of cookie they wanted
	 */
	public static Cookie orderCookie ( ) {
		String cookie = getCookie ( );
		int quantity = getCookieQuantity ( );
		Cookie order = new Cookie ( cookie, quantity );
		return order;
	}
	
	/**
	 * @desc gets macaron name and quantity, then make an order out of it
	 * @return macaron - the specific type and amount the user ordered
	 */
	public static Macaron orderMacaron ( ) {
		String macaron = getMacaron ( );
		int quantity = getMacaronQuantity ( );
		Macaron order = new Macaron ( macaron, quantity );
		return order;
	}
	
	/**
	 * @desc shows prices and deals for macarons, gets the amount user wants to buy
	 * @return int - amount of macarons user wants to buy
	 */
	public static int getMacaronQuantity ( ) {
		System.out.println ( "\n" + "1 Macaron @ $1.00" );
		System.out.println ( "3 Macarons @ $2.50" );
		System.out.println ( "Macaron Amount" );
		return GetInput.getIntRangeL ( 1 );
	}
	
	/**
	 * @desc gets the amount of pastries user wants, also shows pastry price
	 * @return int - amount of pastries user wants;
	 */
	public static int getPastryQuantity ( ) {
		System.out.println ( "\n" + "1 Pastry @ $1.00" );
		System.out.println ( "Pastry Amount" );
		return GetInput.getIntRangeL ( 1 );
	}
	
	/**
	 * @desc prompts user how many cookies they'd like, also shows them how much cookies cost
	 * @return int - amount of dozens of cookies they want;
	 */
	public static int getCookieQuantity ( ) {
		System.out.println ( "1 Dozen Cookies @ $10.00." );
		System.out.println ( "Dozen Cookies Amount" );
		int dozens = GetInput.getIntRangeL ( 1 );
		return dozens;
	}
	
	/**
	 * @desc confirms whether or not the customer still wants that item
	 * @param o - order to be printed
	 * @return t/f - whether they wanted the order or not
	 */
	public static boolean confirmOrder ( Object o ) {
		printOrder ( o );
		System.out.print ( "Confirm Order (Y/N): " );
		boolean confirmed = GetInput.getYesOrNo ( );
		System.out.println ( "" );
		return confirmed;
	}
	
	/**
	 * @desc prints out the current order, used later to confirm whether or not they want it
	 * @param o - menu item that customer ordered
	 */
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
	
	/**
	 * @desc prompts user if they'd like to purchase something or finish their sale. returns corresponding action
	 * @return int - choice if they wanted to get a drink/dessert/quit
	 */
	public static int getMain ( ) {
		System.out.println ( "Boba Tea Lounge Menu" );
		System.out.println ( "1. Purchase Drink" );
		System.out.println ( "2. Purchase Dessert" );
		System.out.println ( "3. Finish Sale" );
		return GetInput.getIntRange ( 1, 3 );
	}
	
	/**
	 * @desc after choosing to buy a drink, will go here to see what kind of drink they want. returns result
	 * @return int - number that represents which drink they want
	 */
	public static int getDrink ( ) {
		System.out.println ( "\n" + "Drinks" );
		System.out.println ( "1. Tea" );
		System.out.println ( "2. Coffee" );
		return GetInput.getIntRange ( 1, 2 );
	}

	/**
	 * @desc prints and prompts user for what tea base they want
	 * @return string - desired tea base
	 */
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
	
	/**
	 * @desc prints and prompts user to choose what % sweentess they want for their tea
	 * @return string - string version of % of sweetness
	 */
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
	
	/**
	 * @desc prints out milk options for tea, gets and returns the desired option
	 * @return string - milk base the user wants
	 */
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
	
	/**
	 * @desc prints tea toppings
	 */
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
	
	/**
	 * @desc prompts user to pick their topping. user can get as many types of toppings they want.
	 * 		 will keep looping until they decide they're done
	 * @return arraylist of string - all the toppings the user wants in their tea
	 */
	public static ArrayList < String > getTeaTopping ( ) {
		ArrayList < String > toppings = new ArrayList < String > ( );
		printTeaToppings ( );
		int input = GetInput.getIntRange ( 1, 7 );
		while ( input != 7 ) { // while user hasnt finished adding toppings, keep going
			if ( input == 1 ) { 
				if ( ! toppings.contains( "Honey Boba" ) ) { // makes sure the desired topping isnt already added
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
	
	/**
	 * @desc prompts user to enter the amount of teaspoons of suguar they want in their coffee and gets it
	 * @return int - amount of teaspoons of sugar
	 */
	public static int getCoffeeSweetness ( ) {
		System.out.println ( "\n" + "Teaspoons of Sugar" );
		int sw = GetInput.getIntRangeL ( 0 );
		return sw;
	}
	
	/**
	 * @desc prints and gets coffee base 
	 * @return string - base of the coffee
	 */
	public static String getCoffeeBase ( ) {
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
	
	/**
	 * @desc prints out and gets the differnet sizes for drinks and its corresponding price
	 * @return string - small/medium/large size of the drink
	 */
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
	
	/**
	 * @desc prints out what types of desserts are available and gets the desired one. will lead to another menu of certain flavors
	 * @return int - number representing which type of dessert is requested
	 */
	public static int getDessert ( ) {
		System.out.println ( "\n" + "Desserts" );
		System.out.println ( "1. Pastry" );
		System.out.println ( "2. Cookie" );
		System.out.println ( "3. Macaron" );
		return GetInput.getIntRange ( 1, 3 );
	}
	
	/**
	 * @desc prints out the the different kinds of pastries and gets which one the customer wants
	 * @return string - desired pastry
	 */
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
	
	/**
	 * @desc gets the desired temperature for the customer's pastry
	 * @return string - desired temperature for the pastry
	 */
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
	
	/**
	 * @desc prints out cookie flavors and gets customer's desired flavor
	 * @return string - customer's desired cookie flavor
	 */
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
	
	/**
	 * @desc prints out the macaron flavors and gets the flavor the customer wants
	 * @return string - macaron flavor customer requested
	 */
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
