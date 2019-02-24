
public abstract class DessertItem extends MenuItem {
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
	
<<<<<<< HEAD
=======
	/**
	 * @desc returns the difference between the cost of two dessert items
	 * @param d1 - first dessert
	 * @param d2 - second dessert
	 * @return double - difference of two dessert prices
	 * 					returns positive, if the first one costs more
	 * 					returns negative, if the second one costs more
	 */
	public static double max ( DessertItem d1, DessertItem d2 ) {
		double difference = d1.getCost ( ) - d2.getCost ( );
		return difference;
	}
	
	/**
	 * @desc get cost of the dessert
	 * @return double - cost of the 
	 */
>>>>>>> parent of a3eeea0... updated the max() fucntion so it returns the order isntead of an int
	public abstract double getCost ( );
}
