
public class CoffeeDrink extends DrinkItem {
	private String base;
	
	public CoffeeDrink ( ) {
		super ( );
	}
	
	public CoffeeDrink ( String sw, String sz, String b ) {
		super ( "Coffee", sw, sz ); 
		base = b;
	}
	
	public void setBase ( String b ) {
		base = b;
	}
	
	public String getBase ( ) {
		return base;
	}
	
	public String toString ( ) {
		 String s = super.getSize ( ) + " " + super.getName ( ) + "\n";
		 s += " -" + super.getSweetness ( ) + "\n";
		 s += " -" + base + " Based" + "\n";
		 return s;
	}
	
	@Override
	public double getCost ( ) {
		if ( super.getSize( ) == "Small" ) {
			return 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			return 3.50;
		} else {
			return 4.00;
		} 
	}

	@Override
	public int compareTo(DrinkItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
