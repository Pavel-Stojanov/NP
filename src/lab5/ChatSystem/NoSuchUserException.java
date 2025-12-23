package lab5.ChatSystem;

public class NoSuchUserException extends Exception {
    public NoSuchUserException(String userName) {
        super("User " + userName + " does not exist.");
    }
}