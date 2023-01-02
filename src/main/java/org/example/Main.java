package org.example;
import Exceptions.PodcastNotFoundException;
import Exceptions.SongNotFoundException;
import ModelClasses.Playlist;
import ModelClasses.User;
import  Operations.*;
import  Dao.*;
import AudioPlayer.Player;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.sql.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException, UnsupportedAudioFileException, LineUnavailableException, IOException, SongNotFoundException, PodcastNotFoundException {
        int main = 0;
        do
        {
            Scanner sc = new Scanner(System.in);

        System.out.println("=====================================================");
        System.out.println(" Welcome to the JUKEBOX ");
        System.out.println("=====================================================\n");
        System.out.println("Enter the corresponding option number---\n");
        System.out.println("1.Display All avaliable Songs\n2.Display All avaliable Podcasts\n3.Create or see your own Playlist\n4.EXIT JUKEBOX");
        int option = sc.nextInt();

        switch (option) {
            case 1: {
                System.out.println("See or play song according to your choice-");
                System.out.println("1.See All Songs \n2.Songs by Song  Name\n3.Songs by Artist  Name\4.EXIT  ");
                int s = sc.nextInt();
                switch (s) {
                    case 1:
                        SongOperations.displaySong(SongDao.showAllSongs());
                        System.out.println("Do you want to play any song--\n1.YES\n2.Exit");
                        int ply = sc.nextInt();
                        if (ply == 1) {
                            Player player = new Player();
                            player.playSong();
                            while (true) {
                                System.out.printf("%25s%25s%25s%25s%25s%25s", "1.⏸️ PAUSE", "2.▶️ RESUME", "3.️RESTART", "4.⛔ STOP", "5.⏭️NEXT SONG", "6.⏮️PREVIOUS SONG");
                                System.out.println();
                                int c = sc.nextInt();
                                player.gotoChoice(c);
                                if (c == 4) {
                                    break;
                                }
                            }
                        }
                        break;
                    case 2:
                        System.out.println("ENter Song Name");
                        String str = sc.next();
                        SongOperations.SearchSongByName(str);
                        System.out.println("Do you want to play any song--\n1.YES\n2.Exit");
                        int ply1 = sc.nextInt();
                        if (ply1 == 1) {
                            Player player = new Player();
                            player.playSong();
                            while (true) {
                                System.out.printf("%25s%25s%25s%25s%25s%25s", "1.⏸️ PAUSE", "2.▶️ RESUME", "3.️RESTART", "4.⛔ STOP");
                                System.out.println();
                                int c = sc.nextInt();
                                player.gotoChoice(c);
                                if (c == 4) {
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Enter the artist name : ");
                        String artistName = sc.next();
                        SongOperations.SearchSongByArtist(artistName);
                        System.out.println("Do you want to play any song if yes, then type (1) and hit enter or type (0) to quit ");
                        int type = sc.nextInt();
                        if (type == 1) {
                            Player obj1 = new Player();
                            obj1.playSong();
                            sc = new Scanner(System.in);
                            while (true) {
                                System.out.printf("%25s%25s%25s%25s%25s%25s", "1.⏸️ PAUSE", "2.▶️ RESUME", "3.®️RESTART", "4.⛔ STOP", "5.⏭️NEXT SONG", "6.⏮️PREVIOUS SONG");
                                System.out.println();
                                int c = sc.nextInt();
                                obj1.gotoChoice(c);
                                if (c == 4)
                                    break;
                            }
                        }
                        break;
                    case 4:
                        return;

                    default:
                        System.out.println("Invalid Choice");


                }
            }
            break;


            case 2:
                System.out.println("Enter choice for Podasts-");
                System.out.println("1.Display All Podcasts\n2.Get Podcast by Celebrity Name\3.Exit");
                int ch = sc.nextInt();
                // sc.nextLine();
                switch (ch) {
                    case 1:
                        PodcastOperations.displayPodcasts(PodcastDao.showAllPodcast());
                        System.out.println("Press 1 if you want to play any podcast");
                        int cho = sc.nextInt();
                        if (cho == 1) {

                            Player obj1 = new Player();
                            obj1.playSong();
                            sc = new Scanner(System.in);
                            while (true) {
                                System.out.printf("%25s%25s%25s%25s%25s%25s", "1.⏸️ PAUSE", "2.▶️ RESUME", "3.®️RESTART", "4.⛔ STOP", "5.⏭️NEXT SONG", "6.⏮️PREVIOUS SONG");
                                System.out.println();
                                int c = sc.nextInt();
                                obj1.gotoChoice(c);
                                if (c == 4)
                                    break;
                            }
                        }
                        break;
                    case 2:
                        System.out.println("Enter the podcast name you want to search : ");
                        String name = sc.next();
                        PodcastOperations.displayPodcastsByName(name);
                        System.out.println("Do you want to play any song if yes, then type (1) and hit enter or type (0) to quit ");
                        int chh = sc.nextInt();
                        if (chh == 1) {
                            Player obj1 = new Player();
                            obj1.playPodcast();
                            sc = new Scanner(System.in);
                            while (true) {
                                System.out.printf("%25s%25s%25s%25s", "1.   PAUSE", "2.  RESUME", "3.  RESTART", "4.⛔ STOP");
                                System.out.println();
                                int c = sc.nextInt();
                                obj1.gotoChoice(c);
                                if (c == 4) {
                                    break;
                                }
                            }
                        }
                        break;
                    case 3:
                        return;

                    default:
                        System.out.println("Invalid Choice");
                        break;

                }
                break;


            case 3:
                System.out.println("Enter corresponding answer--\n1.Create a Playlist for you\n2.Delete a Playlist \n3.See your own Playlist");
                int se = sc.nextInt();
                switch (se) {
                    case 1:
                        System.out.println("+++++  AUDIO table +++++");
                        AudioDao.displayAudio(AudioDao.showAllAudio());
//                        System.out.println("+++++  USER table +++++");
//                       UserDao.displayUser(UserDao.showAllUser());

                        Scanner scanner = new Scanner(System.in);
                        System.out.println("Enter playlist name : ");
                        String name = scanner.next();
                        System.out.println("Enter the user Id : ");
                        int userId = scanner.nextInt();
                        System.out.println("Enter the audio Id : ");
                        int audioId = scanner.nextInt();

                          PlaylistDao.addPlayList(name, userId, audioId);
                      //  list.stream().forEach(f-> System.out.printf("%25s %25s %25s %25s\n",f.getPlaylistId(),f.getPlaylistName(),f.getUserId(),f.getAudioId()));

                        break;

                    case 2:

                        System.out.println("Enter the playlist name you want to delete");
                        String st = sc.next();
                        PlaylistDao.deletePlaylistByName(st);

                    case 3:
                        System.out.println("Enter the playlist name");
                        Scanner playsc = new Scanner(System.in);
                        String playName = playsc.next();
//                        ListIterator<Playlist> playlistListIterator = PlaylistDao.showPlaylist().listIterator();
//                        if (playlistListIterator.next().getPlaylistName().equals(playName))
//                        {
                            PlaylistDao.displayPlaylist(playName);
                            System.out.println("Do you want to play if yes, then type (1) and hit enter Or type (0) to quit ");
                            String type = sc.next();
                            if (type.equals("1")) {
                                Player obj1 = new Player();
                                obj1.playSong();
                                sc = new Scanner(System.in);
                                while (true) {
                                    System.out.printf("%25s%25s%25s%25s%25s%25s", "1.⏸️ PAUSE", "2.▶️ RESUME", "3.®️RESTART", "4.⛔ STOP", "5.⏭️NEXT PODCAST", "6.⏮️PREVIOUS PODCAST");
                                    System.out.println();
                                    int c = sc.nextInt();
                                    obj1.gotoChoice(c);
                                    if (c == 4) {
                                        break;
                                    }
                                }

                        }else
                        {
                            System.out.println("No playlist  ️");
                        }
                        break;
                    default:
                        System.out.println("Invalid Choice  ️");

                }
                break;

        }
        System.out.println("DO you want to return to Main Menu --press\n1.Main menu \2.Exit");
        main = sc.nextInt();
    }while(main==1);
        System.out.println("Thank You for using JUKEBOX.");
 }
}