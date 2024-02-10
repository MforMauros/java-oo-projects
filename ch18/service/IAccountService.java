package gr.aueb.cf.ch18.service;

import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.ch18.service.exceptions.NegativeAmountException;
import gr.aueb.cf.ch18.service.exceptions.SsnNotValidException;

public interface IAccountService {
    AccountDTO deposit(double amount, AccountDTO account) throws NegativeAmountException;
    Account withdraw(double amount, String ssn) throws SsnNotValidException, InsufficientBalanceException;
}
