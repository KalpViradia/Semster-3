import java.util.Scanner;

class MusicPlayer {
    class Song {
        String name;
        Song prev;
        Song next;

        Song(String name) {
            this.name = name;
            this.prev = null;
            this.next = null;
        }
    }

    Song currentSong;

    public void addSong(String name) {
        Song newSong = new Song(name);
        if (currentSong == null) {
            currentSong = newSong;
            currentSong.next = currentSong;
            currentSong.prev = currentSong;
        } else {
            Song last = currentSong.prev;
            last.next = newSong;
            newSong.prev = last;
            newSong.next = currentSong;
            currentSong.prev = newSong;
        }
        System.out.println("Added: " + name);
    }

    public void removeCurrentSong() {
        if (currentSong == null) {
            System.out.println("No song to remove.");
            return;
        }
        System.out.println("Removing: " + currentSong.name);
        if (currentSong.next == currentSong) { // Only one song in the playlist
            currentSong = null;
        } else {
            Song prevSong = currentSong.prev;
            Song nextSong = currentSong.next;
            prevSong.next = nextSong;
            nextSong.prev = prevSong;
            currentSong = nextSong; // Move to the next song
        }
    }

    public void playCurrentSong() {
        if (currentSong == null) {
            System.out.println("No song to play.");
        } else {
            System.out.println("Playing: " + currentSong.name);
        }
    }

    public void nextSong() {
        if (currentSong != null) {
            currentSong = currentSong.next;
            playCurrentSong();
        } else {
            System.out.println("No next song to play.");
        }
    }

    public void previousSong() {
        if (currentSong != null) {
            currentSong = currentSong.prev;
            playCurrentSong();
        } else {
            System.out.println("No previous song to play.");
        }
    }

    public void displayPlaylist() {
        if (currentSong == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        System.out.println("Playlist:");
        Song temp = currentSong;
        do {
            System.out.println(temp.name);
            temp = temp.next;
        } while (temp != currentSong);
    }
}

public class Lab75 {
    public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Music Player Options:");
            System.out.println("1. Add song");
            System.out.println("2. Remove current song");
            System.out.println("3. Play current song");
            System.out.println("4. Play next song");
            System.out.println("5. Play previous song");
            System.out.println("6. Display playlist");
            System.out.println("7. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String songName = sc.nextLine();
                    player.addSong(songName);
                    break;
                case 2:
                    player.removeCurrentSong();
                    break;
                case 3:
                    player.playCurrentSong();
                    break;
                case 4:
                    player.nextSong();
                    break;
                case 5:
                    player.previousSong();
                    break;
                case 6:
                    player.displayPlaylist();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
