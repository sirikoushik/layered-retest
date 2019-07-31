package com.capg.dao;

import java.util.HashMap;
import java.util.Map;
import Exceptions.*;
import com.capg.bean.*;

public class AccountDaoImpl implements AccountDao{
	Map<String, Account> userList=new HashMap<String, Account>();

	@Override
	public void createAccountDao(String accountNumber, Account user) {
		// TODO Auto-generated method stub
		try {
			userList.put(accountNumber, user);
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public Account viewAccount(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		try {
			validateAccount(accountNumber);
			Account user=new Account();
			user=userList.get(accountNumber);
			return user;
		}
		catch(Exception e) {
			throw e;
		}
	}

	@Override
	public void addMoney(String accountNumber, int amount) throws AccountNotFoundException{
		// TODO Auto-generated method stub
		try {
			validateAccount(accountNumber);
			Account user=new Account();
			user=userList.get(accountNumber);
			int temp=user.getBalance();
			temp=temp+amount;
			user.setBalance(temp);
			
		}
		catch(Exception e)
		{
			throw e;
		}
		
	}

	@Override
	public void transfer(String accountNumber1, String accountNumber2, int amount) throws InsuffecientBalanceException,AccountNotFoundException {
		// TODO Auto-generated method stub
			try {
				validateAccount(accountNumber1);
				validateAccount(accountNumber2);
				checkSuffecientBalance(accountNumber1, amount);
				Account user1=userList.get(accountNumber1);
				Account user2=userList.get(accountNumber2);
				int temp1=user1.getBalance();
				int temp2=user2.getBalance();
				temp1=temp1-amount;
				temp2=temp2+amount;
				user1.setBalance(temp1);
				user2.setBalance(temp2);
			}
			catch(Exception e)
			{
				throw e;
			}
		
	}
	@Override
	public void checkSuffecientBalance(String accountNumber1, int amount) throws InsuffecientBalanceException {
		// TODO Auto-generated method stub
		try {
			Account user=userList.get(accountNumber1);
			if(user.getBalance()<amount)
			{
				throw new InsuffecientBalanceException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public void validateAccount(String accountNumber) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		try
		{
			if(!userList.containsKey(accountNumber))
			{
				throw new AccountNotFoundException();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	@Override
	public HashMap<String, Account> getAllAccounts() {
		// TODO Auto-generated method stub
		try
		{
			return (HashMap<String, Account>) userList;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}