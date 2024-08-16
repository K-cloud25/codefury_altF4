package exceptions;

// Root Parent Exception Class : Root User Defined Exceptions

public class ApplicationExceptions extends Exception{


    public ApplicationExceptions() {
    }

    public ApplicationExceptions(String message) {
        super(message);
    }

    public ApplicationExceptions(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationExceptions(Throwable cause) {
        super(cause);
    }

    public ApplicationExceptions(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
