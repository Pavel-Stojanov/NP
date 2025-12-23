package lab8.MP3Player;

public class Song {
    private String title;
    private String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return String.format("Song{title=%s, artist=%s}", title, artist);
    }
}
