package com.capg.service;

import java.util.HashMap;

import Exceptions.*;
import com.capg.bean.*;

public interface AccountService {
	public String createAccount(Account user) throws IncorrectDetailsException, InvalidMailException, InvalidPhoneNumberException;
	public Account viewAccount(String AccountNumber) throws AccountNotFoundException;
	public void addMoney(String AccountNumber, int Amount) throws AccountNotFoundException;
	public void transfer(String AccountNumber1,String AccountNumber2, int Amount) throws InsuffecientBalanceException, AccountNotFoundException;
	public HashMap<String, Account> getAllAccounts();
}