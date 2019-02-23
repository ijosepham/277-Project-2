import java.util.ArrayList;

public class BobaDrink extends DrinkItem {
	private ArrayList < String > toppings;
	private String milk; // 
	
	public BobaDrink ( ) {
		super ( );
		toppings = new ArrayList < String > ( );
		milk = "";
	}
	
	public BobaDrink ( String n, String sw, String m, ArrayList < String > t, String sz ) {
		super ( n, sw, sz );
		toppings = t;
		milk = m;
	}
	
	public void setToppings ( ArrayList < String > t ) {
		toppings = t;
	}
	
	public void setMilk ( String m ) {
		milk = m;
	}
	
	public ArrayList < String > getToppings ( ) {
		return toppings;
	}
	
	public String getMilk ( ) {
		return milk;
	}
	
	public String toString ( ) {
		 String s = super.getSize ( ) + " " + super.getName ( ) + "\n";
		 s += " -" + super.getSweetness ( ) + "\n";
		 s += " -" + milk + "\n";
		 if ( toppings.size ( ) == 0 ) {
			 s += " -No Toppings" + "\n";
		 } else {
			 s += " -" + toppings.size ( ) + " Toppings" + "\n";
			 for ( int i = 0; i < toppings.size ( ); i ++ ) {
				 s += "   -" + toppings.get ( i ) + "\n";
			 }
		 }
		 return s;
	}
	
	@Override
	public double getCost() {
		double cost = 0;
		cost += toppings.size ( ) * 0.50;
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
	public int compareTo(DrinkItem o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
