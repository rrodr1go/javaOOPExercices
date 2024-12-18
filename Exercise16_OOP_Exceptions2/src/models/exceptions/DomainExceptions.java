package models.exceptions;

public class DomainExceptions extends RuntimeException {
    private String msg;

    public DomainExceptions(String msg) {
        super(msg);
    }
}
