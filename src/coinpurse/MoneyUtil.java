package coinpurse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/** 
 * Class MoneyUtil create for test coin and BankNote class 
 * @author Atid Srisukhantapuek
 * 
 */
public class MoneyUtil {
	
	/**
	 *  Filter value by currency of value
	 *  @param value that user want to filter
	 *  @return list of coin with same currency
	 */
	public static <E extends Valuable>List<E> filterByCurrency(List<E>coins,String Currency){
		List<E> temp = new ArrayList<E>();
		
		for(E val: coins) {
			if(val.getCurrency().equals(Currency)) {
				temp.add(val);
			}
			
		}
		return temp;
	}
	
	/**
	 * Print all Valuable that in list
	 * @param list of Valuable that user want to print
	 */
	public static void printCoins(List<? extends Valuable> val){
	
			System.out.println(val.toString());
	
	}
	
	/**
	 * Sort coin by minimum value to maximum value
	 * and print coin
	 * @param coins
	 * 
	 */
	public static void sortCoins(List<? extends Valuable> coins) {
		Comparator<Valuable> comp = new ValueComparator();
		
		Collections.sort(coins,comp);
		
		printCoins(coins);
	}
	
	/** 
	 * Return the larger argument, based on sort order, using  
	 * the objects' own compareTo method for comparing. 
	 * @param args one or more Comparable objects to compare. 
	 * @return the argument that would be last if sorted the elements. 
	 * @throws IllegalArgumentException if no arguments given. 
	 */ 
	public static <E extends Comparable<? super E>> E max(E ... args) {
		
		if(args == null) {
			throw new IllegalArgumentException("No arguments given");
		}
		
		E max = args[0];
		for(int i = 0; i < args.length; i++) {
			if(max.compareTo(args[i]) < 1) {
				max = args[i];

			}
		}	
		return max;    
	}
	
	
//	public static void main(String[] args) {
//
//		List<Valuable> coins = new ArrayList<Valuable>();
//		coins.add(new Coin(10.0,"Baht"));
//		coins.add(new BankNote(787878, "Baht"));
//		coins.add(new Coin(2.0, "Baht"));
//		coins.add(new BankNote(44000, "Dollar"));
//		coins.add(new Coin(50, "Dollar"));
//		coins.add(new Coin(8.7, "Dollar"));
//		coins.add(new BankNote(47514854, "Baht"));
//		coins.add(new Coin(4.3, "Baht"));
//		coins.add(new BankNote(44000, "eC"));
//		coins.add(new Coin(50, "fcE"));
//		coins.add(new Coin(8.7, "ageD"));
//		coins.add(new BankNote(47514854, "F"));
//		coins.add(new Coin(4.3, "Gagev"));
//		System.out.println("////////////unsorted///////////////////////////");
//
//		printCoins(coins);
//		System.out.println("////////////////sorted////////////////////////");
//		sortCoins(coins);
//		System.out.println("//////////////////////////////////////////////");
//
//		System.out.println(filterByCurrency(coins, "Baht"));
//		System.out.println(filterByCurrency(coins, "Dollar"));
//
//		 Money m1 = new BankNote(100, "Baht", 5555555);
//		 Money m2 = new BankNote(500, "Baht", 1111111);
//		 Money m3 = new Coin(20, "Baht");
//		 Money max = MoneyUtil.max( m1, m2, m3 );
//		 System.out.println(max.toString());
//	}
	

	
}
