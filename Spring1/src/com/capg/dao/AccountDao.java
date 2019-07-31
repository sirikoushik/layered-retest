package com.capg.dao;

import java.util.HashMap;

import Exceptions.AccountNotFoundException;
import Exceptions.InsuffecientBalanceException;
import com.capg.bean.*;

public interface AccountDao {
	public void createAccountDao(String AccountNumber, Account user);
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException;
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException;
	public void transfer(String AccountNumber1,String AccountNumber2, int Amount) throws InsuffecientBalanceException, AccountNotFoundException;
	public void validateAccount(String accountNumber) throws AccountNotFoundException;
	public void checkSuffecientBalance(String accountNumber1, int amount) throws InsuffecientBalanceException;
	public HashMap<String, Account> getAllAccounts();
	

}