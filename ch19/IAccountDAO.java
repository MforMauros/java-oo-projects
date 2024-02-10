package gr.aueb.cf.ch19;

import gr.aueb.cf.ch18.model.Account;

public interface IAccountDAO {
    Account insert(Account account);
    Account update(double amount, Account account);
    Account getAccount(Long id);
    Account getAccount(String ssn);
    double getAccountBalance(Long id);
    boolean isSsnValid(String ssn);
}
