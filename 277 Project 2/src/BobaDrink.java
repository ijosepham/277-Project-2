import java.util.ArrayList;

public class BobaDrink extends DrinkItem {
	/**
	 * list of all the toppings of the drink item, may contain none
	 */
	private ArrayList < String > toppings;
	
	/**
	 * represents the milk base
	 */
	private String milk;
	
	/**
	 * represents the cost of the drink
	 */
	private double cost;
	
	/**
	 * default constructor
	 */
	public BobaDrink ( ) {
		super ( );
		toppings = new ArrayList < String > ( );
		milk = "";
		cost = 3.50;
	}
	
	/**
	 * overloaded constructor
	 * @param n - name of the drink
	 * @param sw - sweetness of the drink
	 * @param m - milk base of the drink
	 * @param t - list of toppings
	 * @param sz - size of the drink
	 */
	public BobaDrink ( String n, String sw, String m, ArrayList < String > t, String sz ) {
		super ( n, sw, sz );
		toppings = t;
		milk = m;
		cost = calculateCost ( );
	}
	
	/**
	 * @desc sets the toppings for the drink
	 * @param t - list of toppings of the drink
	 */
	public void setToppings ( ArrayList < String > t ) {
		toppings = t;
		cost = calculateCost ( );
	}
	
	/**
	 * @desc sets the milk base for the drink
	 * @param m - milk base
	 */
	public void setMilk ( String m ) {
		milk = m;
	}
	
	/**
	 * @desc gets the drink's toppings
	 * @return toppings - toppings of the drink
	 */
	public ArrayList < String > getToppings ( ) {
		return toppings;
	}
	
	/**
	 * @desc gets the drink's milk base
	 * @return milk - milk base
	 */
	public String getMilk ( ) {
		return milk;
	}
	
	/**
	 * @desc calculates the cost of the boba drink
	 * @return cost of the drink
	 */
	public double calculateCost ( ) {
		double c = 0;
		c += .5 * toppings.size ( );
		if ( super.getSize( ) == "Small" ) {
			c += 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			c += 3.50;
		} else if ( super.getSize ( ) == "Large" ){
			c += 4.00;
		} 
		return c;
	}
	
	/**
	 * @desc sets the cost of the order, used for coupons
	 * @param c cost to apply to
	 */
	public void setCost ( double c ) {
		cost = c;
	}
	
	/**
	 * @desc displays the drink and its attributes
	 * @return string - order of bobadrink
	 */
	public String toString ( ) {
		 String s = super.getSize ( ) + " " + super.getName ( ) + "\n";
		 s += " -" + super.getSweetness ( ) + "\n";
		 s += " -" + milk + "\n";
		 if ( toppings.size ( ) == 0 ) {
			 s += " -No Toppings" + "\n";
		 } else {
			 s += " -" + toppings.size ( ) + " Toppings" + "\n";
			 for ( int i = 0; i < toppings.size ( ); i ++ ) {
				 s += "   -" + toppings.get ( i ) + "\n";
			 }
		 }
		 return s;
	}
	
	/**
	 * @desc calculates and returns the cost of the drink
	 * @return double - cost of the drink
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
