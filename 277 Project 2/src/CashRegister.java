import java.util.ArrayList;

public class CashRegister extends ArrayList < Object > {
	/**
	 * subtotal of the sale 
	 */
	private double subtotal = 0;
	
	/**
	 * tax of the sale
	 */
	private double tax = 0;
	
	/**
	 * total balance oft he sale
	 */
	private double balance = 0;
	
	/**
	 * amount of drinks in teh sale
	 */
	private int drinkAm = 0;
	
	/**
	 * total price of all the drinks in the sale
	 */
	private double drinkPr = 0;
	
	/**
	 * total amouint of desserts
	 */
	private int dessertAm = 0;
	
	/**
	 * total price of desserts
	 */
	private double dessertPr = 0;
	
	/**
	 * default constructor
	 */
	public CashRegister ( ) {
		super ( );
	}
	
	/**
	 * @desc gets and retusn the amount of orders in the sale
	 * @return int - size of the sale
	 */
	public int orderSize ( ) {
		return super.size ( );
	}
	
	/**
	 * @desc adds the order into the cash register, increases dessert/drink ammounts and prices
	 * @param order - drink/dessert item
	 */
	public void addOrder ( Object order ) {
		super.add ( order );
		if ( order instanceof DrinkItem ) {
			DrinkItem d = ( DrinkItem ) order;
			drinkAm ++;
			drinkPr += d.getCost ( );
			subtotal += d.getCost ( );
		} else if ( order instanceof DessertItem ) {
			DessertItem d = ( DessertItem ) order;
			dessertAm += d.getQuantity ( );	
			dessertPr += d.getCost ( );
			subtotal += d.getCost ( );
		}
		tax = subtotal * .10;
		balance = subtotal + tax;
	}
	
	/**
	 * @desc gets the order at the given index
	 * @return order
	 */
	public Object getOrder ( int index ) {
		return super.get ( index );
	}
	
	/**
	 * @desc applies a coupon to a drink, and updates the cost of that item and change the subtotal
	 * @param c coupon to apply
	 */
	public void applyCoupon ( Coupon c ) {
		double discount = 0;
		if ( c.getItemType ( ).equalsIgnoreCase ( "Drink" ) ) {
			if ( drinkAm > 0 ) {
				BobaDrink maxBoba = new BobaDrink ( ); // keeps track of highest boba drink
				maxBoba.setCost( 0 ); // sets its cost to 0 so it grabs the first one instead
				CoffeeDrink maxCoffee = new CoffeeDrink ( );
				maxCoffee.setCost( 0 );
				for ( int i = 0; i < orderSize ( ); i ++ ) { // this gets the highest priced drink in the order
					if ( getOrder ( i ) instanceof DrinkItem ) {
						DrinkItem order = ( DrinkItem ) getOrder ( i );
						if ( order instanceof BobaDrink ) {
							maxBoba = (BobaDrink) DrinkItem.max ( order, maxBoba ); 
						} else {
							maxCoffee = (CoffeeDrink) DrinkItem.max ( order, maxCoffee );
						}
						
					}
				}
				DrinkItem maxDrink = DrinkItem.max ( maxBoba, maxCoffee ); // gets the higher of the two
				discount = maxDrink.getCost ( ) * c.getDiscount ( ); // gets the amount discounted
				drinkPr -= discount;
				if ( maxDrink instanceof BobaDrink ) {
					BobaDrink b = ( BobaDrink ) maxDrink; // makes drink item into boba/coffee
					b.setCost ( maxDrink.getCost ( ) * ( 1 - c.getDiscount ( ) ) ); // reduces the cost of the item
					set ( indexOf ( maxDrink ), b ); // update it in the cash register
					
				} else {
					CoffeeDrink cf = ( CoffeeDrink ) maxDrink;
					cf.setCost( maxDrink.getCost ( ) * ( 1 - c.getDiscount ( ) ) );
					set ( indexOf ( maxDrink ), cf );
					
				}
			}
		} else if ( c.getItemType ( ).equalsIgnoreCase ( "Dessert" ) ) {
			Pastry maxPastry = new Pastry ( ); // keeps track of highest boba drink
			maxPastry.setCost( 0 ); // sets its cost to 0 so it grabs the first one instead
			Cookie maxCookie = new Cookie( );
			maxCookie.setCost( 0 );
			Macaron maxMac = new Macaron ( );
			maxMac.setCost ( 0 );
			for ( int i = 0; i < orderSize ( ); i ++ ) {
				if ( getOrder ( i ) instanceof DessertItem ) {
					DessertItem order = ( DessertItem ) getOrder ( i );
					if ( order instanceof Pastry ) {
						maxPastry = (Pastry) DessertItem.max ( order, maxPastry ); 
					} else if ( order instanceof Cookie ){
						maxCookie = (Cookie) DessertItem.max ( order, maxCookie );
					} else {
						maxMac = (Macaron) DessertItem.max ( order, maxMac );
					}
				}
			}
			DessertItem max = DessertItem.max ( maxPastry, maxCookie );
			max = DessertItem.max ( max, maxMac );
			discount = max.getCost ( ) * c.getDiscount ( );
			dessertPr -= discount;
			if ( max instanceof Cookie ) {
				Cookie co = ( Cookie ) max;
				if ( co instanceof Macaron ) {
					Macaron m = ( Macaron ) co;
					m.setCost ( max.getCost ( ) * ( 1 - c.getDiscount ( ) ) );
					set ( indexOf ( max ), m );
				} else {
					co.setCost ( max.getCost ( ) * ( 1 - c.getDiscount ( ) ) );
					set ( indexOf ( max ), co );
				}
			} else {
				Pastry p = ( Pastry ) max;
				p.setCost( max.getCost ( ) * ( 1 - c.getDiscount ( ) ) );
				set ( indexOf ( max ), p );
			}
		}
		subtotal -= discount;
		tax = subtotal * .10;
		balance = subtotal * 1.10;
	}
	
