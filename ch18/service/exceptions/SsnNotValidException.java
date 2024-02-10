package gr.aueb.cf.ch18.service.exceptions;

public class SsnNotValidException extends Exception {
    private static final long serialVersionUID = 2342342L;

    public SsnNotValidException(String ssn) {
        super("Ssn " + ssn + " not valid");
    }
}
