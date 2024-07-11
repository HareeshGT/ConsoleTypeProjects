package bankingApp;

import java.io.Console;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class Main {
	static Scanner s = new Scanner(System.in);
	private static Map<String, BankAccount> accounts = extracted();
	
	@SuppressWarnings("unchecked")
	private static Map<String, BankAccount> extracted() {
		return AccountDataBase.returnMap();
	}
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		AccountDataBase a = new AccountDataBase();
		
		while(true)
		{
			ConsoleClear.main(args);
			System.out.println("Enter the User type (Admin-0/Users-1): ");
			int ut=s.nextInt();
			s.nextLine();
			if(ut==0 || ut==1)
			{
				if(ut==0)
				{
					System.out.print("Enter username: ");
					String user=s.nextLine();
					char pwd [];
	                Console console = System.console();
	                String pass="";
	                if (console != null) {
	                    pwd = console.readPassword("Enter password: ");
	                    for(char ch: pwd)
						pass+=ch;
	                    Arrays.fill(pwd, ' ');
	                } 
	                else {
	                    System.out.print("Enter password: ");
	                    pass=s.nextLine();
	                }
					if(AdminUsernamePass.AdminValidation(user, pass))
					{
						pass=null;
						System.out.println("Logging in!!");
						Admin.main();
					}
					else
					{
						System.out.print("Login Failed!!  ");
						System.out.println("Invalid Credentials!!");
					}
				}
				else
				{
					System.out.print("Enter your Account Number: ");
					String accNo=s.nextLine();
					BankAccount account = accounts.get(accNo);
					if(account!=null)
					{
						System.out.print("Enter Username: ");
						String user=s.nextLine();
						char pwd [];
		                Console console = System.console();
		                String pass="";
		                if (console != null) {
		                    pwd = console.readPassword("Enter password: ");
		                    for(char ch: pwd)
							pass+=ch;
		                    Arrays.fill(pwd, ' ');
		                } 
		                else {
		                    System.out.print("Enter password: ");
		                    pass=s.nextLine();
		                }
						if(account.checkAuthentication(user, pass))
						{	
							pass=null;
							User.main(account);	
						}
						else
							System.out.println("Invalid Credentials!!");
					}
				}
			}
			else
			{
				System.out.println("Invalid User Type!!\n"
						+ "Do You want to Exit(Y/N)? ");
				String c=s.next();
				if(c.equalsIgnoreCase("y")) {
					ConsoleClear.main(args);
					break;
				}
				else
				{
					continue;
				}
				
			}
		}
		

	}

}
