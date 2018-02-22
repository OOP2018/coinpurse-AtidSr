package coinpurse;
/**
 *  This is class for test Singleton of MoneyFactory
 *  @author Atid Srisukhantapuek
 */
public class MoneyFactoryDemo {

	public static void main(String[] args) {
		MoneyFactory.setFactory(new ThaiMoneyFactory());
		MoneyFactory factory = MoneyFactory.getInstance();
		System.out.println(factory.createMoney("5").toString());
		System.out.println(factory.createMoney("10").toString());
		System.out.println(factory.createMoney("100").toString());
		System.out.println(factory.createMoney("500").toString());
		System.out.println(factory.createMoney("1000").toString());

		MoneyFactory.setFactory(new MalayMoneyFactory());
		MoneyFactory malay = MoneyFactory.getInstance();
		System.out.println(malay.createMoney("0.05").toString());
		System.out.println(malay.createMoney("0.5").toString());
		System.out.println(malay.createMoney("100").toString());
		System.out.println(malay.createMoney("1000").toString());
		

	}
}
