package coinpurse.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import coinpurse.Valuable;
import coinpurse.ValueComparator;


/**
 *  GreedyWithdrawStrategy is class for withdraw money by implements WithdrawStrategy
 * @author Atid Srisukhatapuek
 */
public class GreedyWithdrawStrategy implements WithdrawStrategy {
	/** 
	 * Find and return items from a collection whose total value equals  
	 * the requested amount. 
	 * @param amount is the amount of money to withdraw, with currency 
	 * @param money the contents that are available for possible withdraw. 
	 *              Must not be null, but may be an empty list.       
	 *              This list is not modified. 
	 * @return if a solution is found, return a List containing references  
	 *        from the money parameter (List) whose sum equals the amount. 
	 *        If a solution is not found, returns (WHAT?) 
	 */ 
	@Override
	public List<Valuable> withdraw(Valuable amount, List<Valuable> money) {
		if(amount.getValue() < 0) {
    		return null;
    	}
   
    	List<Valuable> temp = new ArrayList<Valuable>();
    	Collections.sort(money, new ValueComparator());
    	Collections.reverse(money);
    	double amountNeededToWithdraw = amount.getValue();
    	
    	
		for(int i = 0; i < money.size(); i++) {
		
			if(money.get(i).getValue() <= amountNeededToWithdraw && money.get(i).getCurrency().equals(amount.getCurrency()) ) {
				amountNeededToWithdraw -= money.get(i).getValue();
				temp.add(money.get(i));
			}
			
			if(amountNeededToWithdraw == 0) break;
		}
		
		
		if ( amountNeededToWithdraw != 0 )
		{	
			return null;
	 	}

		
		for(int i = 0; i< temp.size(); i++) {
			money.remove(temp.get(i));
		}
		
		
        return temp ;
	}
	
	
}
