import java.util.Scanner;

class song {
    private String title;
    private String artist;
    private double duration;

    public song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public double getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return this.title + " by: " + this.artist + " Duration: " + this.duration;
    }
}

class Node {
    private song song;
    private Node next;

    public Node(song song) {
        this.song = song;
        this.next = null;
    }

    public song getSong() {
        return song;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setSong(song song) {
        this.song = song;
    }
}

class playList {
    private Node head;
    private int size;

    public playList() {
        this.head = null;
        this.size = 0;
    }

    public void addSong(song song) {
        Node newSong = new Node(song);

        if (head == null) {
            head = newSong;
        } else {
            Node current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newSong);
        }
        size++;
    }

    // Display the playlist
    public void displayPlaylist() {
        if (head == null) {
            System.out.println("Playlist is empty.");
            return;
        }
        Node current = head;
        int position = 1;
        while (current != null) {
            System.out.println(position + ". " + current.getSong().toString());
            current = current.getNext();
            position++;
        }
    }
}

public class Songs_App {
    public static void main(String[] args) {
        playList old = new playList();
        Scanner s = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nMusic playList manager: ");
            System.out.println("1. Add song");
            System.out.println("2. display");
            System.out.println("3. Quit");
            System.out.print("Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter the song title: ");
                    String title = s.nextLine();

                    System.out.print("Enter the song artist: ");
                    String artist = s.nextLine();

                    System.out.print("Enter duration in seconds: ");
                    double duration;
                    try {
                        duration = Double.parseDouble(s.nextLine());
                        if (duration < 0)
                            throw new NumberFormatException();
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid duration. Must be a non-negative number.");
                        break;
                    }
                    old.addSong(new song(title, artist, duration)); // Fixed: use 'old' instance
                    System.out.println("Song added.");
                    break;
                case 2:
                    old.displayPlaylist(); // Fixed: use 'old' instance
                    break;

                case 3:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1 or 2.");
                    break;
            }
        }
        s.close();
    }
}
