package lab5.ChatSystem;

public class NoSuchRoomException extends Exception {
    public NoSuchRoomException(String roomName) {
        super("Room " + roomName + " does not exist.");
    }
}
