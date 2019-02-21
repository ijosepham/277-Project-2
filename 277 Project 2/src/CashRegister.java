import java.util.ArrayList;

public class CashRegister extends ArrayList < Object > {
	private double balance;
	
	public CashRegister ( ) {
		super ( );
	}
	
	public int orderSize ( ) {
		return super.size ( );
	}
	
	public Object addOrder ( Object order ) {
		super.add ( order );
		return order;
	}
	
	public Object getOrder ( int index ) {
		return super.get ( index );
	}
	
	public Object removeOrder ( ) {
		return super.remove ( 0 );
	}
	
	public Object removeOrder ( int index ) {
		return super.remove ( index );
	}
	
	public Object removeOrder ( Object order ) {
		super.remove ( order );
		return order;
	}
	
	public double calculateTax ( double subtotal ) {
		double tax = subtotal * .1025;
		return tax;
	}
	
	public double calculateSubtotal ( ) {
		int orderSize = orderSize ( );
		double subtotal = 0;
		Object o = null;
		
		for ( int i = 0; i < orderSize; i ++ ) {
			o = getOrder ( i );
			if ( o instanceof DrinkItem ) {
				DrinkItem d = ( DrinkItem ) o;
				subtotal += d.getCost ( );
			} else if ( o instanceof DessertItem ) {
				DessertItem d = ( DessertItem ) o;
				subtotal += d.getCost ( );
			}
		}
		return subtotal;
	}
	
	public double calculateBalance ( double subtotal ) {
		balance = subtotal * 1.1025;
		return balance;
	}
	
	public double getBalance  ( ) {
		return balance;
	}
	
	public void printReceipt ( ) {
		int orderSize = orderSize ( );
		Object order = null;
		int drinksAm = 0;
		int dessertsAm = 0;
		double drinksPr = 0;
		double dessertsPr = 0;
		System.out.println ( "\n" + "Order Receipt" );
		for ( int i = 0; i < orderSize; i ++ ) {
			order = getOrder ( i );
			if ( order instanceof DrinkItem ) {
				drinksAm ++;
				drinksPr +=  ( ( DrinkItem ) order ).getCost ( );
			} else if ( order instanceof DessertItem ) {
				dessertsAm += ( ( DessertItem ) order ).getQuantity ( );
				dessertsPr +=  ( ( DessertItem ) order ).getCost ( );
			}
		}
		if ( drinksAm > 0 ) {
			System.out.printf ( drinksAm + " x Drink Item - $" + "%.2f" + "\n", drinksPr );
		}
		if ( dessertsAm > 0 ) {
			System.out.printf ( dessertsAm + " x Dessert Item - $" + "%.2f", dessertsPr );
		}
		double subtotal = calculateSubtotal ( );
		double tax = calculateTax ( subtotal );
		balance = calculateBalance ( subtotal );
		System.out.printf ( "\n" + "\n" + "Subtotal: $" + "%.2f", subtotal );
		System.out.printf ( "\n" + "Tax:      $" + "%.2f", tax );
		System.out.printf ( "\n" + "Balance:  $" + "%.2f" + "\n" + "\n", balance );
	}
	
	public void clearRegister ( ) {
		int orderSize = orderSize ( );
		for ( int i = 0; i < orderSize; i ++ ) {
			removeOrder ( );
		}
	}
}
