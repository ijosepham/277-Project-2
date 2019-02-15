
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
		if ( super.getSize( ) == "Small" ) {
			return 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			return 3.50;
		} else {
			return 4.00;
		} 
	}

}
