package gr.aueb.cf.ch18.model;

import java.util.Objects;

public class Account extends AbstractEntity{
    private String iban;
    private User holder;
    private double balance;

    public Account() {
    }

    public Account(String iban, User holder, double balance) {
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
    }

    public Account(Account account) {
        this.iban = account.getIban();
        this.holder = account.getHolder();
        this.balance = account.getBalance();
    }

    public String getIban() {
        return iban;
    }
    public void setIban(String iban) {
        this.iban = iban;
    }
    public User getHolder() {
        return holder;
    }
    public void setHolder(User holder) {
        this.holder = holder;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "iban='" + iban + '\'' +
                ", holder=" + holder +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(balance, account.balance) == 0 && Objects.equals(iban, account.iban) && Objects.equals(holder, account.holder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iban, holder, balance);
    }
}
