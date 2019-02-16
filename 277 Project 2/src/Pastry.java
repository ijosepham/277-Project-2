
public class Pastry extends DessertItem {
	private int quantity;
	private int singles;
	private int fives;
	private double singlesPrice = 1.00;
	private double fivesPrice = 4.00;
	private String temperature;
	
	public Pastry ( ) {
		super ( "Pastry" );
		quantity = 1;
		temperature = "Warm";
	}
	
	public Pastry ( String p, int q, String t ) {
		super ( p );
		quantity = q;
		singles = quantity % 5;
		fives = quantity / 5;
		temperature = t;
	}
	
	public void setQuantity ( int q ) {
		quantity = q;
		singles = quantity % 5;
		fives = quantity / 5;
	}
	
	public String toString ( ) {
		String s = "";
		if ( fives > 0 ) {
			s += fives + " x Five " + temperature + " " + super.getName ( ) + "s";
		}
		if ( singles > 0 ) {
			s += singles + " x " + temperature + " " + super.getName ( );
		}
		return s;
	}
	
	public double getSinglesCost ( ) {
		return  singles * singlesPrice;
	}
	
	public double getFivesCost ( ) {
		return fives * fivesPrice;
	}
	
	@Override
	public double getCost ( ) {
		return singles * singlesPrice + fives * fivesPrice;
	}

	@Override
	public void incrementQuantity ( ) {
		quantity += 1;
		singles = quantity % 5;
		fives = quantity / 5;
		
	}

	@Override
	public boolean equals ( MenuItem m ) {
		if ( m instanceof Pastry ) {
			Pastry p = ( Pastry ) m;
			if ( this.getName ( ) == p.getName ( ) ) {
				if ( this.temperature == p.temperature ) {
					return true;
				}
			}
		}
		return false;
	}
}
