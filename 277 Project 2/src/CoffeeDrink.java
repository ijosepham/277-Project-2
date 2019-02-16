
public class CoffeeDrink extends DrinkItem {
	private String base;
	private int quantity;
	
	public CoffeeDrink ( ) {
		super ( );
		quantity = 1;
	}
	
	public CoffeeDrink ( String sw, String sz, String b, int q ) {
		super ( "Coffee", sw, sz );
		quantity = q;
		base = b;
	}
	
	public String toString ( ) {
		return quantity + " x " + super.getSize ( ) + " " + base + " based Coffee with " + super.getSweetness ( ) + " of Sugar";
	}
	
	@Override
	public double getCost ( ) {
		double cost = 0;
		if ( super.getSize( ) == "Small" ) {
			cost += 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			cost += 3.50;
		} else {
			cost += 4.00;
		} 
		cost *= quantity;
		return cost;
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
