package Exceptions;

public class NameFormatException extends Exception{
	public NameFormatException()
	{
		super("Name Format is incorrect. Check if the First Letter is in uppercase");
	}

}