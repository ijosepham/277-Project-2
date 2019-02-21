
public abstract class DessertItem implements Comparable <DessertItem > {
	private String name;
	
	public DessertItem ( ) {
		name = "";
	}
	
	public DessertItem ( String n ) {
		name = n;
	}
	
	public void setName ( String n ) {
		name = n;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public String toString ( ) {
		return name;
	}
	
	public static double max ( DessertItem d1, DessertItem d2 ) {
		double difference = d1.getCost ( ) - d2.getCost ( );
		return difference;
	}
	
	public abstract double getCost ( );
	public abstract int getQuantity ( );
}
