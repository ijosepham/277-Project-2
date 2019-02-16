/**
 * remove plural thing, pass in only the base name 
 * move plural thing to dessert tostring to just add the "s" 
 * in cash register, combine orders with first instance 
 * 		of same base name.
 */

public class BobaTeaLounge {
	public static void main ( String [ ] args ) {
		int menuChoice = getMain ( );
		MenuItem order = null;
		CashRegister cashRegister  = new CashRegister ( );
		
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
			if ( confirmOrder ( order ) ) {
				cashRegister.addOrder ( order );
			}
			cashRegister.printReceipt ( );
			menuChoice = getMain ( );
		}
		System.out.println ( "Thank you for coming to Boba Tea Lounge. Come again!" );
	}
	
	public static BobaDrink orderTea ( ) {
		String tea = getTeaBase ( );
		String sweetness = getTeaSweetness ( );
		String milk = getTeaMilk ( );
		String topping = getTeaTopping ( );
		String size = getSize ( );
		int quantity = getQuantity ( );
		BobaDrink order = new BobaDrink ( tea, sweetness, milk, topping, size, quantity );
		return order;
	}
	
	public static CoffeeDrink orderCoffee ( ) {
		int teaspoons = getCoffeeSweetness ( );
		String sweetness = teaspoons + " Teaspoon";
		String milk = getCoffeeMilk ( );
		String size = getSize ( );
		int quantity = getQuantity ( );
		CoffeeDrink order = new CoffeeDrink ( sweetness, size, milk, quantity );
		return order;
	}
	
	public static Pastry orderPastry ( ) {
		String pastry = getPastry ( );
		String temperature = getPastryTemperature ( );
		int quantity = getQuantity ( );
		Pastry order = new Pastry ( pastry, quantity, temperature );
		return order;
	}

	public static Cookie orderCookie ( ) {
		String cookie = getCookie ( );
		int quantity = getQuantity ( );
		Cookie order = new Cookie ( cookie, quantity );
		return order;
	}
	
	public static Macaron orderMacaron ( ) {
		String macaron = getMacaron ( );
		int quantity = getQuantity ( );
		Macaron order = new Macaron ( macaron, quantity );
		return order;
	}
	
	public static int getQuantity () {
		System.out.print ( "How many would you like? " );
		return GetInput.getIntRangeL ( 1 );
	}
	
	public static boolean confirmOrder ( MenuItem o ) {
		printOrder ( o );
		System.out.print ( "Confirm Order (Y/N): " );
		return GetInput.getYesOrNo ( );
	}
	
	public static void printOrder ( MenuItem o ) {
		System.out.println ( "\n" + "Your Order" );
		System.out.println ( o.toString ( ) );
		System.out.printf ( "Price: $" + "%.2f" + "\n" + "\n", o.getCost ( ) );
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
	
	public static String getTeaTopping ( ) {
		System.out.println ( "\n" + "Tea Toppings" );
		System.out.println ( "1. Boba" );
		System.out.println ( "2. Popping Boba" );
		System.out.println ( "3. Grass Jelly" );
		System.out.println ( "4. Lychee Jelly" );
		System.out.println ( "5. Coconut Jelly" );
		System.out.println ( "6. Mini Mochi" );
		System.out.println ( "7. None" );
		int input = GetInput.getIntRange ( 1, 7 );
		if ( input == 1 ) { 
			return "Boba";
		} else if ( input == 2 ) {
			return "Popping Boba";
		} else if ( input == 3 ) {
			return "Grass Jelly";
		} else if ( input == 4 ) {
			return "Lychee Jelly";
		} else if ( input == 5 ) {
			return "Coconut Jelly";
		} else if ( input == 6 ){
			return "Mini Mochi";
		} else {
			return "None";
		}
	}
	
	public static int getCoffeeSweetness ( ) {
		System.out.print ( "\n" + "How many teaspoons of sugar would you like? " );
		int sw = GetInput.getIntRangeL ( 0 );
		System.out.println ( "" );
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
