
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
	
	public int getQuantity ( ) {
		return quantity;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
	}
	
	public String toString ( ) {
		String s = quantity + " x " + temperature + " " + super.getName ( ) + "\n";
		return s;
	}
	
	@Override
	public double getCost ( ) {
		return quantity * price;
	}

	@Override
	public int compareTo(DessertItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
