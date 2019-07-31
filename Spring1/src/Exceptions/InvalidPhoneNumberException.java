package Exceptions;

public class InvalidPhoneNumberException extends Exception{
	public InvalidPhoneNumberException()
	{
		super("The Phone number is in invalid Format");
	}

}