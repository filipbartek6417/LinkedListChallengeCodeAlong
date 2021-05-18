import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album ten = new Album("Ten", "Pearl Jam");
        ten.addSong("Once", 3.51);
        ten.addSong("Even Flow", 4.52);
        ten.addSong("Alive", 5.40);
        ten.addSong("Why Go", 3.20);
        ten.addSong("Black", 5.42);
        ten.addSong("Jeremy", 5.18);
        ten.addSong("Oceans", 2.41);
        ten.addSong("Porch", 3.30);
        ten.addSong("Garden", 4.58);
        ten.addSong("Deep", 4.18);
        ten.addSong("Release", 9.06);
        albums.add(ten);

        Album songsForTheDeaf = new Album("Songs for the Deaf", "Queens of the Stone Age");
        songsForTheDeaf.addSong("You think I ain't worth a dollar",3.12);
        songsForTheDeaf.addSong("No one knows",4.38);
        songsForTheDeaf.addSong("First it giveth",3.18);
        songsForTheDeaf.addSong("Song for the dead",5.52);
        songsForTheDeaf.addSong("The sky is fallin'",6.15);
        songsForTheDeaf.addSong("Six shooter",1.19);
        songsForTheDeaf.addSong("Hanging tree",3.06);
        songsForTheDeaf.addSong("Go with the flow",3.07);
        songsForTheDeaf.addSong("Gonna leave you",2.50);
        songsForTheDeaf.addSong("Do it again",4.04);
        songsForTheDeaf.addSong("God is in the radio",6.04);
        songsForTheDeaf.addSong("Another love song",3.16);
        songsForTheDeaf.addSong("Song for the deaf",6.12);
        songsForTheDeaf.addSong("Mosquito song",5.37);
        albums.add(songsForTheDeaf);

        LinkedList<Song> playlist = new LinkedList<Song>();
        albums.get(0).addToPlaylist("Even Flow", playlist);
        albums.get(1).addToPlaylist("No one knows", playlist);
        albums.get(1).addToPlaylist("God is in the radio", playlist);
        albums.get(0).addToPlaylist(3, playlist);
        albums.get(1).addToPlaylist(1, playlist);
        albums.get(0).addToPlaylist("Mosquito Song", playlist);
        albums.get(1).addToPlaylist(21, playlist);

        play(playlist);
    }

    private static void play(LinkedList<Song> playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> listIterator = playlist.listIterator();
        if (playlist.size() == 0){
            System.out.println("No songs in the playlist");
            return;
        }
        System.out.println("Now playing " + listIterator.next().toString());
        while (!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action){
                case 0:
                    System.out.println("Playlist complete.");
                    quit = true;
                    break;
                case 1:
                    if (!forward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        forward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("End of list");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Start of list");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                            forward = false;
                        } else {
                            System.out.println("Start of list");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                            forward = true;
                        } else {
                            System.out.println("End of list");
                        }
                    }
                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playlist.size() > 0){
                        listIterator.remove();
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next());
                        } else if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous());
                        }
                    }
                    break;
                default:
                    System.out.println("Choose a valid option, please");
            }
        }
    }

    private static void printMenu(){
        System.out.println("Available actions:\npress");
        System.out.println("0 - quit\n" +
                "1 - play the next song\n" +
                "2 - play the previous song\n" +
                "3 - replay the current song\n" +
                "4 - show the playlist\n" +
                "5 - show the menu\n" +
                "6 - delete current song");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> iterator = playlist.iterator();
        System.out.println("=============================");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        System.out.println("=============================");
    }
}
