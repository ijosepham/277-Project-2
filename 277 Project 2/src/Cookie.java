
public class Cookie extends DessertItem {
	private int quantity;
	private int singles;
	private int dozens;
	private double singlesPrice = 1.00;
	private double dozensPrice = 10.00;
	
	public Cookie ( ) {
		super ( "Cookie" );
		quantity = 1;
		singles = 1;
		dozens = 0;
	}
	
	public Cookie ( String c, int q ) {
		super ( c );
		quantity = q;
		singles = quantity % 12;
		dozens = quantity / 12;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 12;
		dozens = quantity / 12;
	}
	
	public String toString ( ) {
		String s = "";
		if ( dozens > 0 ) {
			s += dozens + " x Dozen " + " " + super.getName ( ) + "s";
		}
		if ( singles > 0 ) {
			s += singles + " x " + " " + super.getName ( );
		}
		return s;
	}
	
	@Override
	public double getCost() {
		return singles * singlesPrice + dozens * dozensPrice;
	}
	
	@Override
	public void incrementQuantity ( ) {
		quantity += 1;
		singles = quantity % 12;
		dozens = quantity / 12;
		
	}
	
	@Override
	public boolean equals ( MenuItem m ) {
		if ( m instanceof Cookie ) {
			Cookie c = ( Cookie ) m;
			if ( this.getName ( ) == c.getName ( ) ) {
				return true;
			}
		}
		return false;
	}
}
