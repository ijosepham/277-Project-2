
public class Macaron extends Cookie {
	private int quantity;
	private double pricePerOne = 1.00;
	private double pricePerThree = 2.50;
	
	public Macaron ( ) {
		super ( "Macaron", 1 );
		quantity = 1;
	}
	
	public Macaron ( String m, int q ) {
		super ( m, q );
		quantity = q;
	}
	
	public int getQuantity ( ) {
		return quantity;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
	}
	
	public String toString ( ) {
		int threes = quantity / 3;
		int singles = quantity % 3;
		String s = "";
		if ( threes > 0 ) {
			s += threes + " x Three " + super.getName ( ) + "s" + "\n";
		}
		if ( singles > 0 ) {
			s += singles + " x " + super.getName ( ) + "\n";
		}
		return s;
	}
	
	@Override
	public double getCost ( ) {
		int threes = quantity / 3;
		int singles = quantity % 3;
		return singles * pricePerOne + threes * pricePerThree;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if ( o instanceof Macaron ) {
			Macaron mac = ( Macaron ) o;
			if ( this.getName ( ) == mac.getName ( ) ) {
				return true;
			}
		}
		return false;
	}
}
