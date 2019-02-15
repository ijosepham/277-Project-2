
public class Pastry extends DessertItem {
	private int quantity;
	private int singles;
	private int fives;
	private double singlesPrice = 1.00;
	private double fivesPrice = 4.00;
	private String temperature;
	
	public Pastry ( ) {
		super ( "Pastry" );
		quantity = 1;
		temperature = "Warm";
	}
	
	public Pastry ( String p, int q, String t ) {
		super ( p );
		quantity = q;
		singles = quantity % 5;
		fives = quantity / 5;
		temperature = t;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 5;
		fives = quantity / 5;
	}
	
	public String toString ( ) {
		String s = "";
		if ( fives > 0 ) {
			if ( fives > 1 ) {
				s += fives + " Fives of ";
			} else {
				s += "1 Five of ";
			}
			s += temperature + " " + super.getName ( ) + "s" + "\n";
		}
		if ( singles > 0 ) {
			if ( singles > 1 ) {
				s += singles + " " + temperature + " " + super.getName ( ) + "s" + "\n";
			} else {
				s += "1 " + temperature + " " + super.getName ( ) + "\n";
			}
		}
		return s;
	}
	
	@Override
	public double getCost() {
		return singles * singlesPrice + fives * fivesPrice;
	}

}
