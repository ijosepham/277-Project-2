
public class Macaron extends DessertItem {
	private int quantity;
	private int singles;
	private int threes;
	private double singlesPrice = 1.00;
	private double threesPrice = 2.50;
	
	public Macaron ( ) {
		super ( "Macaron" );
		quantity = 1;
		singles = 1;
		threes = 0;
	}
	
	public Macaron ( String m, int q ) {
		super ( m );
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
		String s = "";
		if ( threes > 0 ) {
			s += threes + " x Three " + super.getName ( ) + "s";
		}
		if ( singles > 0 ) {
			s += singles + " x " + super.getName ( );
		}
		return s;
	}
	
	@Override
	public double getCost() {
		return singles * singlesPrice + threes * threesPrice;
	}
	
	@Override
	public void combineOrders ( int q ) {
		quantity += q;
		singles = quantity % 3;
		threes = quantity / 3;
		
	}
	
	@Override
	public boolean equals ( MenuItem m ) {
		if ( m instanceof Macaron ) {
			Macaron mac = ( Macaron ) m;
			if ( this.getName ( ) == mac.getName ( ) ) {
				return true;
			}
		}
		return false;
	}
}
