package vezbi.ArchiveStore;

public class NonExistingItemException extends Exception {
    public NonExistingItemException(String message) {
        super(message);
    }
}
