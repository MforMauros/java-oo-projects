package gr.aueb.cf.ch12.bankapp.model;

import gr.aueb.cf.ch12.bankapp.Account;

/**
 * Represents a joint bank account shared by two individuals. This class allows both account holders to deposit and withdraw funds from a shared balance.
 */
public class JointAccount {
    private Account primaryAccountHolder;
    private Account secondaryAccountHolder;
    private double balance;

    /**
     * Constructs a JointAccount with two specified accounts. The initial balance is the sum of the balances of both accounts.
     *
     * @param account1 The first account holder's account.
     * @param account2 The second account holder's account.
     */
    public JointAccount(Account account1, Account account2) {
        this.primaryAccountHolder = account1;
        this.secondaryAccountHolder = account2;
        this.balance = account1.getBalance() + account2.getBalance();
    }

    /**
     * Deposits the specified amount into the joint account.
     *
     * @param amount The amount to deposit.
     * @throws Exception If the amount is negative.
     */
    public void deposit(double amount) throws Exception {
        if (amount < 0) {
            throw new Exception("Negative amount error");
        }
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the joint account, if the SSN matches one of the account holders and sufficient balance exists.
     *
     * @param amount The amount to withdraw.
     * @param ssn The Social Security Number associated with the account holder.
     * @throws Exception If the SSN is invalid, the amount is negative, or the balance is insufficient.
     */
    public void withdraw(double amount, String ssn) {
        try {
            if (!primaryAccountHolder.isSsnValid(ssn) && !secondaryAccountHolder.isSsnValid(ssn)) {
                throw new Exception("Invalid SSN");
            }
            if (amount < 0) {
                throw new Exception("Negative amount error");
            }

            if (amount > balance) {
                throw new Exception("Insufficient balance");
            }

            balance -= amount;
            System.out.println("Acount: " + ssn + " withdrew " + amount);
        } catch (Exception e) {
            System.out.println("Exception message: " + e.getMessage());
            balance -= amount;
        }

    }

    /**
     * Returns a string representation of the joint account, including details of both account holders and the current balance.
     *
     * @return A string representation of the joint account.
     */
    public String accountToString() {
        return "Primary Holder: " + primaryAccountHolder.accountToString() +
                ", Secondary Holder: " + secondaryAccountHolder.accountToString() +
                ", Balance: " + balance;
    }

    // Getters and setters for balance and account holder details
    // ...

    /**
     * Gets the primary account holder's account details.
     *
     * @return The primary account holder's account.
     */
    public Account getPrimaryAccountHolder() {
        return primaryAccountHolder;
    }

    /**
     * Gets the secondary account holder's account details.
     *
     * @return The secondary account holder's account.
     */
    public Account getSecondaryAccountHolder() {
        return secondaryAccountHolder;
    }

    /**
     * Gets the current balance of the joint account.
     *
     * @return The current balance.
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Sets the balance of the joint account.
     *
     * @param balance The balance to set.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
