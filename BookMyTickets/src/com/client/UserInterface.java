package com.client;

import java.util.*;
import com.service.BookMyTicketService;

public class UserInterface {
	public static void main(String[] args) {
		BookMyTicketService ppService = new BookMyTicketService();
		Scanner sc=new Scanner(System.in);
		
		// The below code gets the details of ticket
		// Give input in the format as specified in the problem statement
				
		System.out.println("Enter the number of tickets for booking");
		int num=sc.nextInt();
		String s[]=new String[num];
		if(num>0){
		System.out.println("Enter the ticket details");
		sc.nextLine();
		for(int i=0;i<num;i++)
		{
			s[i]=sc.nextLine();
		}
				
		// The below code passes the ticket details to the addBookMyTicketList method in the BookMyTicketService class 
		
		boolean recordsInserted = false;
			recordsInserted = ppService.addBookMyTicketList(s);
			if (recordsInserted)
			{
				System.out.println("Valid Ticket records are updated to the database");
				
				// The below code calls the retrieveTicketCount method in the BookMyTicketService class	
			
			    System.out.println("Enter the Travel Type");
			    String travelType=sc.next();
			    String ans=ppService.retrieveTicketCount(travelType);
			    System.out.println(ans);
				
			}
			else
				System.out.println("Failed to insert records");
			
		}	

	else
	{
	    System.out.println("Invalid input");
	}
}
}