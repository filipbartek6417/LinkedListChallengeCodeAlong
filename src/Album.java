import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songArrayList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songArrayList = new ArrayList<Song>();
    }

    public void addSong(String title, double duration){
        if (findSong(title) == null){
            this.songArrayList.add(new Song(title, duration));
        }
    }

    private Song findSong(String title){
        for (Song checkedSong : this.songArrayList){
            if (checkedSong.getTitle().equals(title)){
                return checkedSong;
            }
        }
        return null;
    }

    public void addToPlaylist(int trackNumber, LinkedList<Song> playlist){
        int index = trackNumber - 1;
        if (index >= 0 && index <= this.songArrayList.size()){
            playlist.add(this.songArrayList.get(index));
            return;
        }
        System.out.println("This album does not have a track number " + trackNumber);
    }

    public void addToPlaylist(String title, LinkedList<Song> playlist){
        Song checkedSong = findSong(title);
        if (checkedSong != null){
            playlist.add(checkedSong);
            return;
        }
        System.out.println("The song " + title + " is not in this album");
    }
}
