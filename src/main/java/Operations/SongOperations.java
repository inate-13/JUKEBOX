package Operations;
import Dao.SongDao;
import Exceptions.SongNotFoundException;
import  ModelClasses.Song;
import java.sql.*;
import  java.util.List;

import DatabaseConnection.*;


public class SongOperations {
    static  Connection con;
    {
        try {
            con= EstablishConnection.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public static void displaySong(List<Song> songList) {
        System.out.printf("%25s%25s%25s%25s%25s%25s", "SongID", "SongName", "SongDuration", "Genre", "AlbumName", "ArtistName");
        System.out.println();
        for(Song s: songList)
        {
            System.out.printf("%25s%25s%25s%25s%25s%25s", s.getSongId(), s.getSongName(), s.getDuration(), s.getGenre(), s.getAlbumName(), s.getArtistName());
            System.out.println();
        }
     }

     public  static void sortSong() throws SQLException {
        List<Song> songList=SongDao.sort();
         System.out.printf("%25s%25s%25s%25s%25s%25s", "SongID", "SongName", "SongDuration", "Genre", "AlbumName", "ArtistName");

         songList.stream().forEach(s-> System.out.printf("%25s%25s%25s%25s%25s%25s", s.getSongId(), s.getSongName(), s.getDuration(), s.getGenre(), s.getAlbumName(), s.getArtistName()));
         System.out.println();
     }
     public  static void SearchSongByName(String name) throws SQLException, SongNotFoundException {
        List<Song> songList=SongDao.searchSongByArtistName(name);
         System.out.println("SEARCH RESULT");
         System.out.printf("%25s%25s%25s%25s%25s%25s", "SongID", "SongName", "SongDuration", "Genre", "AlbumName", "ArtistName");

         songList.stream().forEach(s-> System.out.printf("%25s%25s%25s%25s%25s%25s", s.getSongId(), s.getSongName(), s.getDuration(), s.getGenre(), s.getAlbumName(), s.getArtistName()));
         System.out.println();
     }
     public  static void SearchSongByAlbum(String name) throws SQLException, SongNotFoundException {
        List<Song> songList=SongDao.searchSongByAlbumName(name);
         System.out.println("SEARCH RESULT");
         System.out.printf("%25s%25s%25s%25s%25s%25s", "SongID", "SongName", "SongDuration", "Genre", "AlbumName", "ArtistName");

         songList.stream().forEach(s-> System.out.printf("%25s%25s%25s%25s%25s%25s", s.getSongId(), s.getSongName(), s.getDuration(), s.getGenre(), s.getAlbumName(), s.getArtistName()));
         System.out.println();
     }
     public  static void SearchSongByArtist(String name) throws SQLException, SongNotFoundException {
        List<Song> songList=SongDao.searchSongByArtistName(name);
         System.out.println("SEARCH RESULT");
         System.out.printf("%25s%25s%25s%25s%25s%25s", "SongID", "SongName", "SongDuration", "Genre", "AlbumName", "ArtistName");

         songList.stream().forEach(s-> System.out.printf("%25s%25s%25s%25s%25s%25s", s.getSongId(), s.getSongName(), s.getDuration(), s.getGenre(), s.getAlbumName(), s.getArtistName()));
         System.out.println();
     }
}
