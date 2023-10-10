package com.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.entities.Account;
import com.entities.BankTransaction;
//import com.exception.InvalidAccountException;
import com.exception.InvalidBankTransactionException;
import com.repository.AccountRepository;
import com.repository.TransactionRepository;

@Component
public class TransactionDAOImpl implements ITransactionDAO {
	
	//Provide code to Inject TransactionRepository and AccountRepository
	@Autowired
	private TransactionRepository tr;
	//Provide code to Inject AccountRepository, if needed
	@Autowired
	private AccountRepository aR;
	
	@Override
	public BankTransaction insertTransaction(BankTransaction transactionObj,String accountNumber) throws InvalidBankTransactionException{
		
		Optional<Account>optAccount = aR.findById(accountNumber);
		
		//transactionObj.setAccountObj(account);
		double balanceAmount=0.0;
		
		if(optAccount.isPresent()) {
			Account account = optAccount.get();
			if(transactionObj.getTransactionType().equals("Deposit")) {
				balanceAmount = account.getBalanceAmount()+ transactionObj.getAmount();
			}else if(transactionObj.getTransactionType().equals("Withdraw")) {
				balanceAmount = account.getBalanceAmount()- transactionObj.getAmount();
			}
			account.setBalanceAmount(balanceAmount);
			transactionObj.setAccountObj(account);
			return tr.save(transactionObj);
		}
		else {
			throw new InvalidBankTransactionException();
		}
		
	}
	
	@Override
	public List<BankTransaction> viewTransactionByAccountNumber(String accountNumber) throws InvalidBankTransactionException
	{
		//fill code
		List<BankTransaction> list =tr.findByAccountObjAccountNumber(accountNumber);
		if(list.isEmpty()) {
			throw new InvalidBankTransactionException();
		}
		else {
			return list;
		}
			
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionType(String transactionType)
	{
		//fill code
		
		return tr.findByTransactionType(transactionType);	
	}
	
	@Override
	public List<BankTransaction> viewTransactionByTransactionTypeAndAmount(String transactionType,double amount)
	{
		//fill code
		
		return tr.findByTransactionTypeAndAmountGreaterThanEqual(transactionType ,amount);	
	}

}
