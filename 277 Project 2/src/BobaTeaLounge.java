
public class BobaTeaLounge {
	public static void main ( String [ ] args ) {

	}
	
	public void getMainMenu ( ) {
		System.out.println ( "Boba Tea Lounge Menu" );
		System.out.println ( "1. Purchase Drink" );
		System.out.println ( "2. Purchase Dessert" );
		System.out.println ( "3. Finish Sale" );
	}
	
	public void printDrinksMenu ( ) {
		System.out.println ( "Drinks" );
		System.out.println ( "1. Tea" );
		System.out.println ( "2. Coffee" );
	}
	
	public void printTeaMenu ( ) {
		printTeaBaseMenu ( );
		printTeaSweetnessMenu ( );
		printTeaMilkMenu ( );
		printTeaToppingsMenu ( );
		printTeaSizeMenu ( );
	}
	
	public void printTeaBaseMenu ( ) {
		System.out.println ( "Tea Bases" );
		System.out.println ( "1. Green Tea" );
		System.out.println ( "2. Black Tea" );
		System.out.println ( "3. Jasmine Green Tea" );
		System.out.println ( "4. Rose Tea" );
		System.out.println ( "5. Oolong Tea" );
	}
	
	public void printTeaSweetnessMenu ( ) {
		System.out.println ( "Tea Sweetness" );
		System.out.println ( "1. Full Sweetness" );
		System.out.println ( "2. 75% Sweetness" );
		System.out.println ( "3. 50% Sweetness" );
		System.out.println ( "4. 25% Sweetness" );
		System.out.println ( "5. Unsweetened" );
	}
	
	public void printTeaMilkMenu ( ) {
		System.out.println ( "Tea Milk Options" );
		System.out.println ( "1. Whole Milk" );
		System.out.println ( "2. Half-and-Half Milk" );
		System.out.println ( "3. Skim Milk" );
		System.out.println ( "4. Almond Milk" );
		System.out.println ( "5. Coconut Milk" );
		System.out.println ( "6. No Milk" );
	}
	
	public void printTeaToppingsMenu ( ) {
		System.out.println ( "Tea Toppings" );
		System.out.println ( "1. Boba" );
		System.out.println ( "2. Popping Boba" );
		System.out.println ( "3. Grass Jelly" );
		System.out.println ( "4. Lychee Jelly" );
		System.out.println ( "5. Coconut Jelly" );
		System.out.println ( "6. Mini Mochi" );
	}
	
	public void printTeaSizeMenu ( ) {
		System.out.println ( "Tea Sizes" );
		System.out.println ( "1. Small" );
		System.out.println ( "2. Medium" );
		System.out.println ( "3. Large" );
	}
	
	public void printCoffeeMenu ( ) {
		printCoffeeSweetnessMenu ( );
		printCoffeeMilkMenu ( ) ;
		printCoffeeSizeMenu ( );
	}
	
	public void printCoffeeSweetnessMenu ( ) {
		System.out.print ( "\n" + "How many teaspoons of sugar would you like? " );
	}
	
	public void printCoffeeMilkMenu ( ) {
		System.out.println ( "Coffee Bases" );
		System.out.println ( "1. Water" );
		System.out.println ( "2. Whole Milk" );
		System.out.println ( "3. Almond Milk" );
	}
	
	public void printCoffeeSizeMenu ( ) {
		System.out.println ( "Coffee Sizes" );
		System.out.println ( "1. Small" );
		System.out.println ( "2. Medium" );
		System.out.println ( "3. Large" );
	}
	
	public void printDessertsMenu ( ) {
		System.out.println ( "Desserts" );
		System.out.println ( "1. Pastry" );
		System.out.println ( "2. Cookie" );
		System.out.println ( "3. Macaron" );
	}
	
	public void printPastriesMenu ( ) {
		System.out.println ( "Pastries" );
		System.out.println ( "1. Croissant" );
		System.out.println ( "2. Muffin" );
		System.out.println ( "3. Doughnut" );
	}
	
	public void printCookiesMenu ( ) {
		System.out.println ( "Cookie Varieties" );
		System.out.println ( "1. Chocolate Chip" );
		System.out.println ( "2. Oatmeal" );
		System.out.println ( "3. Sugar" );
	}
	
	public void printMacaronMenu ( ) {
		System.out.println ( "Macaron Flavors" );
		System.out.println ( "1. Green Tea" );
		System.out.println ( "2. Chocolate" );
		System.out.println ( "3. Vanilla" );
	}
}
