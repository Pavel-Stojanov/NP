package lab8.MP3Player;

public class PlayingState implements IPlayerState{
    @Override
    public void pressPlay(MP3Player player) {
        System.out.println("Song is already playing");
    }

    @Override
    public void pressStop(MP3Player player) {
        System.out.printf("Song %d is paused\n",player.getCurrent());
        player.setState(new PausedState());
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
