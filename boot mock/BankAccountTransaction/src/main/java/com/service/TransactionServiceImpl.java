package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ITransactionDAO;
//import com.entities.Account;
import com.entities.BankTransaction;
import com.exception.InvalidBankTransactionException;

//Provide necessary Annotation
@Service
public class TransactionServiceImpl implements ITransactionService {

	//Provide necessary Annotation
	@Autowired
	ITransactionDAO transactionDAO;
	
	//@Autowired
	//IAccountService accountDAO;

	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber)  throws InvalidBankTransactionException 
	{
		//fill code
		
		return transactionDAO.insertTransaction(transactionObj, accountNumber);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException
	{
		//fill code
		return transactionDAO.viewTransactionByAccountNumber(accountNumber);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType)
	{
		//fill code
		
		return transactionDAO.viewTransactionByTransactionType(transactionType);
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount)
	{
		//fill code
		
		return transactionDAO.viewTransactionByTransactionTypeAndAmount(transactionType, amount);
	}

}
