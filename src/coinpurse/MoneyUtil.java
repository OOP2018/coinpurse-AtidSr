package coinpurse;

import java.util.ArrayList;
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
	public static List<Valuable> filterByCurrency(List<Valuable>coins,String Currency){
		List<Valuable> temp = new ArrayList<Valuable>();
		
		for(Valuable val: coins) {
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
	public static void printCoins(List<Valuable> val){
	
			System.out.println(val.toString());
	
	}
	
	/**
	 * Sort coin by minimum value to maximum value
	 * and print coin
	 * @param coins
	 * 
	 */
	public static void sortCoins(List<Valuable> coins) {
		
		java.util.Collections.sort( coins , new ValueComparator());

		printCoins(coins);

	}
	
	public static void main(String[] args) {

		List<Valuable> coins = new ArrayList<Valuable>();
		coins.add(new Coin(10.0,"Baht"));
		coins.add(new BankNote(787878, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new BankNote(44000, "Dollar"));
		coins.add(new Coin(50, "Dollar"));
		coins.add(new Coin(8.7, "Dollar"));
		coins.add(new BankNote(47514854, "Baht"));
		coins.add(new Coin(4.3, "Baht"));
		
		System.out.println("////////////unsorted////////////////////////////");

		printCoins(coins);
		System.out.println("////////////////sorted////////////////////////");
		sortCoins(coins);
		System.out.println("//////////////////////////////////////////////");

		System.out.println(filterByCurrency(coins, "Baht"));
		System.out.println(filterByCurrency(coins, "Dollar"));

	}
	
}
