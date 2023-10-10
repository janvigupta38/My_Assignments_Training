package com.service;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import com.dao.BookMyTicketDAO;
import com.exception.InvalidTicketException;
import com.model.BookMyTicket;
import com.util.ApplicationUtil;
public class BookMyTicketService {
	
	private DBConectManager dbConectManager ;
	public 
public static List <BookMyTicket> buildTicketList(List<String> ticketRecords) throws InvalidTicketException {
		
		
		List <BookMyTicket> objectList = new ArrayList<BookMyTicket>();
		// Write code here
		for(String s:ticketRecords) {
			String [] str=s.split(":",0);
			if(str.length!=10) {
				throw new InvalidTicketException("Invalid ticket format:"+s);
			}
			String ticketId=str[0];
			String customerName=str[1];
			Date purchaseDate=ApplicationUtil.stringToDateConverter(str[2]);
			String travelType=str[3];
			String source=str[4];
			String destination=str[5];
			String  ticketType=str[6];
			int noOfKm=Integer.parseInt(str[7]);
			int nnoOfTicketso=Integer.parseInt(str[8]);
			String discountCoupon=str[9];
			double billAmount=BookMyTicketService.calculateBillAmount(travelType, ticketType, noOfKm, nnoOfTicketso, discountCoupon);
			BookMyTicket book=new BookMyTicket(ticketId,customerName,purchaseDate,travelType,source,destination,ticketType,noOfKm,nnoOfTicketso,discountCoupon,billAmount);
			objectList.add(book);
		}
	    
		return objectList;
	}
	
	public boolean addBookMyTicketList(String[] inputfeed)
	{
//		boolean recordInserted=false;
		List<String> valid=ApplicationUtil.extractDetails(inputfeed);
		List<BookMyTicket> desTicket=BookMyTicketService.buildTicketList(valid);
		if(desTicket.size()==valid.size())
		{
			return true;
		}
		
		return false;
		 
	}	 
	
	public static double calculateBillAmount(String travelType, String ticketType, int noOfKm ,int noOfTickets, String discountCoupon)
	{
		double bill=0;
		int amt=0;
	    // Write code here
		if(travelType.equalsIgnoreCase("Bus")) {
			if(ticketType.equalsIgnoreCase("Sleeper")) {
				if(noOfKm>=100) {
					amt=(noOfKm*5)*noOfTickets;
				}
				
			}else if(ticketType.equalsIgnoreCase("SemiSleeper")) {
				if(noOfKm>0) {
					amt=(noOfKm*2)*noOfTickets;
				}
			}
		}
		else if(travelType.equalsIgnoreCase("Train")) {
			if(ticketType.equalsIgnoreCase("Ac")) {
				if(noOfKm>=30) {
					amt=(noOfKm*6)*noOfTickets;
				}
			}else if(ticketType.equalsIgnoreCase("NonAc")) {
				if(noOfKm>=30) {
					amt=(noOfKm*4)*noOfTickets;
				}
			}
		}
		else if(travelType.equalsIgnoreCase("Aeroplane")) {
			if(ticketType.equalsIgnoreCase("Economy")) {
				if(noOfKm>=200) {
					amt=(noOfKm*8)*noOfTickets;
				}
			}else if(ticketType.equalsIgnoreCase("Business")) {
				if(noOfKm>=200) {
					amt=(noOfKm*15)*noOfTickets;
				}
			}else if(ticketType.equalsIgnoreCase("First")) {
				if(noOfKm>=200) {
					amt=(noOfKm*22)*noOfTickets;
				}
			}
		}
		if(discountCoupon.equals("BOOKT100")) {
			bill=amt-(amt*0.04);
		}else if(discountCoupon.equals("BOOKT111")) {
			bill=amt-(amt*0.03);
		}else if(discountCoupon.equals("BOOKT112")) {
			bill=amt-(amt*0.02);
		}
		return bill;
	}
	
	public String retrieveTicketCount(String travelType)
	{
		// Write code here
		
		return null;
	}
	
}
	 	  	  			  	  	     	 	
