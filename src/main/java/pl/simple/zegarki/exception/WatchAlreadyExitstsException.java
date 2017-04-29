package pl.simple.zegarki.exception;

public class WatchAlreadyExitstsException extends Exception {
    private static final long serialVersionUID = -4576295597218170159L;

    public WatchAlreadyExitstsException() {     
    }

    public WatchAlreadyExitstsException(String message, Throwable cause, boolean enableSuppression,
            boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public WatchAlreadyExitstsException(String message, Throwable cause) {
        super(message, cause);
    }

    public WatchAlreadyExitstsException(String message) {
        super(message);
    }

    public WatchAlreadyExitstsException(Throwable cause) {
        super(cause);
    }
    
}
