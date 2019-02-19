
public class Cookie extends DessertItem {
	private int quantity;
	private double pricePerDozen = 10.00;
	
	public Cookie ( ) {
		super ( "Cookie" );
		quantity = 1;
	}
	
	public Cookie ( String c, int q ) {
		super ( c );
		quantity = q;
	}
	
	public int getQuantity ( ) {
		return quantity;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
	}
	
	public String toString ( ) {
		String s = quantity + " x Dozen of " + super.getName ( ) + "s";
		return s;
	}
	
	@Override
	public double getCost() {
		int dozens = quantity / 12;
		return dozens * pricePerDozen;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if ( o instanceof Cookie ) {
			Cookie c = ( Cookie ) o;
			if ( this.getName ( ) == c.getName ( ) ) {
				return true;
			}
		}
		return false;
	}
}
