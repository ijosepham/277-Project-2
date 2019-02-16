
public class Macaron extends DessertItem {
	private int quantity;
	private int singles;
	private int trios;
	private double singlesPrice = 1.00;
	private double triosPrice = 2.50;
	
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
		String s = "";
		if ( trios > 0 ) {
			if ( trios > 1 ) {
				s += trios + " Trios of ";
			} else {
				s += "1 Trio of ";
			}
			s += super.getName ( ) + "s" + "\n";
		}
		if ( singles > 0 ) {
			if ( singles > 1 ) {
				s += singles + " " + super.getName ( ) + "s" + "\n";
			} else {
				s += "1 " + super.getName ( ) + "\n";
			}
		}
		return s;
	}
	
	@Override
	public double getCost() {
		return singles * singlesPrice + trios * triosPrice;
	}
	
	@Override
	public void incrementQuantity ( ) {
		quantity += 1;
		
	}
}
