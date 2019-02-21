import java.util.ArrayList;

public class BobaDrink extends DrinkItem {
	private ArrayList < String > toppings;
	private String milk;
	
	public BobaDrink ( ) {
		super ( );
		toppings = new ArrayList < String > ( );
		milk = "";
	}
	
	public BobaDrink ( String n, String sw, String m, ArrayList < String > t, String sz ) {
		super ( n, sw, sz );
		toppings = t;
		milk = m;
	}
	
//	public String toString ( ) {
//		return super.getSize ( ) + " " + topping + " " + super.getName( ) + " with " + milk;
//	}
	
	@Override
	public double getCost() {
		double cost = 0;
		cost += toppings.size ( ) * 0.50;
		if ( super.getSize( ) == "Small" ) {
			cost += 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			cost += 3.50;
		} else {
			cost += 4.00;
		} 
		return cost;
	}
}
