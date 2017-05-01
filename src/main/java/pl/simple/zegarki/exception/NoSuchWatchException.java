package pl.simple.zegarki.exception;

public class NoSuchWatchException extends Exception {
    private static final long serialVersionUID = -8555511054434242536L;
	public NoSuchWatchException(String string) {
		super(string);
	}
	public NoSuchWatchException() {
	}
}
