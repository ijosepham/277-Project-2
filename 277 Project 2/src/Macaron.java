
public class Macaron extends Cookie {
	/**
	 * quantity of macarons
	 */
	private int quantity;
	
	/**
	 * quantity of single macarons
	 */
	private int singles;
	
	/**
	 * quantity of three macarons
	 */
	private int threes;
	
	/**
	 * price for a single macaron
	 */
	private double pricePerOne = 1.00;
	
	/**
	 * price for a trio of macarons
	 */
	private double pricePerThree = 2.50;
	
	/**
	 * default constructor
	 */
	public Macaron ( ) {
		super ( "Macaron", 1 );
		quantity = 1;
		singles = 1;
		threes = 0;
	}
	
	/**
	 * overloaded constructor
	 * @param m - name of macaron
	 * @param q - quantity
	 */
	public Macaron ( String m, int q ) {
		super ( m, q );
		quantity = q;
		singles = quantity % 3;
		threes = quantity / 3;
	}
	
	/**
	 * @desc returns the quantity of macarons ordered
	 * @return int - quantity of macarons
	 */
	public int getQuantity ( ) {
		return quantity;
	}
	
	/**
	 * @desc sets the quantity of amcarons
	 * @param q - quantity of macarons
	 */
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 3;
		threes = quantity / 3;
	}
	
	/**
	 * @desc returns a string of the order of macarons
	 * @return string - order
	 */
	public String toString ( ) {
		String singlesPrice = String.format ( "%.2f", singles * pricePerOne );
		String threesPrice = String.format ( "%.2f", threes * pricePerThree);
		String s = "";
		if ( threes > 0 ) {
			s += threes + " x Three " + super.getName ( ) + "s - $" + threesPrice + "\n";
		}
		if ( singles > 0 ) {
			s += singles + " x " + super.getName ( ) + " - $" + singlesPrice + "\n";
		}
		return s;
	}
	
	/**
	 * @desc calculates and reutrns the cost of the order
	 * @return double - cost of the order
	 */
	@Override
	public double getCost ( ) {
		return singles * pricePerOne + threes * pricePerThree;
	}
}
