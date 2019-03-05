
public class CoffeeDrink extends DrinkItem {
	/**
	 * base of the drink
	 */
	private String base;
	
	/**
	 * cost of the cofffee
	 */
	private double cost;
	/**
	 * default constructor
	 */
	public CoffeeDrink ( ) {
		super ( );
		base = "Water";
		cost = 3.50;
	}
	
	/**
	 * overloaded constructor
	 * @param sw - sweetness
	 * @param sz - size
	 * @param b - base
	 */
	public CoffeeDrink ( String sw, String sz, String b ) {
		super ( "Coffee", sw, sz ); 
		base = b;
		cost = calculateCost ( );
		
	}
	
	/**
	 * @desc calculates the cost of the current roder of the drink by the size
	 * @return cost of the coffee
	 */
	public double calculateCost ( ) {
		if ( super.getSize( ) == "Small" ) {
			return 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			return 3.50;
		} else if ( super.getSize ( ) == "Large" ){
			return 4.00;
		} 
		return 0;
	}
	
	/**
	 * @desc sets the base of the coffee
	 * @param b - base
	 */
	public void setBase ( String b ) {
		base = b;
	}
	
	/**
	 * @desc gets the base of the coffee
	 * @return string - base
	 */
	public String getBase ( ) {
		return base;
	}
	
	/**
	 * @desc sets the cost of the order, used for coupons
	 * @param c cost to apply to
	 */
	public void setCost ( double c ) {
		cost = c;
	}
	
	/**
	 * @desc returns a string of the order
	 * @return string - order of coffee
	 */
	public String toString ( ) {
		 String s = super.getSize ( ) + " " + super.getName ( ) + "\n";
		 s += " -" + super.getSweetness ( ) + "\n";
		 s += " -" + base + " Based" + "\n";
		 return s;
	}
	
	/**
	 * @desc calculates adn returns the cost of the order
	 * @return double - cost cost of the coffee
	 */
	@Override
	public double getCost ( ) {
		return cost;
	}

	@Override
	public int compareTo(DrinkItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
