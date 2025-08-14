package exceptions;

public class InsuficientFundsException extends Exception{

    /**
     * Constructs a new exception with {@code null} as its detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     */
    public InsuficientFundsException() {
        super("Insufficient Funds in the account");
    }
    public InsuficientFundsException(String message) {
        super(message);
    }
}
