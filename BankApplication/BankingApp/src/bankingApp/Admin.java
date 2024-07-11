package bankingApp;


import java.io.Console;
import java.math.BigDecimal;
import java.util.*;
import java.util.Map.Entry;

public class Admin {
	static Scanner s = new Scanner(System.in);
	private static Map<String, BankAccount> accounts = extracted();
	
	@SuppressWarnings("unchecked")
	private static Map<String, BankAccount> extracted() {
		return AccountDataBase.returnMap();
	}
	
	private static void createAccount() 
    {
        System.out.print("Enter account number: ");
        String accountNumber = s.nextLine();
        if (accounts.containsKey(accountNumber)) 
        {
            System.out.println("Account already exists.");
        } 
        else 
        {
        	if(BankAccount.accountNumberValidation(accountNumber))
        	{
        		System.out.print("Enter the Account Holder's Name: ");
        		String name=s.nextLine();
        		System.out.print("Enter new username : ");
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
                System.out.print("Enter mobile number:");
                String mobileno=s.nextLine();
                System.out.print("Enter emailId      :");
                String emailId=s.nextLine();
                System.out.print("Enter initial balance: ");
                BigDecimal initialBalance = new BigDecimal(s.nextLine());
                accounts.put(accountNumber, new BankAccount(accountNumber, initialBalance,user,pass,name,mobileno,emailId));
                System.out.println("Account created successfully.");
                pass=null;mobileno=null;emailId=null;user=null;name=null;
                
        	}
        	else
        	{
        		System.out.println("Invalid Account Number!!Check whether the account number is digits(0-9)");
        	}
        	@SuppressWarnings("unused")
			String t=s.nextLine();
    		t=null;
        }
    }
	
	private static void displayAllUserDetails()
	{
		System.out.println("===================Display All Users Account=============");
		int i=1;
		for(Entry<String, BankAccount> e : accounts.entrySet())
		{
			BankAccount account = e.getValue();
			System.out.println("\n================  Account Details "+i+" ================\n");
			System.out.println("Account Holder's Name : "+account.getAccountHolder());
			System.out.println("Account No : "+account.getAccountNumber());
			System.out.println("Username : "+account.getUser());
			System.out.println("Email : "+account.getEmail());
			System.out.println("Mobile No: "+account.getMobileNo());
			System.out.println("Balance : "+account.getBalance());
			i++;
		}
		@SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
	}
	
	private static void deleteAccount()
	{
		System.out.println("-------------------Delete Account------------");
		System.out.print("Enter account number: ");
        String accountNumber = s.nextLine();
        if (accounts.containsKey(accountNumber)) 
        {
            accounts.remove(accountNumber);
        }
        else
        {
        	System.out.println("No accounts to delete!!");
        }
        @SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
	}
	
	private static void searchAccount()
	{
		System.out.print("Enter the AccountNumber : ");
		BankAccount account = accounts.get(s.nextLine());
		if(account==null)
			System.out.println("No Account Found!!");
		else
		{
			System.out.println("\n================  Account Details  ================\n");
			System.out.println("Account Holder's Name : "+account.getAccountHolder());
			System.out.println("Username : "+account.getUser());
			System.out.println("Balance : "+account.getBalance());
			
		}
		@SuppressWarnings("unused")
		String t=s.nextLine();
		t=null;
	}
	
	public static void main() {
		
		System.out.println("Logged in Successfull!!!");
		boolean b=true;
		while(true)
		{
			ConsoleClear.main(null);
			System.out.println("\n================  Admin  ================\n");
			System.out.println("1. Create Account for User");
            System.out.println("2. Delete an Account");
            System.out.println("3. Search an Account"); 
            System.out.println("4. Display all Account Details"); 
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = s.nextInt();
            s.nextLine();
            
            switch (choice) {
			case 1: 
				ConsoleClear.main(null);
				createAccount();
				break;
			case 2:
				ConsoleClear.main(null);
				deleteAccount();
				break;
			case 3:
				ConsoleClear.main(null);
				searchAccount();
				break;
			case 4:
				ConsoleClear.main(null);
				displayAllUserDetails();
				break;
			case 5:
				ConsoleClear.main(null);
				b=false;
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + choice);
			}
            
            if(!b)
            	break;
            
		}
	}

}

