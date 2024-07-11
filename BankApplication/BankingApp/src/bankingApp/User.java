package bankingApp;

import java.io.Console;
import java.math.BigDecimal;
import java.util.*;

public class User {
	private static Map<String, BankAccount> accounts = extracted();
	
	@SuppressWarnings("unchecked")
	private static Map<String, BankAccount> extracted() {
		return AccountDataBase.returnMap();
	}
	public static BankAccount account;
	static Scanner s = new Scanner(System.in);
	public static void main(BankAccount a) {
		account=a;
        while (true) 
        {
        	ConsoleClear.main(null);
        	System.out.println("=============================================\n");
        	System.out.println("      Welcome "+ account.getAccountHolder()+ "     \n");
        	System.out.println("=============================================\n");
        	System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Change Password");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                	changePassword();
                	break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        }
      
    }

    private static void deposit() 
    {
        if (account == null) 
        {
            System.out.println("Account does not exist.");
        } 
        else 
        {
            System.out.print("Enter amount to deposit: ");
            BigDecimal amount = new BigDecimal(s.nextLine());
            account.deposit(amount);
        }
        @SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
    }
    

    private static void withdraw() 
    {
        if (account == null) 
        {
            System.out.println("Account does not exist.");
        } 
        else 
        {
        	System.out.print("Enter amount to withdraw: ");
            BigDecimal amount = new BigDecimal(s.nextLine());
            account.withdraw(amount);
        }
        @SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
    }

    private static void checkBalance() 
    {
        if (account == null) 
        {
            System.out.println("Account does not exist.");
        } 
        else 
        {
        	account.checkBalance();
        }
        @SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
    }
    
    private static void changePassword()
    {
    	System.out.print("Enter account number: ");
        String accountNumber = s.nextLine();
        
        BankAccount account = accounts.get(accountNumber);
        if (account == null) 
        {
            System.out.println("Account does not exist.");
        } 
        else
        {
        	System.out.print("Enter username: ");
        	String username=s.nextLine();
        	System.out.print("Enter old password: ");
        	char pwd [];
            Console console = System.console();
            String oldpassword="";
            if (console != null) {
                pwd = console.readPassword();
                for(char ch: pwd)
                	oldpassword+=ch;
                Arrays.fill(pwd, ' ');
            } 
            else {
                oldpassword=s.nextLine();
            }
        	if(account.checkAuthentication(username, oldpassword))
        	{
        		oldpassword=null;
        		
        		System.out.print("Enter the new Password:");
                String pass="";
                if (console != null) {
                    pwd = console.readPassword();
                    for(char ch: pwd)
					pass+=ch;
                    Arrays.fill(pwd, ' ');
                } 
                else {
                    pass=s.nextLine();
                }
        		account.setPassword(pass);
        	}
        	else
        	{
        		System.out.println("Wrong Password!!");
        	}
        	
        }
        @SuppressWarnings("unused")
		String t=s.nextLine();
    	t=null;
    }

}

