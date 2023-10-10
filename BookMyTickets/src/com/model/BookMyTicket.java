//Do not add or edit the code. Model class is provided as part of the code skeleton

package com.model;

import java.util.Date;

public class BookMyTicket {
	
	private String ticketId;
	private String customerName;
	private Date purchaseDate;
	private String travelType;
	private String source;
	private String destination;
	private String ticketType;
	private int noOfKm;
	private int noOfTickets;
	private String discountCoupon;
	private double billAmount;
	
	public BookMyTicket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public BookMyTicket(String ticketId, String customerName, Date purchaseDate, String travelType, String source,
			String destination, String ticketType, int noOfKm, int noOfTickets, String discountCoupon,
			double billAmount) {
		super();
		this.ticketId = ticketId;
		this.customerName = customerName;
		this.purchaseDate = purchaseDate;
		this.travelType = travelType;
		this.source = source;
		this.destination = destination;
		this.ticketType = ticketType;
		this.noOfKm = noOfKm;
		this.noOfTickets = noOfTickets;
		this.discountCoupon = discountCoupon;
		this.billAmount = billAmount;
	}



	public String getTicketId() {
		return ticketId;
	}

	public void setTicketId(String ticketId) {
		this.ticketId = ticketId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getTravelType() {
		return travelType;
	}

	public void setTravelType(String travelType) {
		this.travelType = travelType;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTicketType() {
		return ticketType;
	}

	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}

	public int getNoOfKm() {
		return noOfKm;
	}

	public void setNoOfKm(int noOfKm) {
		this.noOfKm = noOfKm;
	}

	public int getNoOfTickets() {
		return noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}

	public String getDiscountCoupon() {
		return discountCoupon;
	}

	public void setDiscountCoupon(String discountCoupon) {
		this.discountCoupon = discountCoupon;
	}

	public double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(double billAmount) {
		this.billAmount = billAmount;
	}



	@Override
	public String toString() {
		return "BookMyTicket [ticketId=" + ticketId + ", customerName=" + customerName + ", purchaseDate="
				+ purchaseDate + ", travelType=" + travelType + ", source=" + source + ", destination=" + destination
				+ ", ticketType=" + ticketType + ", noOfKm=" + noOfKm + ", noOfTickets=" + noOfTickets
				+ ", discountCoupon=" + discountCoupon + ", billAmount=" + billAmount + "]";
	}
	

	
	
	

}
