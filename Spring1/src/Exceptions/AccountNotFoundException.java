    
package Exceptions;

public class AccountNotFoundException extends Exception{
   public AccountNotFoundException()
	{
		super("The Account Number is not found");
	}

}