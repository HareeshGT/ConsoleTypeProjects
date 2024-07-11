package bankingApp;
import java.math.BigDecimal;
import java.util.*;

public class AccountDataBase {
	private static Map<String, BankAccount> accounts = new HashMap<>();
	
	public AccountDataBase()
	{
		accounts.put("1", new BankAccount("1", new BigDecimal("10000"), "user1", "1","","9876543210","user1@gmail.com"));
		accounts.put("2", new BankAccount("2", new BigDecimal("20000"), "user2", "2","","7894561230","user1@gmail.com"));
		accounts.put("3", new BankAccount("3", new BigDecimal("30000"), "user3", "3","","6549873210","user1@gmail.com"));
		accounts.put("4", new BankAccount("4", new BigDecimal("40000"), "user4", "4","","8975642310","user1@gmail.com"));
		// for(int i=5;i<10000000;i++)
		// {
		// 	String an=""+i;
		// 	BigDecimal amt=new BigDecimal(""+(i*10000));
		// 	String un="user"+i;
		// 	String pass=""+i;
		// 	String accHolder="";
		// 	String mo="1112223334";
		// 	String email=un+"@gmail.com";
		// 	accounts.put(an, new BankAccount(an, amt, un, pass, accHolder, mo, email));
		// }
	}
	@SuppressWarnings("rawtypes")
	public static Map returnMap()
	{
		return accounts;
	}

	
}
