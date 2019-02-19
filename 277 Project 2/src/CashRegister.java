import java.util.ArrayList;

public class CashRegister extends ArrayList < Object > {
	
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
	
	public double calculateBalance ( ) {
		int orderSize = orderSize ( );
		double balance = 0;
		Object o = null;
		
		for ( int i = 0; i < orderSize; i ++ ) {
			o = getOrder ( i );
			if ( o instanceof DrinkItem ) {
				DrinkItem d = ( DrinkItem ) o;
				balance += d.getCost ( );
			} else if ( o instanceof DessertItem ) {
				DessertItem d = ( DessertItem ) o;
				balance += d.getCost ( );
			}
		}
		
		balance *= 1.1025;
		return balance;
	}
	
	public void printReceipt ( ) {
		int orderSize = orderSize ( );
		Object order = null;
		double price = 0;
		System.out.println ( "\n" + "Order Receipt" );
		for ( int i = 0; i < orderSize; i ++ ) {
			
			order = getOrder ( i );
			if ( order instanceof DrinkItem ) {
				DrinkItem d = ( DrinkItem ) order;
				price = d.getCost ( );
			} else if ( order instanceof DessertItem ) {
				DessertItem d = ( DessertItem ) order;
				price = d.getCost ( );
			}
			
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
