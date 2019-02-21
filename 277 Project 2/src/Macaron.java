
public class Macaron extends Cookie {
	private int quantity;
	private int singles;
	private int threes;
	private double pricePerOne = 1.00;
	private double pricePerThree = 2.50;
	
	public Macaron ( ) {
		super ( "Macaron", 1 );
		quantity = 1;
		singles = 1;
		threes = 0;
	}
	
	public Macaron ( String m, int q ) {
		super ( m, q );
		quantity = q;
		singles = quantity % 3;
		threes = quantity / 3;
	}
	
	public int getQuantity ( ) {
		return quantity;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 3;
		threes = quantity / 3;
	}
	
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
	
	@Override
	public double getCost ( ) {
		return singles * pricePerOne + threes * pricePerThree;
	}
}
