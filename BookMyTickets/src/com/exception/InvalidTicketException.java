package com.exception;

public class InvalidTicketException extends Exception{

		// Write a public  single argument constructor (with String message as an argument) 
		// and set the message to the super class constructor 
	public InvalidTicketException(String exception) 
	{
		super(exception);
	}
}
