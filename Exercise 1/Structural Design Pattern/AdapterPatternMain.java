// Define an interface for media players
interface MediaPlayer {
    /**
     * Play a media file of the given type.
     * @param audioType the type of media file (e.g., "MP3", "VLC", "MP4")
     * @param fileName the name of the media file
     */
    void play(String audioType, String fileName);
}

// Implement the MP3Player class, which implements the MediaPlayer interface
class MP3Player implements MediaPlayer {
    @Override
    public void play(String audioType, String fileName) {
        // Check if the audio type is MP3 and play the file
        if (audioType.equalsIgnoreCase("MP3")) {
            System.out.println("Playing MP3 file: " + fileName);
        }
    }
}

// Define an interface for advanced media players
interface AdvancedMediaPlayer {
    /**
     * Play a VLC file.
     * @param fileName the name of the VLC file
     */
    void playVLC(String fileName);

    /**
     * Play an MP4 file.
     * @param fileName the name of the MP4 file
     */
    void playMP4(String fileName);
}

// Implement the VLCPlayer class, which implements the AdvancedMediaPlayer interface
class VLCPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        // Play the VLC file
        System.out.println("Playing VLC file: " + fileName);
    }

    @Override
    public void playMP4(String fileName) {
        // Do nothing, as this player does not support MP4 files
    }
}

// Implement the MP4Player class, which implements the AdvancedMediaPlayer interface
class MP4Player implements AdvancedMediaPlayer {
    @Override
    public void playVLC(String fileName) {
        // Do nothing, as this player does not support VLC files
    }

    @Override
    public void playMP4(String fileName) {
        // Play the MP4 file
        System.out.println("Playing MP4 file: " + fileName);
    }
}

// Implement the MediaAdapter class, which implements the MediaPlayer interface
class MediaAdapter implements MediaPlayer {
    // Private field to store the advanced media player
    AdvancedMediaPlayer advancedMusicPlayer;

    /**
     * Constructor to initialize the media adapter with the given audio type.
     * @param audioType the type of audio (e.g., "VLC", "MP4")
     */
    public MediaAdapter(String audioType) {
        // Create an advanced media player based on the given audio type
        if (audioType.equalsIgnoreCase("VLC")) {
            advancedMusicPlayer = new VLCPlayer();
        } else if (audioType.equalsIgnoreCase("MP4")) {
            advancedMusicPlayer = new MP4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        // Play the media file using the advanced media player
        if (audioType.equalsIgnoreCase("VLC")) {
            advancedMusicPlayer.playVLC(fileName);
        } else if (audioType.equalsIgnoreCase("MP4")) {
            advancedMusicPlayer.playMP4(fileName);
        }
    }
}

// Main class to demonstrate the use of the adapter pattern
public class AdapterPatternMain {
    public static void main(String[] args) {
        // Create an MP3 player and play an MP3 file
        MediaPlayer player = new MP3Player();
        player.play("MP3", "song.mp3");  // Output: Playing MP3 file: song.mp3

        // Use the media adapter to play MP4 and VLC files
        MediaPlayer adapter = new MediaAdapter("MP4");
        adapter.play("MP4", "movie.mp4");  // Output: Playing MP4 file: movie.mp4

        adapter = new MediaAdapter("VLC");
        adapter.play("VLC", "video.vlc");  // Output: Playing VLC file: video.vlc
    }
}