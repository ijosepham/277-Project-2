
public class BobaDrink extends DrinkItem {
	private String topping;
	private String milk;
	
	public BobaDrink ( ) {
		super ( );
		topping = "";
		milk = "";
	}
	
	public BobaDrink ( String n, String sw, String m, String t, String sz, int q ) {
		super ( n, sw, sz );
		topping = t;
		milk = m;
	}
	
	public String toString ( ) {
		return super.getSize ( ) + " " + topping + " " + super.getName( ) + " with " + milk;
	}
	
	@Override
	public double getCost() {
		double cost = 0;
		if ( topping != "None" ) {
			cost += .50;
		}
		if ( super.getSize( ) == "Small" ) {
			cost += 3.00;
		} else if ( super.getSize( ) == "Medium" ) {
			cost += 3.50;
		} else {
			cost += 4.00;
		} 
		return cost;
	}
	
	@Override
	public boolean equals ( Object o ) {
		if (o instanceof BobaDrink ) {
			BobaDrink b = ( BobaDrink ) o;
			if ( this.getSweetness ( ) == b.getSweetness ( ) ) {
				if ( this.getSize ( ) == b.getSize ( ) ) {
					if ( this.getName ( ) == b.getName ( ) ) {
						if ( this.topping == b.topping ) {
							if ( this.milk == b.milk ) {
								return true;
							}
						}
					}
				}
			}
		}
		return false;
	}
}
