
public abstract class DessertItem implements Comparable <DessertItem > {
	/**
	 * name of the desert item
	 */
	private String name;
	
	/**
	 * default constructor
	 */
	public DessertItem ( ) {
		name = "";
	}
	
	/**
	 * overlaoded constructor
	 * @param n - name of the dessert
	 */
	public DessertItem ( String n ) {
		name = n;
	}
	
	/**
	 * @desc sets the name of the dessert
	 * @param n - name
	 */
	public void setName ( String n ) {
		name = n;
	}
	
	/**
	 * @desc gets and returns the name of the dessert
	 * @return string - name of dessert
	 */
	public String getName ( ) {
		return name;
	}
	
	/**
	 * @desc returns the name of the dessert
	 */
	public String toString ( ) {
		return name;
	}
	
	/**
	 * @desc returns the difference between the cost of two dessert items
	 * @param d1 - first dessert
	 * @param d2 - second dessert
	 * @return DessertItem - returns the one that costs more, or the first one if theyr e the same
	 */
	public static DessertItem max ( DessertItem d1, DessertItem d2 ) {
		double difference = d1.getCost ( ) - d2.getCost ( );
		if ( difference >= 0 ) {
			return d1;
		} else { 
			return d2;
		}
	}
	
	/**
	 * @desc get cost of the dessert
	 * @return double - cost of the 
	 */
	public abstract double getCost ( );
	
	/**
	 * @desc get quantity of the dessert
	 * @return int - amount of desserts
	 */
	public abstract int getQuantity ( );
}
