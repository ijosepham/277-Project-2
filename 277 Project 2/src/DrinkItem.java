
public abstract class DrinkItem implements Comparable < DrinkItem > {
	/**
	 * name of the drink item
	 */
	private String name;
	
	/**
	 * sweetness oft he drink item
	 */
	private String sweetness;
	
	/**
	 * size of the drink
	 */
	private String size;
	
	/**
	 * default constructor
	 */
	public DrinkItem ( ) {
		name = "";
		sweetness = "Full Sweetness";
		size = "Medium";
	}
	
	/**
	 * overloaded cosntructor
	 * @param n - name of the drink
	 * @param sw - sweetness of the drink
	 * @param sz - size of the drink
	 */
	public DrinkItem ( String n, String sw, String sz ) {
		name = n;
		sweetness = sw;
		size = sz;
	}
	
	/**
	 * @desc sets the name of the drink
	 * @param n - name of the drink
	 */
	public void setName ( String n ) {
		name = n;
	}
	
	/**
	 * @desc sets the sweetness of teh drink
	 * @param sw - sweetness of the drink
	 */
	public void setSweetness ( String sw ) {
		sweetness = sw;
	}
	
	/**
	 * @desc sets teh size of the drink
	 * @param sz - size
	 */
	public void setSize ( String sz ) {
		size = sz;
	}
	
	/**
	 * @desc gets and returns the name of the string
	 * @return string - name of the drink
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * @desc gets and returns the sweetness of the drink
	 * @return string - sweetness oft he drink
	 */
	public String getSweetness ( ) {
		return sweetness;
	}

	/**
	 * @desc gets and returns the size of the drink
	 * @return string - size of the drink
	 */
	public String getSize ( ) {
		return size;
	}
	
	/**
	 * @desc displays teh order of the drink
	 * @return string - order of drink item
	 */
	public String toString ( ) {
		return size + " " + name +  ", " + sweetness;
	}
	
	/**
	 * @desc calcualtes and returnst e cost of the order
	 * @return double - cost of the order
	 */
	public abstract double getCost ( );
}
