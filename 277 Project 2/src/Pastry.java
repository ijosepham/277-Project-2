
public class Pastry extends DessertItem {
	private int quantity;
	private double price = 1.00;
	private String temperature;
	
	public Pastry ( ) {
		super ( "Pastry" );
		quantity = 1;
		temperature = "Warm";
	}
	
	public Pastry ( String p, int q, String t ) {
		super ( p );
		quantity = q;
		temperature = t;
	}
	
	public String toString ( ) {
		if ( quantity > 1 ) {
			return quantity + " " + temperature + " Pastries";
		} else {
			return "1 " + temperature + " Pastry";
		}
		
	}
	
	@Override
	public double getCost() {
		return quantity * price;
	}

}
