package lab8.MP3Player;


import java.util.List;

public class MP3Player {
    private List<Song> songs;
    private int current;
    private IPlayerState state;

    public MP3Player(List<Song> songs) {
        this.songs = songs;
        this.current = 0;
        this.state = new StoppedState();
    }

    public int getCurrent() {
        return current;
    }

    public void setState(IPlayerState state) {
        this.state = state;
    }

    public void pressPlay() {
        state.pressPlay(this);
    }

    public void printCurrentSong() {
        state.printCurrentSong(this);
    }

    public void pressStop() {
        state.pressStop(this);
    }

    public void pressFWD() {
        state.pressFWD(this);
    }

    public void pressREW() {
        state.pressREW(this);
    }

    public void nextSong(){
        current = (current+1)%songs.size();
    }

    public void prevSong(){
        current = (current-1+songs.size())%songs.size();
    }

    public Song getCurrentSong(){
        return songs.get(current);
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    @Override
    public String toString() {
        return String.format("MP3Player{currentSong = %d, songList = %s}",current,songs);
    }
}