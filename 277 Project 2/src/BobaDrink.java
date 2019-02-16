
public class BobaDrink extends DrinkItem {
	private String topping;
	private int quantity;
	private String milk;
	
	public BobaDrink ( ) {
		super ( );
		topping = "";
		milk = "";
		quantity = 1;
	}
	
	public BobaDrink ( String n, String sw, String m, String t, String sz, int q ) {
		super ( n, sw, sz );
		topping = t;
		milk = m;
		quantity = q;
	}
	
	public String toString ( ) {
		return quantity + " x " + super.getSize ( ) + " " + topping + " " + super.getName( ) + " with " + milk;
	}
	
	@Override
	public double getCost() {
		int cost = 0;
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
		cost *= quantity;
		return cost;
	}

	@Override
	public void combineOrders ( int q ) {
		quantity += q;
		
	}
	
	@Override
	public boolean equals ( MenuItem m ) {
		if ( m instanceof BobaDrink ) {
			BobaDrink b = ( BobaDrink ) m;
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

	@Override
	public int getQuantity() {
		return quantity;
	}
}
