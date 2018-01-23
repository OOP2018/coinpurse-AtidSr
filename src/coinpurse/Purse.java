package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
// You will use Collections.sort() to sort the coins

/**
 *  A coin purse contains coins.
 *  You can insert coins, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Atid Srisukhantapuek
 */
public class Purse {
    /** Collection of objects in the purse. */
	List<Coin> money = new ArrayList<Coin>();
 
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of coins you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	
    	
    }

    /**
     * Count and return the number of coins in the purse.
     * This is the number of coins, not their value.
     * @return the number of coins in the purse
     */
    public int count() { 
    	
    	return money.size(); 
    }
    
    /** 
     *  Get the total value of all items in the purse.
     *  @return the total value of items in the purse.
     */
    public double getBalance() {
    	
    	double sum = 0;
    	for(int i = 0; i < money.size(); i++) {
    		sum += money.get(i).getValue();
    	}
		return sum; 
	}

    
    /**
     * Return the capacity of the coin purse.
     * @return the capacity
     */
    public int getCapacity() { 
		return capacity; 
	}
    
    /** 
     *  Test whether the purse is full.
     *  The purse is full if number of items in purse equals
     *  or greater than the purse capacity.
     *  @return true if purse is full.
     */
    public boolean isFull() {
  
        if(money.size() == capacity) { 
        	return true;
        }  	
    	return false;
    }

    /** 
     * Insert a coin into the purse.
     * The coin is only inserted if the purse has space for it
     * and the coin has positive value.  No worthless coins!
     * @param coin is a Coin object to insert into purse
     * @return true if coin inserted, false if can't insert
     */
    public boolean insert( Coin coin ) {
        // if the purse is already full then can't insert anything.

    	if(this.isFull() || coin.getValue() == 0) {
    		return false;
    	}else {
    		money.add(coin);
    		return true;
    	}
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Coins withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of Coin objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Coin[] withdraw( double amount ) {
    	if(amount < 0) {
    		return null;
    	}
    	
	   /*
		* See lab sheet for outline of a solution, 
		* or devise your own solution.
		* The idea is to be greedy.
		* Try to withdraw the largest coins possible.
		* Each time you choose a coin as a candidate for
		* withdraw, add it to a temporary list and
		* decrease the amount (remainder) to withdraw.
		* 
		* If you reach a point where amountNeededToWithdraw == 0
		* then you found a solution!
		* Now, use the temporary list to remove coins
		* from the money list, and return the temporary
		* list (as an array).
		*/


		// Did we get the full amount?
		// This code assumes you decrease amount each time you remove a coin.
    	// Your code might use some other variable for the remaining amount to withdraw.
    	List<Coin> temp = new ArrayList<Coin>();
    	Collections.sort(money);
    	Collections.reverse(money);
    	double amountNeededToWithdraw = amount;

		for(int i = 0; i < money.size(); i++) {
			if(money.get(i).getValue() <= amountNeededToWithdraw) {
				amountNeededToWithdraw -= money.get(i).getValue();
				temp.add(money.get(i));
			}
			
			if(amountNeededToWithdraw == 0) break;
		}
		
		
		if ( amountNeededToWithdraw != 0 )
		{	
			// failed. Don't change the contents of the purse.
			return null;
	 	}

		// Success.
		// Remove the coins you want to withdraw from purse,		
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array
		// toArray returns a reference to the array itself.
		
		for(int i = 0; i< temp.size(); i++) {
			money.remove(temp.get(i));
		}
		
		Coin[] coin = new Coin[temp.size()];
		temp.toArray(coin);
        return coin;
	}
  
    /** 
     * toString returns a string description of the purse contents.
     * It can return whatever is a useful description.
     */
    public String toString() {
    	
    	return "Purse capacity: "+getCapacity()+" Total money: "+getBalance()+" Capacity in Use: "+count();
    }
    
    /**Main method for test Purse class */
//    public static void main(String[] args) {
//		Purse n = new Purse(5);
//	
//		System.out.println(n.toString());
//		System.out.println(n.isFull());
//		n.insert(new Coin(88, "kCoin"));
//		n.insert(new Coin(77, "nCoin"));
//		n.insert(new Coin(42, "vCoin"));
//		n.insert(new Coin(36, "vCoin"));
//
//		System.out.println(n.toString());
//
//		System.out.println("0 is here");
//		n.insert(new Coin(0, "nCoin"));
//		n.insert(new Coin(-9999, "nCoin"));
//		System.out.println(n.toString());
//		
//		System.out.println(Arrays.toString(n.withdraw(88)));
//		System.out.println(n.toString());
//
//		System.out.println(n.withdraw(111111));
//		System.out.println(n.toString());
//
//		System.out.println(Arrays.toString(n.withdraw(119+36)));
//		System.out.println(n.toString());
//
//		
//		//new test
//		Purse test = new Purse(1);
//		test.insert(new Coin(999, "currencyA"));
//		System.out.println(test.toString());
//		test.insert(new Coin(55, "currency"));
//		System.out.println(test.toString());
//
//	}

}
