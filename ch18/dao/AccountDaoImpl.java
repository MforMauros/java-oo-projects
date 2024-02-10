package gr.aueb.cf.ch18.dao;

import gr.aueb.cf.ch18.model.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccountDaoImpl implements IAccountDAO{
    private static final List<Account> accounts = new ArrayList<>();

    @Override
    public Account insert(Account account) {
        accounts.add(account);
        return account;
    }

    @Override
    public Account update(double amount, Account account) {
        int index = accounts.indexOf(account);
        account.setBalance(amount);
        accounts.set(index, account);
        return account;
    }

    @Override
    public Account getAccount(Long id) {
        Optional<Account> account = accounts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        return account.orElse(null);
    }

    @Override
    public Account getAccount(String ssn) {
        Optional<Account> account = accounts.stream()
                .filter(c -> c.getHolder().getSsn().equals(ssn))
                .findFirst();

        return account.orElse(null);
    }

    @Override
    public double getAccountBalance(Long id) {
        double balance = 0;
        Optional<Account> account = accounts.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
        if (account.isPresent()) {
            balance =  account.get().getBalance();
        }
        return balance;
    }

    @Override
    public boolean isSsnValid(String ssn) {
        return accounts.stream().anyMatch(c -> c.getHolder().getSsn().equals(ssn));
    }
}
