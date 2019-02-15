import java.util.ArrayList;

public class CashRegister extends ArrayList < MenuItem > {
	
	public CashRegister ( ) {
		super ( );
	}
	
	public int orderSize ( ) {
		return super.size ( );
	}
	
	public MenuItem addOrder ( MenuItem order ) {
		super.add ( order );
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
		
		return balance;
	}
	
	public void printReceipt ( ) {
		int orderSize = orderSize ( );
		MenuItem order = null;
		double price = 0;
		System.out.println ( "Order Receipt" );
		for ( int i = 0; i < orderSize; i ++ ) {
			order = getOrder ( i );
			price = order.getCost ( );
			System.out.printf ( order + "   $" + "%.2f" + "\n", price );
		}
	}
	
	public void clearRegister ( ) {
		int orderSize = orderSize ( );
		for ( int i = 0; i < orderSize; i ++ ) {
			removeOrder ( );
		}
	}
}
