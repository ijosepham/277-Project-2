
public abstract class DrinkItem extends MenuItem {
	private String name;
	private String sweetness;
	private String size;
	
	public DrinkItem ( ) {
		name = "";
		sweetness = "Full Sweetness";
		size = "Medium";
	}
	
	public DrinkItem ( String n, String sw, String sz ) {
		name = n;
		sweetness = sw;
		size = sz;
	}
	
	public void setName ( String n ) {
		name = n;
	}
	
	public void setSweetness ( String sw ) {
		sweetness = sw;
	}
	
	public void setSize ( String sz ) {
		size = sz;
	}
	
	public String getName ( ) {
		return name;
	}
	
	public String getSweetness ( ) {
		return sweetness;
	}

	public String getSize ( ) {
		return size;
	}
	
	public String toString ( ) {
		return size + " " + name +  ", " + sweetness;
	}
	
<<<<<<< HEAD
=======
	/**
	 * @desc calcualtes and returnst e cost of the order
	 * @return double - cost of the order
	 */
>>>>>>> parent of a3eeea0... updated the max() fucntion so it returns the order isntead of an int
	public abstract double getCost ( );
}
