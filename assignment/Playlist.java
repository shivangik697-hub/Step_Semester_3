package week7Assignment;

import java.util.Arrays;

/**
 * Problem 2: The Playlist
 * Scenario: A music app lets you build a playlist of songs.
 */
public class Playlist {
    private final String[] songs;
    private int songCount;

    public Playlist(int capacity) {
        this.songs = new String[capacity];
        this.songCount = 0;
    }

    public boolean addSong(String songTitle) {
        if (songCount < songs.length) {
            songs[songCount] = songTitle;
            songCount++;
            return true;
        }
        return false;
    }

    public int getSongCount() {
        return songCount;
    }

    public String[] getSongs() {
        return Arrays.copyOf(songs, songCount);
    }

    public static void main(String[] args) {
        Playlist p = new Playlist(10);
        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();
        System.out.println("Returned copy: " + Arrays.toString(copy));

        copy[0] = "Hacked";
        System.out.println("Modified copy[0] to 'Hacked'. Real playlist first song: " + p.getSongs()[0]);
        System.out.println("p.getSongCount() -> " + p.getSongCount());
    }
}