package gr.aueb.cf.ch18.service.exceptions;

import gr.aueb.cf.ch18.model.Account;

public class OverdraftAccountException extends Exception{
    private static final long serialVersionUID = 67235093L;

    public OverdraftAccountException(Account account) {
        super("The account with ssn "+account.getHolder().getSsn() + " is overdrafted.");
    }
}
