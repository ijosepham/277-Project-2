
public class CoffeeDrink extends DrinkItem {
	private String base;
	private int quantity;
	
	public CoffeeDrink ( ) {
		super ( );
		quantity = 1;
	}
	
	public CoffeeDrink ( String sw, String sz, String b ) {
		super ( "Coffee", sw, sz );
		quantity = 1;
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

	@Override
	public void incrementQuantity ( ) {
		quantity += 1;
		
	}

	public boolean equals ( MenuItem m ) {
		if ( m instanceof CoffeeDrink ) {
			CoffeeDrink b = ( CoffeeDrink ) m;
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
