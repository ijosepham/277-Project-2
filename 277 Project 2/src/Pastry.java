
public class Pastry extends DessertItem {
	private int quantity;
	private int singles;
	private int fives;
	private double singlePrice = 1.00;
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
		if ( quantity > 1 ) {
			return quantity + " " + temperature + " " + super.getName ( );
		} else {
			return "1 " + temperature + " " + super.getName ( );
		}
	}
	
	@Override
	public double getCost() {
		return singles * singlePrice + fives * fivesPrice;
	}

}
