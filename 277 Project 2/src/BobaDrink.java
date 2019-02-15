
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
		return super.getSize ( ) + " " + topping + " " + super.getName( ) + " with " + milk;
	}
	
	@Override
	public double getCost() {
		return 0.00;
	}

}
