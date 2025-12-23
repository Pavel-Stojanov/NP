package lab5.ChatSystem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class ChatRoom {
    private String name;
    private Set<User> users;

    public ChatRoom(String name) {
        this.name = name;
        this.users = new TreeSet<>(Comparator.comparing(User::getUsername));
    }

    public void addUser(String username) {
        users.add(new User(username));
    }

    public void removeUser(String username) {
        users.remove(new User(username));
    }

    public boolean hasUser(String username) {
        return users.contains(new User(username));
    }

    public int numUsers() {
        return users.size();
    }

    public String getName() {
        return name;
    }

    public Set<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append("\n");
        if (users.isEmpty()) {
            sb.append("EMPTY\n");
        } else {
            for (User user : users) {
                sb.append(user.getUsername()).append("\n");
            }
        }
        return sb.toString();
    }
}
