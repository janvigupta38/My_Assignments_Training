package com.util;

import java.util.*;
import java.text.*;
import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidTicketException;
public class ApplicationUtil {

	public static List<String> extractDetails(String[] inputfeed) {
		List<String> stringList = new ArrayList<String>();
		for(int i=0;i<inputfeed.length;i++) {
			String[] s=inputfeed[i].split(":",0);
			try {
				boolean valid=ApplicationUtil.validateTravelType(s[3]);
				if(valid) {
				stringList.add(inputfeed[i]);
				}
			}catch(Exception e) {}
			
		}
		// Write code here

		return stringList;
	}

	public static boolean validateTravelType(String travelType) throws InvalidTicketException{
			

			// Write code here
			travelType=travelType.toLowerCase();
			if(travelType.equals("bus") || travelType.equals("train") ||travelType.equals("aeroplane") ) {
				return true;
			}
			throw new InvalidTicketException("exception");
    
	}

	public static java.util.Date stringToDateConverter(String stringDate) {
	        
	        // Write code here
			Date date=null;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			try {
			date=sdf.parse(stringDate);
			return date;
			}catch(Exception e) {
			return null;
			}
		}
	

	public static java.sql.Date utilToSqlDateConverter(java.util.Date utDate) {
		
//	        
			
			return null;
	}
	
	public static java.util.Date sqlToUtilDateConverter(java.sql.Date sDate) {
	    
	        java.util.Date utDate = new java.util.Date(sDate.getTime());
	        DateFormat dformat=new SimpleDateFormat("yyyy-MM-dd");
	        utDate=dformat.format(sDate);
	        // Write code here
	        
	        return utDate;
	}
}