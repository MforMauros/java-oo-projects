package gr.aueb.cf.ch12.bankapp.model;

import gr.aueb.cf.ch12.bankapp.Account;

/**
 * This class represents an overdraft account which allows the account holder to withdraw more than the current balance up to a certain limit.
 */
public class OverdraftAccount {
    private Account account;
    private double overdraftLimit;
    private double overdraftBalance;

    /**
     * Default constructor for creating an instance of OverdraftAccount.
     */
    public OverdraftAccount() {
    }

    /**
     * Constructs an OverdraftAccount with a specified account, overdraft limit, and initial overdraft balance.
     *
     * @param account The underlying account for this overdraft account.
     * @param overdraftLimit The maximum overdraft amount allowed.
     * @param overdraftBalance The initial overdraft balance.
     */
    public OverdraftAccount(Account account, double overdraftLimit, double overdraftBalance) {
        this.account = account;
        this.overdraftLimit = overdraftLimit;
        this.overdraftBalance = overdraftBalance;
    }

    /**
     * Gets the underlying account.
     *
     * @return The account associated with this overdraft account.
     */
    public Account getAccount() {
        return account;
    }

    /**
     * Sets the underlying account.
     *
     * @param account The account to associate with this overdraft account.
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * Gets the overdraft limit.
     *
     * @return The overdraft limit for this account.
     */
    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets the overdraft limit.
     *
     * @param overdraftLimit The overdraft limit to set.
     */
    public void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }

    /**
     * Gets the current overdraft balance.
     *
     * @return The current overdraft balance of this account.
     */
    public double getOverdraftBalance() {
        return overdraftBalance;
    }

    /**
     * Sets the overdraft balance.
     *
     * @param overdraftBalance The overdraft balance to set.
     */
    public void setOverdraftBalance(double overdraftBalance) {
        this.overdraftBalance = overdraftBalance;
    }

    /**
     * Withdraws an amount from the account considering the overdraft limit.
     * If the withdrawal amount exceeds the account balance, the overdraft balance is used.
     *
     * @param amount The amount to withdraw.
     * @param ssn The Social Security Number of the account holder.
     * @throws Exception If the SSN is invalid, the amount is negative, or the overdraft limit is exceeded.
     */
    public void overdraftWithdraw(double amount, String ssn)  {
        double overdraftNeeded = 0.0;
        try {
            if (!account.isSsnValid(ssn)) {
                throw new Exception("Invalid SSN");
            }
            if (amount < 0) {
                throw new Exception("Negative amount error");
            }

            double potentialBalance = account.getBalance() - amount;
            if (potentialBalance < 0) {
                overdraftNeeded = -potentialBalance;
                if (overdraftNeeded > overdraftLimit - overdraftBalance) {
                    throw new Exception("Overdraft limit exceeded");
                }
                overdraftBalance += overdraftNeeded;
                account.setBalance(0);
            } else {
                account.setBalance(potentialBalance);
            }
        } catch (Exception e) {
            System.out.println("Exception message: " + e.getMessage());
            overdraftBalance += overdraftNeeded;
            account.setBalance(0);
        }
    }

    /**
     * Converts the overdraft account details to a string format.
     *
     * @return A string representation of the overdraft account including account details, overdraft limit, and overdraft balance.
     */
    public String OverdraftConvertToString() {
        return account.accountToString() + ", Overdraft Limit: " + overdraftLimit + ", Overdraft Balance: " + overdraftBalance;
    }

}
