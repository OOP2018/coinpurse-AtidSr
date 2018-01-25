package coinpurse;

import java.util.ArrayList;
import java.util.List;

/** 
 * Class MoneyUtil create for test coin class 
 * @author Atid Srisukhantapuek
 * 
 */


public class MoneyUtil {
	
	/**
	 *  Filter coin by currency of coin
	 *  @param coin that user want to filter
	 *  @return list of coin with same currency
	 */
	public static List<Coin> filterByCurrency(List<Coin>coins,String Currency){
		List<Coin> temp = new ArrayList<Coin>();
		
		for(Coin coin:coins) {
			if(coin.getCurrency().equals(Currency)) {
				temp.add(coin);
			}
			
		}
		return temp;
	}
	
	/**
	 * Print all coins that in list
	 * @param list of coin that user want to print
	 */
	public static void printCoins(List<Coin> coin){
		for(Coin obj: coin) {
			System.out.println(obj.toString());
		}
	}
	
	/**
	 * Sort coin by minimum value to maximum value
	 * and print coin
	 * @param coins
	 * 
	 */
	public static void sortCoins(List<Coin> coins) {
		
		java.util.Collections.sort( coins );

		printCoins(coins);

	}
	
	public static void main(String[] args) {

		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0,"Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(4.6, "Penny"));
		coins.add(new Coin(50, "Penny"));
		coins.add(new Coin(8.7, "Zen"));
		coins.add(new Coin(0.5, "Zen"));
		coins.add(new Coin(4.3, "Zen"));

		printCoins(coins);
		System.out.println("////////////////////////////////////////");
		
		sortCoins(filterByCurrency(coins, "Baht"));
		sortCoins(filterByCurrency(coins, "Zen"));

	}
	
}
