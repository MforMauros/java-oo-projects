package gr.aueb.cf.ch18.dto;

import gr.aueb.cf.ch18.model.User;

public class AccountDTO  extends BaseDTO{
    private String iban;
    private UserDTO holder;
    private double balance;

    public AccountDTO() {
    }
    public AccountDTO(String iban, UserDTO holder, double balance) {
        this.iban = iban;
        this.holder = holder;
        this.balance = balance;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public UserDTO getHolder() {
        return holder;
    }

    public void setHolder(UserDTO holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
