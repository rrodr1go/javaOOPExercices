package model.exceptions;

public class DomainException extends RuntimeException {
    private String msg;

    public DomainException(String msg) {
        super(msg);
    }
}
