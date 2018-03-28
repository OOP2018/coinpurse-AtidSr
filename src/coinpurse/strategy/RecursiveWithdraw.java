package coinpurse.strategy;

import java.util.ArrayList;
import java.util.List;

import coinpurse.Money;
import coinpurse.MoneyUtil;
import coinpurse.Valuable;

/** 
 * Withdraw class which is using recursive 
 * @author Atid Srisukhantapuek
 */

public class RecursiveWithdraw implements WithdrawStrategy{
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
		List<Valuable> value = MoneyUtil.filterByCurrency(money, amount.getCurrency());
		double amountDouble = amount.getValue();
		return recursiveHelper(amountDouble,value);
		
	}
	
	/** 
	 * Helper for withdraw method
	 * @param amount is the amount of money to withdraw, with currency 
	 * @param money the contents that are available for possible withdraw. 
	 *              Must not be null, but may be an empty list.       
	 *              This list is not modified. 
	 *
	 */ 

	public List<Valuable> recursiveHelper(double amount, List<Valuable> money) {
		
		if(amount < 0) {
			return null;
		}
		if(money.isEmpty() && amount != 0) return null;
		
		if(amount == 0) return new ArrayList<>();
		
		double newAmount = amount - money.get(0).getValue();
		
		List<Valuable> recur1 = recursiveHelper(newAmount ,money.subList(1, money.size()));
		List<Valuable> recur2 = recursiveHelper(amount,money.subList(1, money.size()));
		
		if(recur1 != null) {
			recur1.add(money.get(0));
			return recur1;
		}
		
		return recur2;
	}
}

