package coinpurse;

import java.util.ArrayList;
import java.util.List;

public class MoneyUtil {
	
	
	public static void printCoins(List<Coin> coin){
		for(Coin obj: coin) {
			System.out.println(obj.toString());
		}
	}
	
	public static void main(String[] args) {

		List<Coin> coins = new ArrayList<Coin>();
		coins.add(new Coin(10.0, "Baht"));
		coins.add(new Coin(0.5, "Baht"));
		coins.add(new Coin(2.0, "Baht"));
		coins.add(new Coin(4.6, "Penny"));
		coins.add(new Coin(8.7, "Other"));

		printCoins(coins);
		
		java.util.Collections.sort( coins );
		System.out.println("Sort:");
		printCoins(coins);


	}
	
}
