
public class Macaron extends DessertItem {
	private int quantity;
	private int singles;
	private int trios;
	private double singlePrice = 1.00;
	private double trioPrice = 2.50;
	
	public Macaron ( ) {
		super ( "Macaron" );
		quantity = 1;
		singles = 1;
		trios = 0;
	}
	
	public Macaron ( String m, int q ) {
		super ( m );
		quantity = q;
		singles = quantity % 3;
		trios = quantity / 3;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 3;
		trios = quantity / 3;
	}
	
	public String toString ( ) {
		if ( quantity > 1 ) {
			return quantity + " " + super.getName ( );
		} else {
			return "1 " + super.getName ( );
		}
	}
	
	@Override
	public double getCost() {
		return singles * singlePrice + trios * trioPrice;
	}

}
