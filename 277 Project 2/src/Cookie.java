
public class Cookie extends DessertItem {
	/**
	 * quantity in dozens
	 */
	private int dozens;
	
	/**
	 * price per dozen
	 */
	private double pricePerDozen = 10.00;
	
	/**
	 * default constructor
	 */
	public Cookie ( ) {
		super ( "Cookie" );
		dozens = 1;
	}
	
	/**
	 * overlaoded constructor
	 * @param c - type of cookie
	 * @param d - amount of dozens
	 */
	public Cookie ( String c, int d ) {
		super ( c );
		dozens = d;
	}
	
	/**
	 * @desc gets teh quantity of dozens
	 * @return int - quantity of dozens
	 */
	public int getQuantity ( ) {
		return dozens;
	}
	
	/**
	 * @desc sets the quantity of dozens
	 * @param d - quantity to set to
	 */
	public void setQuantity ( int d ) {
		dozens = d;
	}
	
	/**
	 * @desc returns the amount of dozens of cookies ordered
	 * @return string - order of cookies
	 */
	public String toString ( ) {
		String s = dozens + " x Dozen of " + super.getName ( ) + "s" + "\n";
		return s;
	}
	
	/**
	 * @desc calculates cost and returns it
	 * @return double - cost
	 */
	@Override
	public double getCost ( ) {
		return dozens * pricePerDozen;
	}

	@Override
	public int compareTo(DessertItem arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