	/**
	 * @desc gets and returns the tax
	 * @return double - tax
	 */
	public double getSubtotal ( ) {
		return subtotal;
	}
	
	/**
	 * @desc gets and returns the subtotal
	 * @return double - subtotal
	 */
	public double getTax ( ) {
		return tax;
	}
	
	/**
	 * @desc gets and returns the balance
	 * @return double - balance
	 */
	public double getBalance  ( ) {
		return balance;
	}
	
	/**
	 * @desc prints out all the orders for the sale
	 */
	public void printReceipt ( ) {
		System.out.println ( "\n" + "Order Receipt" );
		if ( drinkAm > 0 ) {
			System.out.printf ( drinkAm + " x Drink Item - $" + "%.2f" + "\n", drinkPr );
		}		if ( dessertAm > 0 ) {
			System.out.printf ( dessertAm + " x Dessert Item - $" + "%.2f" + "\n", dessertPr );
		}
		System.out.printf ( "\n" + "Subtotal: $" + "%.2f", subtotal );
		System.out.printf ( "\n" + "Tax:      $" + "%.2f", tax );
		System.out.printf ( "\n" + "Balance:  $" + "%.2f" + "\n" + "\n", balance );
	}
	
	/**
	 * @desc returns a short version of the sale
	 * @return string - shortneed sale
	 */
	public String getSale ( ) {
		String s = "";
		if ( drinkAm > 0 ) {
			s += String.format ( drinkAm + " x Drink Item - $" + "%.2f" + "\n", drinkPr );
		}
		if ( dessertAm > 0 ) {
			 s += String.format ( dessertAm + " x Dessert Item - $" + "%.2f" + "\n", dessertPr );
		}
		s += String.format ( "Total:  $" + "%.2f", balance );
		return s;
	}
	
	/**
	 * @desc clears all items from the register and resets the instances
	 */
	public void clearRegister ( ) {
		int orderSize = orderSize ( );
		for ( int i = 0; i < orderSize; i ++ ) {
			super.remove ( 0 );
		}
		subtotal = 0;
		tax = 0;
		balance = 0;
		drinkAm = 0;
		drinkPr = 0;
		dessertAm = 0;
		dessertPr = 0;
	}
}
