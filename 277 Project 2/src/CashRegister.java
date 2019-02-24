import java.util.ArrayList;

public class CashRegister extends ArrayList < MenuItem > {
	
	public CashRegister ( ) {
		super ( );
	}
	
	public int orderSize ( ) {
		return super.size ( );
	}
	
	public MenuItem addOrder ( MenuItem order ) {
		boolean added = false;
		for ( int i = 0; i < orderSize ( ); i ++ ) {
			if ( order.equals( getOrder ( i ) ) ) {
				getOrder ( i ).combineOrders ( order.getQuantity ( ) );
				added = true;
			}
		}
		if ( ! added ) {
			super.add ( order );
		}
		return order;
	}
	
	public MenuItem getOrder ( int index ) {
		return super.get ( index );
	}
	
	public MenuItem removeOrder ( ) {
		return super.remove ( 0 );
	}
	
	public MenuItem removeOrder ( int index ) {
		return super.remove ( index );
	}
	
	public MenuItem removeOrder ( MenuItem order ) {
		super.remove ( order );
		return order;
	}
	
	public double calculateBalance ( ) {
		int orderSize = orderSize ( );
		double balance = 0;
		
		for ( int i = 0; i < orderSize; i ++ ) {
			balance += getOrder ( i ).getCost ( );
		}
		
		balance *= 1.1025;
		
		return balance;
	}
	/**
	 * first iterate through to look for drinks/desserts in general
	 * if one doesnt exist, just skip it.
	 * if desserts exist, loop through to check for instances of 
	 * 		pastries, cookies, macarons. then check the quantity of that instance
	 * keep track of each instance
	 * then print out the amount of instances with the prices, seaprating into 
	 */
	public void printReceiptt ( ) {
		MenuItem order = null;
		for ( int i = 0; i < orderSize ( ); i ++ ) {
			order = getOrder ( i );
			quantity = order.getQuantity ( );
			if ( order instanceof DessertItem ) {
				if ( order instanceof Pastry ) {
					pQuantity += quantity;
				} else if ( order instanceof Cookie ) {
					cQuantity += quantity;
				} else if ( order instanceof Macaron ) {
					mQuantity += quantity;
				}
			}
		}
	}
	
	public void printReceipt ( ) {
		int orderSize = orderSize ( );
		MenuItem order = null;
		double price = 0;
		System.out.println ( "\n" + "Order Receipt" );
		for ( int i = 0; i < orderSize; i ++ ) {
			order = getOrder ( i );
			price = order.getCost ( );
			System.out.printf ( order + "   $" + "%.2f" + "\n", price );
		}
		System.out.printf ( "\n" + "Balance: $" + "%.2f" + "\n" + "\n", calculateBalance ( ) );
	}
	
	public void clearRegister ( ) {
		int orderSize = orderSize ( );
		for ( int i = 0; i < orderSize; i ++ ) {
			removeOrder ( );
		}
	}
}
