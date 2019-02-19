
public class CoffeeDrink extends DrinkItem {
	private String base;
	
	public CoffeeDrink ( ) {
		super ( );
	}
	
	public CoffeeDrink ( String sw, String sz, String b, int q ) {
		super ( "Coffee", sw, sz );
		base = b;
	}
	
	public String toString ( ) {
		return super.getSize ( ) + " " + base + " based Coffee with " + super.getSweetness ( ) + " of Sugar";
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

	public boolean equals ( Object o ) {
		if ( o instanceof CoffeeDrink ) {
			CoffeeDrink b = ( CoffeeDrink ) o;
			if ( this.getSweetness ( ) == b.getSweetness ( ) ) {
				if ( this.getSize ( ) == b.getSize ( ) ) {
					if ( this.getName ( ) == b.getName ( ) ) {
						if ( this.base == b.base ) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}
