
public class BobaDrink extends DrinkItem {
	private String topping;
	private String milk;
	
	public BobaDrink ( ) {
		super ( );
		topping = "";
		milk = "";
	}
	
	public BobaDrink ( String n, String sw, String m, String t, String sz ) {
		super ( n, sw, sz );
		topping = t;
		milk = m;
	}
	
	public String toString ( ) {
		return super.toString ( ) + " with " + topping + " and " + milk;
	}
	
	@Override
	public double getCost() {
		return 0;
	}

}
