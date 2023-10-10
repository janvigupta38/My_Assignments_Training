package com.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;

//Provide necessary Annotation
@Entity
//@Table(name="account")
public class Account {
	
	//Provide necessary Annotation
    @Id
    @Column(name="account_number")
	private String accountNumber;
    @Column(name="holder_name")
	private String holderName;
    @Column(name="phone_number")
	private String phoneNumber;
    @Column(name="pan_number")
	private String panNumber;
	@Column(name="account_type")
	private String accountType; //Savings or Current
	//@Column(name="balance_amount")
	private double balanceAmount;
	
	@OneToMany(mappedBy="accountObj")
	@JsonIgnoreProperties("accountObj")
	List<BankTransaction> transactions;
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getHolderName() {
		return holderName;
	}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}		
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPanNumber() {
		return panNumber;
	}
	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public double getBalanceAmount() {
		return balanceAmount;
	}
	public void setBalanceAmount(double balanceAmount) {
		this.balanceAmount = balanceAmount;
	}
	public List<BankTransaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<BankTransaction> transactions) {
		this.transactions = transactions;
	}
	
	

	
}
