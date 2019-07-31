package com.capg.service;

import java.util.HashMap;
import java.util.Random;

import Exceptions.*;

import com.capg.service.*;
import com.capg.bean.Account;
import com.capg.dao.*;
public class AccountServiceImpl extends Validator implements AccountService{
	AccountDao dao=new AccountDaoImpl();
	Validator v=new Validator();
	@Override
	public String createAccount(Account user) throws  IncorrectDetailsException, InvalidMailException, InvalidPhoneNumberException{
		// TODO Auto-generated method stub
		String AccountNumber=null;
		try 
		{
			v.validator(user);
			Random rand=new Random();
			int num=rand.nextInt(9000000)+1000000;
			 AccountNumber=String.valueOf(num);
			dao.createAccountDao(AccountNumber, user);
		}
		catch(Exception e)
		{
			throw e;
		}
		return AccountNumber;
		
	}


	//------------------------ 1. Sample Application for Layered Architecture --------------------------
			/*******************************************************************************************************
			 - Function Name	:	viewAccount
			 - Input Parameters	:	AccountNumber
			 - Return Type		:	Account
			 - Throws			:  	AccountNotFound Exception
			 - Author			:	CAPGEMINI
			 - Creation Date	:	10/07/2019
			 - Description		:	Validates the given viewAccount
			  						if valid, invokes dao method viewAccount to add into repository
			 ********************************************************************************************************/
		
	@Override
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException{

		try
		{
			return dao.viewAccount(AccountNumber);
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	//------------------------ 1. Sample Application for Layered Architecture --------------------------
			/*******************************************************************************************************
			 - Function Name	:	addMoney
			 - Input Parameters	:	 AccountNumber, Amount
			 - Return Type		:	void
			 - Throws			:  AccountNotFoundException
			 - Author			:	CAPGEMINI
			 - Creation Date	:	10/07/2019
			 - Description		:	Validates the given AccountNumber,
			  						if valid, invokes dao method dao.addMoney(AccountNumber, Amount) to add into repository
			 ********************************************************************************************************/
	

	@Override
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			dao.addMoney(AccountNumber, Amount);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}
	
	
	//------------------------ 1. Sample Application for Layered Architecture --------------------------
			/*******************************************************************************************************
			 - Function Name	:	transfer
			 - Input Parameters	:	AccountNumber1, AccountNumber2, Amount
			 - Return Type		:	void
			 - Throws			:   InsuffecientBalanceException,AccountNotFoundException
			 - Author			:	CAPGEMINI
			 - Creation Date	:	10/07/2019
			 - Description		:	Validates the givenAccountNumber1, AccountNumber2, Amount
			  						if valid, invokes dao.transfer(AccountNumber1, AccountNumber2, Amount) to add into repository
			 ********************************************************************************************************/
		
	@Override
	public void transfer(String AccountNumber1, String AccountNumber2, int Amount) throws InsuffecientBalanceException,AccountNotFoundException {
		// TODO Auto-generated method stub
		try {
			dao.transfer(AccountNumber1, AccountNumber2, Amount);
			}
		catch(Exception e)
		{
			throw e;
		}
		
	}


	
	//------------------------ 1. Sample Application for Layered Architecture --------------------------
			/*******************************************************************************************************
			 - Function Name	:	 getAllAccounts
			 - Input Parameters	:	HashMap<String, Account>
			 - Return Type		:	HashMap
			 - Throws			:  
			 - Author			:	CAPGEMINI
			 - Creation Date	:	10/07/2019
			 - Description		:	if valid, invokes dao.getAllAccounts to add into repository
			  						
			 ********************************************************************************************************/
	
	@Override
	public HashMap<String, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		try {
			return dao.getAllAccounts();
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}