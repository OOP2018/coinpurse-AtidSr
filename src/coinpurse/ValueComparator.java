package coinpurse;

import java.util.Comparator;

public class ValueComparator implements Comparator<Valuable>{

	/**
	 * Compare two objects that implement Valuable.
	 * First compare them by currency, so that "Baht" < "Dollar".
	 *  If both objects have the same currency, order them by value.
	 */
	
	
	public int compare(Valuable a, Valuable b) {
		
		if(a.getCurrency().equalsIgnoreCase("Dollar") && b.getCurrency().equalsIgnoreCase("Baht")){
			return 1;
		} else if(a.getCurrency().equalsIgnoreCase(b.getCurrency())){
			return 0;
		}else {
			return -1;
		}
			
		
	}
	
	
}
