package lab8.MP3Player;

public class StoppedState implements IPlayerState{
    @Override
    public void pressPlay(MP3Player player) {
        System.out.printf("Song %d is playing\n",player.getCurrent());
        player.setState(new PlayingState());
    }

    @Override
    public void pressStop(MP3Player player) {
        System.out.println("Songs are already stopped");
    }

    @Override
    public void pressFWD(MP3Player player) {
        System.out.println("Forward...");
        player.nextSong();
        player.setState(new PausedState());
    }

    @Override
    public void pressREW(MP3Player player) {
        System.out.println("Reward...");
        player.prevSong();
        player.setState(new PausedState());
    }

    @Override
    public void printCurrentSong(MP3Player player) {
        System.out.println(player.getCurrentSong());

    }
}
