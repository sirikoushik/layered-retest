package PresentationLayer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import com.capg.bean.*;
import com.capg.service.*;

public class Main {
	static AccountServiceImpl service=new AccountServiceImpl();
	public static void displayUnit() {
		System.out.println("---------WELCOME----------");
		System.out.println("01. Create an Account");
		System.out.println("02. Add Money to your Account");
		System.out.println("03. Show Details of your account");
		System.out.println("04. Transfer Money to another account");
		System.out.println("05. Show All Accounts in the bank");
		System.out.println("06. Exit");
		System.out.print("Enter Your Choice : ");
	}
	
	
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int choice;
		while(true)
		{
			displayUnit();
			choice = scanner.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Account Creation");
				try
				{
					Account user=new Account();
					System.out.println("Enter your name:");
					user.setName(scanner.next());
					System.out.println("Enter your phone number:");
					user.setPhoneNumber(scanner.nextLong());
					System.out.println("Enter your email:");
					user.setEmailid(scanner.next());
					user.setBalance(0);
					String AccountNumber=service.createAccount(user);
					System.out.println("Your Account Number is : "+AccountNumber);					
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
								break;
			
				
				
			case 2:
				System.out.println("Add Money");
				try {
					System.out.println("Enter the account number to add money:");
					String AccountNumber=scanner.next();
					System.out.println("Enter the amount to add in to the account "+AccountNumber);
					int Amount=scanner.nextInt();
					service.addMoney(AccountNumber, Amount);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
				
				
			case 3:
				System.out.println("View Account Details by entering account number");
				try
				{
					System.out.println("Enter the Account Number");
					String AccountNumber=scanner.next();
					Account user=service.viewAccount(AccountNumber);
					System.out.println("Name="+user.getName()+"\nPhone="+user.getPhoneNumber()+"\nEmail="+user.getEmailid()+"\nBalance="+user.getBalance());
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
				
	
			case 4:
				System.out.println("Money Transfer");
				try
				{
					System.out.println("Enter  sender Account Number");
					String SenderAccountNumber=scanner.next();
					System.out.println("Enter  Reciever Account Number");
					String RecieverAccountNumber=scanner.next();
					System.out.println("Enter the amount to be transferred");
					int TransferAmount=scanner.nextInt();
					service.transfer(SenderAccountNumber, RecieverAccountNumber, TransferAmount);
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
				
		
			case 5:
				try
				{
					Map<String, Account> list=new HashMap<String, Account>();
					list=service.getAllAccounts();
					if(!list.isEmpty())
					{

						Set<Entry<String, Account>> set=list.entrySet();
						Iterator<Entry<String, Account>> i=set.iterator();
						while(i.hasNext())
						{
							Map.Entry<String, Account> me=(Map.Entry<String, Account>)i.next();
							Account result=me.getValue();
							System.out.println("Account Number: "+me.getKey()+"\nName: "+result.getName());
						}
					}
					else
					{
						System.out.println("No Accounts Found");
					}
				}
				catch(Exception e)
				{
					System.out.println(e);
				}
				break;
				
				
			case 6:
				System.exit(0);
			default:
				break;
			}
		}
	}

}