package gr.aueb.cf.ch19;


import gr.aueb.cf.ch18.model.Account;
import java.util.HashMap;
import java.util.Map;

public class AccountDaoImpl implements IAccountDAO {
    private static final Map<Long, Account> accounts = new HashMap<>();

    @Override
    public Account insert(Account account) {
        accounts.put(account.getId(), account);
        return account;
    }

    @Override
    public Account update(double amount, Account account) {
        if(accounts.containsKey(account.getId())) {
            account.setBalance(amount);
            accounts.put(account.getId(), account);
        }
        return account;
    }

    @Override
    public Account getAccount(Long id) {
        return accounts.get(id);
    }

    @Override
    public Account getAccount(String ssn) {
        return accounts.values().stream()
                .filter(c -> c.getHolder().getSsn().equals(ssn))
                .findFirst()
                .orElse(null);
    }

    @Override
    public double getAccountBalance(Long id) {
        Account account = accounts.get(id);
        return account != null ? account.getBalance() : 0;
    }

    @Override
    public boolean isSsnValid(String ssn) {
        return accounts.values().stream()
                .anyMatch(c -> c.getHolder().getSsn().equals(ssn));
    }
}
