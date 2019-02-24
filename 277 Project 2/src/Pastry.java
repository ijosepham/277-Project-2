
public class Pastry extends DessertItem {
	/**
	 * amount of pastries ordered
	 */
	private int quantity;
	
	/**
	 * price of a single pastry
	 */
	private double price = 1.00;
	
	/**
	 * temperature of the pastry
	 */
	private String temperature;
	
	/**
	 * default constructor
	 */
	public Pastry ( ) {
		super ( "Pastry" );
		quantity = 1;
		temperature = "Warm";
	}
	
	/**
	 * overloaded constructor
	 * @param p - name of the pastry
	 * @param q - amount of pastries
	 * @param t - temp of pastry
	 */
	public Pastry ( String p, int q, String t ) {
		super ( p );
		quantity = q;
		temperature = t;
	}
	
	/**
	 * @desc returns the quantity of pastries
	 * @return int - quantity of pastries
	 */
	public int getQuantity ( ) {
		return quantity;
	}
	
	/**
	 * @desc sets quantity of pastries
	 * @param q - quantity of pastries
	 */
	public void setQuantity ( int q ) {
		quantity = q;
	}
	
	/**
	 * @desc returns the order of pasrties
	 * @return string - order
	 */
	public String toString ( ) {
		String s = quantity + " x " + temperature + " " + super.getName ( ) + "\n";
		return s;
	}
	
	/**
	 * @desc calculates and returns the cost of the pastry
	 * @return double - cost
	 */
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
