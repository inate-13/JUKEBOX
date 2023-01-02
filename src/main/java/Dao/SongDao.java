package Dao;
import  DatabaseConnection.*;
import java.sql.*;
import java.util.ArrayList;
import  java.util.List;
import java.util.stream.Collectors;

import Exceptions.SongNotFoundException;
import ModelClasses.Song;


public class SongDao {
    static Connection con;
     static {
            try {
                con= EstablishConnection.connection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
     }


     public static List<Song> showAllSongs()throws SQLException{
         List<Song> allSong = new ArrayList<>();
         Statement statement = con.createStatement();
         ResultSet rs = statement.executeQuery("select * from song");
         while (rs.next())
         {
             allSong.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));
         }
         return allSong;
     }


    public static List<Song> searchSongByName(String name) throws SQLException, SongNotFoundException {
        List<Song> allSong = new ArrayList<>();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from song where song_name = " + "'" + name + "'");

        while (rs.next())
        {
            allSong.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

        }

        if (allSong.isEmpty())
        {
            throw new SongNotFoundException("Song not found");      //throws custom exception
        }
        else
        {
            return allSong;
        }
    }

    public static List<Song> searchSongByArtistName(String name) throws SQLException, SongNotFoundException {
        List<Song> allSong = new ArrayList<>();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from song where artist_name = " + "'" + name + "'");

        while (rs.next())
        {
            allSong.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

        }
        //Returns true if this list contains no elements.
        if (allSong.isEmpty())
        {
            throw new SongNotFoundException("Song not found");      //throws custom exception
        }
        else
        {
            return allSong;
        }
    }
    public static List<Song> searchSongByAlbumName(String name) throws SQLException, SongNotFoundException {
        List<Song> allSong = new ArrayList<>();
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery("select * from song where album_name = " + "'" + name + "'");

        while (rs.next())
        {
            allSong.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));

        }
        //Returns true if this list contains no elements.
        if (allSong.isEmpty())
        {
            throw new SongNotFoundException("Song not found");      //throws custom exception
        }
        else
        {
            return allSong;
        }
    }

    public static List<Song> sort() throws SQLException {
        List<Song>list=SongDao.showAllSongs().stream().sorted().collect(Collectors.toList());
        return list;
    }

}
