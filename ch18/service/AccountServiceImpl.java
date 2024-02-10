package gr.aueb.cf.ch18.service;

import gr.aueb.cf.ch18.dao.IAccountDAO;
import gr.aueb.cf.ch18.dto.AccountDTO;
import gr.aueb.cf.ch18.model.Account;
import gr.aueb.cf.ch18.service.exceptions.InsufficientBalanceException;
import gr.aueb.cf.ch18.service.exceptions.NegativeAmountException;
import gr.aueb.cf.ch18.service.exceptions.SsnNotValidException;

public class AccountServiceImpl implements IAccountService{
    private final IAccountDAO iAccountDao;

    public AccountServiceImpl(IAccountDAO account) {
        this.iAccountDao = account;
    }

    @Override
    public AccountDTO deposit(double amount, AccountDTO account) throws NegativeAmountException {
        try {
            if (amount < 0) {
                throw new NegativeAmountException(amount);
            }
            account.setBalance(amount);
        } catch (NegativeAmountException e) {
            System.err.println("Negative amount exception");
            throw e;
        }
        return account;
    }

    @Override
    public Account withdraw(double amount, String ssn) throws SsnNotValidException, InsufficientBalanceException{
        Account userAccountToWithdrawFrom = iAccountDao.getAccount(ssn);
        try {
            if (!iAccountDao.isSsnValid(ssn)) {
                throw  new SsnNotValidException(ssn);
            }

            if (amount > userAccountToWithdrawFrom.getBalance()) {
                throw new InsufficientBalanceException(userAccountToWithdrawFrom.getBalance(), amount);
            }

            userAccountToWithdrawFrom.setBalance(userAccountToWithdrawFrom.getBalance() - amount);

        } catch (InsufficientBalanceException | SsnNotValidException e) {
            System.err.println("Error " + e.getMessage());
            throw e;
        }
        return userAccountToWithdrawFrom;
    }

}
