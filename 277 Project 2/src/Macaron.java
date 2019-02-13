
public class Macaron extends DessertItem {
	private int quantity;
	private double price = 1.00;
	private double trioPrice = 2.50;
	
	public Macaron ( ) {
		quantity = 1;
		price = 1.25;
	}
	
	public Macaron ( int q ) {
		quantity = q;
	}
	
	public String toString ( ) {
		if ( quantity > 1 ) {
			return quantity + " Macarons";
		} else {
			return quantity + " Macaron";
		}
	}
	
	@Override
	public double getCost() {
		double cost = 0;
		int threes = quantity / 3;
		int singles = quantity % 3;
		cost = singles * price + threes * trioPrice;
		return cost;
	}

}
