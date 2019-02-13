
public class CoffeeDrink extends DrinkItem {
	private String base;
	
	public CoffeeDrink ( ) {
		super ( );
	}
	
	public CoffeeDrink ( String sw, String sz, String b ) {
		super ( "Coffee", sw, sz );
		base = b;
	}
	
	public String toString ( ) {
		return super.getSize ( ) + " " + base + " based Coffee with " + super.getSweetness ( ) + " of Sugar";
	}
	
	@Override
	public double getCost() {
		return 0;
	}

}
