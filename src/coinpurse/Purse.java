package coinpurse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import coinpurse.strategy.GreedyWithdrawStrategy;
import coinpurse.strategy.WithdrawStrategy;
import coinpurse.strategy.RecursiveWithdraw;

import java.util.Collections;
import java.util.Comparator;


// You will use Collections.sort() to sort the coins

/**
 *  A Valuable purse contains Valuable.
 *  You can insert Valuable, withdraw money, check the balance,
 *  and check if the purse is full.
 *  
 *  @author Atid Srisukhantapuek
 */
public class Purse  {
    /** Collection of objects in the purse. */
	List<Valuable> money = new ArrayList<Valuable>();
 
    /** Capacity is maximum number of items the purse can hold.
     *  Capacity is set when the purse is created and cannot be changed.
     */
    private final int capacity;
    
    
	WithdrawStrategy withdrawstrategy = new RecursiveWithdraw();
    /** 
     *  Create a purse with a specified capacity.
     *  @param capacity is maximum number of Valuable you can put in purse.
     */
    public Purse( int capacity ) {
    	this.capacity = capacity;
    	
    	
    }

    /**
     * Count and return the number of money in the purse.
     * This is the number of valuable, not their value.
     * @return the number of valuable in the purse
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
  
        if(money.size() >= capacity) { 
        	return true;
        }  	
    	return false;
    }

    /** 
     * Insert a valuable into the purse.
     * The valuable is only inserted if the purse has space for it
     * and the valuable has positive value.  No worthless coins!
     * @param valuable is a Valuable object to insert into purse
     * @return true if value inserted, false if can't insert
     */
    public boolean insert( Valuable value ) {
        // if the purse is already full then can't insert anything.

    	if(this.isFull() || value.getValue() == 0) {
    		return false;
    	}else {
    		money.add(value);
    		return true;
    	}
    }
    
    /**  
     *  Withdraw the requested amount of money.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( Valuable amount ) {
    	if(amount.getValue() < 0) {
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
        	
    	List<Valuable> temp = withdrawstrategy.withdraw(amount, money);

   
//    	double amountNeededToWithdraw = amount.getValue();
//    	
//    	
//		for(int i = 0; i < money.size(); i++) {
//		
//			if(money.get(i).getValue() <= amountNeededToWithdraw && money.get(i).getCurrency().equals(amount.getCurrency()) ) {
//				amountNeededToWithdraw -= money.get(i).getValue();
//				temp.add(money.get(i));
//			}
//			
//			if(amountNeededToWithdraw == 0) break;
//		}
//		
//		
//		if ( amountNeededToWithdraw != 0 )
//		{	
//			// failed. Don't change the contents of the purse.
//			return null;
//	 	}
    	if(temp == null) return null;
    	
    	

		// Success.
		// Remove the coins you want to withdraw from purse,		
		// and return them as an array.
		// Use list.toArray( array[] ) to copy a list into an array
		// toArray returns a reference to the array itself.
		
		for(int i = 0; i< temp.size(); i++) {
			money.remove(temp.get(i));
		}
		
		Valuable[] array  = new Valuable[temp.size()];
		temp.toArray(array );
        return array ;
	}
    
    /**  
     *  Withdraw the requested amount of money with baht currency.
     *  Return an array of Valuable withdrawn from purse,
     *  or return null if cannot withdraw the amount requested.
     *  @param amount is the amount to withdraw
     *  @return array of valuable objects for money withdrawn, 
	 *    or null if cannot withdraw requested amount.
     */
    public Valuable[] withdraw( double amount ) {
  	   Valuable baht = new Money(amount,"Baht");
  	   return withdraw(baht);
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
//		Purse n = new Purse(10);
//		System.out.println(	n.insert( new BankNote(0, "Baht")));
//		System.out.println(	n.insert( new BankNote(500, "Baht")));
//		System.out.println(	n.insert( new BankNote(600, "Baht")));
//		System.out.println(	n.insert( new BankNote(700, "Dollar")));
//
//		System.out.println( n.insert( new Coin(0, "Baht")));
//		System.out.println( n.insert( new Coin(900, "Baht")));
//		System.out.println( n.insert( new Coin(700, "Dollar")));
//		System.out.println( n.insert( new Coin(800, "Dollar")));
//		System.out.println( n.insert( new Coin(800, "Baht")));
//		System.out.println( n.insert( new Coin(191, "Baht")));
//		System.out.println( n.insert( new Coin(800, "Zollar")));
//		System.out.println(n.toString());
//		System.out.println(Arrays.toString(n.withdraw(800)));
//		System.out.println(Arrays.toString(n.withdraw(new Money(900, "Dollar"))));
//
//		System.out.println(n.toString());
//
//		System.out.println(n.toString());
//		System.out.println(Arrays.toString(n.withdraw(500)));
//		System.out.println(Arrays.toString(n.withdraw(600)));
//		System.out.println(Arrays.toString(n.withdraw(700)));
//
//	}

}
