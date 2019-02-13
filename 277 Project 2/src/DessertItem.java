
public abstract class DessertItem {
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
		String s = name;
		return s;
	}
	
	public abstract double getCost ( );
}
