package Exceptions;

public class IncorrectDetailsException extends Exception{
	public IncorrectDetailsException()
	{
		super("The Details Entered Are in Invalid format.");
	}

}