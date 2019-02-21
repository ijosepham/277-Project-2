
public class Cookie extends DessertItem {
	private int dozens;
	private double pricePerDozen = 10.00;
	
	public Cookie ( ) {
		super ( "Cookie" );
		dozens = 1;
	}
	
	public Cookie ( String c, int d ) {
		super ( c );
		dozens = d;
	}
	
	public int getQuantity ( ) {
		return dozens;
	}
	
	public void setQuantity ( int d ) {
		dozens = d;
	}
	
	public String toString ( ) {
		String s = dozens + " x Dozen of " + super.getName ( ) + "s" + "\n";
		return s;
	}
	
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
