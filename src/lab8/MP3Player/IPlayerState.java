package lab8.MP3Player;

public interface IPlayerState {
    void pressPlay(MP3Player player);
    void pressStop(MP3Player player);
    void pressFWD(MP3Player player);
    void pressREW(MP3Player player);
    void printCurrentSong(MP3Player player);
}
