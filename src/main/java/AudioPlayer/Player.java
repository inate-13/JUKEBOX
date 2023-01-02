package AudioPlayer;
import Dao.SongDao;
import Dao.PodcastDao;
import ModelClasses.Song;
import ModelClasses.Podcast;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ListIterator;
import java.util.Scanner;

public class Player {
    static String status;
    Long currentframe;
    Clip clip;
    File file;
      String filePath;

    public Player() throws SQLException {
    }
    ListIterator<Song> songIterator = SongDao.showAllSongs().listIterator();
    ListIterator<Podcast> podcastIterator = PodcastDao.showAllPodcast().listIterator();

    public void filePlay(String songPath) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        this.filePath = songPath;
        Scanner sc = new Scanner(System.in);
        file = new File(filePath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void playSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        filePlay(songIterator.next().getSongPath());
        clip.start();
        status = "play";
    }
    public void playPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {

        filePlay(podcastIterator.next().getPodcastPath());
        clip.start();
        status = "play";
    }
    public void pause()
    {
        if (status.equals("pause"))
        {
            System.out.println("Audio is already paused");
        }
        //it obtains the current position in the audio data ,in microposition
        this.currentframe = this.clip.getMicrosecondPosition();
        System.out.println("Song stopped :: " + this.currentframe + " ms");
        clip.stop();
        status = "pause";
    }

    public void resume() throws UnsupportedAudioFileException, LineUnavailableException, IOException, SQLException {
        if (status.equals("play"))
        {
            System.out.println("Audio is already being played");
        }
        clip.close();
        resetAudioStream();
        clip.setMicrosecondPosition(currentframe);
        System.out.println(" play Song (Current Frame)  :: "+this.currentframe+ " ms.");
        clip.start();
    }

    public  void nextSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (songIterator.hasNext())
        {
            filePlay(songIterator.next().getSongPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("There is no more files");
        }

    }
    public  void nextPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (podcastIterator.hasNext())
        {
            filePlay(podcastIterator.next().getPodcastPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("There is no more files");
        }

    }
    public  void prevSong() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (songIterator.hasPrevious()) {
            filePlay(songIterator.previous().getSongPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("This is the first file");
        }
    }

    public  void prevPodcast() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        clip.stop();
        clip.close();

        if (podcastIterator.hasPrevious()) {
            filePlay(podcastIterator.previous().getPodcastPath());
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
        else
        {
            System.out.println("This is the first file");
        }
    }
    public void restart() throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException {
        clip.stop();
        clip.close();
        resetAudioStream();
        currentframe = 0L;
        clip.setMicrosecondPosition(0);
        clip.start();
    }
    public void stop(){
        System.out.println(" Current Frame Stop at :: "+this.currentframe+ " ms.");
        currentframe = 0L;
        clip.stop();

        clip.close();
    }


    public void resetAudioStream() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void gotoChoice(int c) throws IOException, LineUnavailableException, UnsupportedAudioFileException, SQLException {
        switch (c)
        {
            case 1:
                pause();
                break;
            case 2:
                resume();
                break;
            case 3:
                restart();
                break;
            case 4:
                stop();
                break;
            case 5:
                nextSong();
                break;
            case 6:
                prevSong();
                break;
            case 7:
                nextPodcast();
                break;
            case 8:
                prevPodcast();
                break;
            default:
                break;
        }

    }

}
