package Exceptions;

@SuppressWarnings("serial")
public class InsuffecientBalanceException extends Exception{
	public InsuffecientBalanceException() {
		super("The Sender Acoount Balance is not suffecient");
	}

}