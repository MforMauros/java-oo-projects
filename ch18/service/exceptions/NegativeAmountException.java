package gr.aueb.cf.ch18.service.exceptions;

public class NegativeAmountException extends Exception{
    private static final long serialVersionUID = 123455L;

    public  NegativeAmountException() {
        super("Amount insufficient");
    }

    public NegativeAmountException(double amount) {
        super("Amount" + amount + " is not sufficient");
    }
}
