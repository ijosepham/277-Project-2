
public class Cookie extends DessertItem {
	/**
	 * quantity of cookies
	 */
	private int quantity;
	
	/**
	 * singles of cookies
	 */
	private int singles;
	
	/**
	 * dozens of cookies
	 */
	private int dozens;
	
	/**
	 * price for one single cookie
	 */
	private double pricePerOne = 1.00;
	
	/**
	 * price per dozen
	 */
	private double pricePerDozen = 10.00;
	
	/**
	 * total cost of the order of cookies
	 */
	private double cost;
	
	/**
	 * default constructor
	 */
	public Cookie ( ) {
		super ( "Cookie" );
		quantity = 1;
		singles= 1;
		dozens = 0;
		cost = 1;
	}
	
	/**
	 * overlaoded constructor
	 * @param c - type of cookie
	 * @param d - amount of dozens
	 */
	public Cookie ( String c, int q ) {
		super ( c );
		quantity = q;
		singles = quantity % 12;
		dozens = quantity / 12;
		cost = singles * pricePerOne + dozens * pricePerDozen;
	}
	
	/**
	 * @desc gets teh quantity of dozens
	 * @return int - quantity of dozens
	 */
	public int getQuantity ( ) {
		return quantity;
	}
	
	/**
	 * @desc sets the quantity of dozens
	 * @param d - quantity to set to
	 */
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 12;
		dozens = quantity / 12;
		cost = singles * pricePerOne + dozens * pricePerDozen;
	}
	
	/**
	 * @desc sets the cost of the order, used for coupons
	 * @param c cost to apply to
	 */
	public void setCost ( double c ) {
		cost = c;
	}
	
	/**
	 * @desc returns the amount of dozens of cookies ordered
	 * @return string - order of cookies
	 */
	public String toString ( ) {
		String s = "";
		if ( dozens > 0 ) {
			s += dozens + " x Dozen of " + super.getName ( ) + "s" + "\n";
		}
		if ( singles > 0 ) {
			s += singles + " x " + super.getName ( ) + "\n";
		}
		return s;
	}
	
	/**
	 * @desc calculates cost and returns it
	 * @return double - cost
	 */
	@Override
	public double getCost ( ) {
		return cost;
	}

	@Override
	public int compareTo(DessertItem arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
