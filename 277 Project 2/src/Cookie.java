
public class Cookie extends DessertItem {
	private int quantity;
	private int singles;
	private int dozens;
	private double singlePrice = 1.00;
	private double dozenPrice = 10.00;
	
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
	
	public String toString ( ) {
		if ( quantity % 12 == 0 ) { // if dozen(s)
			if ( quantity == 12 ) { // if only one dozen
				return "1 Dozen of " + super.getName ( );
			} else {
				return dozens + " Dozens of " + super.getName ( );
			}
		} else {
			if ( quantity == 1 ) {
				return "1 " + super.getName ( );
			} else {
				return quantity + " " + super.getName ( );
			}
		}
	}
	
	@Override
	public double getCost() {
		return singles * singlePrice + dozens * dozenPrice;
	}

}
