
public abstract class DrinkItem {
	private String name;
	private int sweetness;
	private String size;
	
	public DrinkItem ( ) {
		name = "";
		sweetness = 100;
		size = "Medium";
	}
	
	public DrinkItem ( String n, int sw, String sz ) {
		name = n;
		sweetness = sw;
		size = sz;
	}
	
	public void setName ( String n ) {
		name = n;
	}
	
	public void setSweetness ( int sw ) {
		sweetness = sw;
	}
	
	public void setSize ( String sz ) {
		size = sz;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public int getSweetness ( ) {
		return sweetness;
	}

	public String getSize ( ) {
		return size;
	}
	
	public String toString ( ) {
		String s = size + " " + name +  ", " + sweetness + "% Sweetness.";
		return s;
	}
	
	public abstract double getCost ( );
}
