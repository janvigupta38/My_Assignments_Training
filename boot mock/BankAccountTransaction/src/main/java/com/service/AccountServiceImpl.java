package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.IAccountDAO;
import com.entities.Account;
import com.exception.InvalidAccountException;

//Provide necessary Annotation
@Service
public class AccountServiceImpl implements IAccountService {
	
	
	//Provide necessary Annotation
	@Autowired
	IAccountDAO accountDAO;

	@Override
	public Account openAccount(Account account) {
		
		//fill code
		
		return accountDAO.openAccount(account);
	}
	
	@Override
	public Account updateAccountHolderPhoneNumber(String accountNumber,String phoneNumber) throws InvalidAccountException {

		//fill code		
		return accountDAO.updateAccountHolderPhoneNumber(accountNumber, phoneNumber);
	}
	
	@Override
	public Account viewAccountByAccountNumber(String accountNumber) throws InvalidAccountException {

		//fill code
		
		return accountDAO.viewAccountByAccountNumber(accountNumber);		
	}
	
	@Override
	public List<Account> viewAccountByBalance(double balance) {

		//fill code
		
		return accountDAO.viewAccountByBalance(balance);
	}
}
