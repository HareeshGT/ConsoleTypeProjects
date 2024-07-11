package bankingApp;

import java.math.BigDecimal;
import java.util.ArrayList;

public class BankAccount 
{
    @SuppressWarnings("unused")
	private String accountNumber="";
    private BigDecimal balance;
    private String user="";
    private String pass="";
    private String accountHolder="";
    
    @SuppressWarnings("unused")
	private String mobileNo;
    
    @SuppressWarnings("unused")
	private String emailId;
    
    private ArrayList<String> oldpass = new ArrayList<String>();

    public BankAccount(String accountNumber,
    		BigDecimal initialBalance,String user,String pass, 
    		String accoutHolder,String mobileNo,String emailId) 
    {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.user=user;
        this.pass=pass;
        this.accountHolder=accoutHolder;
        this.mobileNo=mobileNo;
        this.emailId=emailId;
    }
    
    public  String getUser()
    {
    	return this.user;
    }
    public BigDecimal getBalance()
    {
    	return this.balance;
    }
    
    public String getAccountHolder()
    {
    	return this.accountHolder;
    }
    
    public String getEmail()
    {
    	return this.emailId;
    } 
    
    public String getMobileNo()
    {
    	return this.mobileNo;
    }
    
    public String getAccountNumber()
    {
    	return this.accountNumber;
    }
    
    public static boolean accountNumberValidation(String accountNumber)
    {
    	for(int i=0;i<accountNumber.length();i++)
    	{
    		char ch=accountNumber.charAt(i);
    		if(Character.isAlphabetic(ch))
    			return false;
    	}
    	return true;
    }
    
    public boolean checkAuthentication(String u,String p)
    {
    	if(this.user.equalsIgnoreCase(u) && this.pass.equals(p))
    		return true;
    	return false;
    }
    
    public void setPassword(String newPass)
    {
    	if(!oldpass.contains(newPass) && !pass.equals(newPass))
    	{
    		oldpass.add(pass);
    		this.pass=newPass;
    		System.out.println("New Password Updated!!");
    	}
    	else
    		System.out.println("Sorry!! Your Old password cannot be set as your New Password");
    		
    }
    
    

    public void deposit(BigDecimal amount) 
    {
        if (amount.compareTo(BigDecimal.ZERO) <= 0) 
        {
            System.out.println("Invalid amount.");
        } 
        else {
            balance = balance.add(amount);
            System.out.println("Deposit successful. New balance: " + balance);
        }
    }

    public void withdraw(BigDecimal amount) 
    {
        if (amount.compareTo(BigDecimal.ZERO) <= 0 || amount.compareTo(balance) > 0) 
        {
            System.out.println("Invalid amount or insufficient funds.");
        } 
        else 
        {
            balance = balance.subtract(amount);
            System.out.println("Withdrawal successful. New balance: " + balance);
        }
    }

    public void checkBalance() {
        System.out.println("Current balance: " + balance);
    }
}
