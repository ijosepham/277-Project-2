import java.util.ArrayList;

public class CashRegister extends ArrayList < Object > {
	private double subtotal = 0;
	private double tax = 0;
	private double balance = 0;
	private int drinkAm = 0;
	private double drinkPr = 0;
	private int dessertAm = 0;
	private double dessertPr = 0;
	
	public CashRegister ( ) {
		super ( );
	}
	
	public int orderSize ( ) {
		return super.size ( );
	}
	
	public Object addOrder ( Object order ) {
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
		tax = subtotal * .1025;
		balance = subtotal + tax;
		return order;
	}
	
	public Object getOrder ( int index ) {
		return super.get ( index );
	}
	
	public double getSubtotal ( ) {
		return subtotal;
	}
	
	public double getTax ( ) {
		return tax;
	}
	
	public double getBalance  ( ) {
		return balance;
	}
	
	public void printReceipt ( ) {
		System.out.println ( "\n" + "Order Receipt" );
		if ( drinkAm > 0 ) {
			System.out.printf ( drinkAm + " x Drink Item - $" + "%.2f" + "\n", drinkPr );
		}
		if ( dessertAm > 0 ) {
			System.out.printf ( dessertAm + " x Dessert Item - $" + "%.2f" + "\n", dessertPr );
		}
		System.out.printf ( "\n" + "Subtotal: $" + "%.2f", subtotal );
		System.out.printf ( "\n" + "Tax:      $" + "%.2f", tax );
		System.out.printf ( "\n" + "Balance:  $" + "%.2f" + "\n" + "\n", balance );
	}
	
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
