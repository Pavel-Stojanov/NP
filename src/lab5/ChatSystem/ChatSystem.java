package lab5.ChatSystem;

import java.util.*;
@SuppressWarnings("unchecked")
public class ChatSystem {
    private Map<String, ChatRoom> rooms;
    private Set<String> regUsers;

    public ChatSystem() {
        this.rooms = new TreeMap<>();
        this.regUsers = new HashSet<>();
    }

    public void addRoom(String roomName) {
        rooms.put(roomName, new ChatRoom(roomName));
    }

    public void removeRoom(String roomName) {
        rooms.remove(roomName);
    }

    public ChatRoom getRoom(String roomName) throws NoSuchRoomException {
        if (!rooms.containsKey(roomName)) {
            throw new NoSuchRoomException(roomName);
        }
        return rooms.get(roomName);
    }

    public void register(String userName) {
        regUsers.add(userName);
        rooms.values().stream()
                .min(Comparator.comparing(ChatRoom::numUsers)
                        .thenComparing(ChatRoom::getName))
                .ifPresent(chatRoom -> chatRoom.addUser(userName));
    }

    public void joinRoom(String userName, String roomName) throws NoSuchUserException, NoSuchRoomException {
        if (!regUsers.contains(userName)) {
            throw new NoSuchUserException(userName);
        }
        ChatRoom room = getRoom(roomName);
        room.addUser(userName);
    }

    public void registerAndJoin(String userName, String roomName) throws NoSuchUserException, NoSuchRoomException {
        regUsers.add(userName);
        joinRoom(userName, roomName);

    }

    public void leaveRoom(String username, String roomName) throws NoSuchUserException, NoSuchRoomException {
        if (!regUsers.contains(username)) {
            throw new NoSuchUserException(username);
        }
        ChatRoom room = getRoom(roomName);
        room.removeUser(username);
    }

    public void followFriend(String username, String friend_username) throws NoSuchUserException {
        if (!regUsers.contains(username)) {
            throw new NoSuchUserException(username);
        }
        if (!regUsers.contains(friend_username)) {
            throw new NoSuchUserException(friend_username);
        }
        for (ChatRoom room : rooms.values()) {
            if (room.hasUser(friend_username)) {
                room.addUser(username);
            }
        }
    }
}
