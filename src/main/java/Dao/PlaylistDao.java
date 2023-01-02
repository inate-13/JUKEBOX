package Dao;
import  DatabaseConnection.*;
import ModelClasses.FinalPlaylist;
import ModelClasses.Playlist;

import  java.sql.*;
import java.util.*;

public class PlaylistDao {




   static Connection   conn;

    static   {
        try {
            conn = EstablishConnection.connection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
     }

    public static void addPlayList(String playlistName, int userId, int audioId) throws SQLException {
       // List<Playlist> playlists = new ArrayList<>();
        PreparedStatement preparedStatement = conn.prepareStatement("insert into playlist(playlist_name, user_id, audio_id) values(?, ?, ?)");

        preparedStatement.setString(1, playlistName);
        preparedStatement.setInt(2, userId);
        preparedStatement.setInt(3, audioId);

         int rs=preparedStatement.executeUpdate();
         if (rs>0){
             System.out.println(playlistName + " successfully created");
         }

    }

    public static List<Playlist> showPlaylist() throws SQLException {
        List<Playlist> playlist = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select * from playlist");
        while (rs.next())
        {
            playlist.add(new Playlist(rs.getInt(1),rs.getString(2), rs.getInt(3), rs.getInt(4)));
        }
        return playlist;
    }


    public static List<FinalPlaylist> searchPlayList(String name) throws SQLException {
        List<FinalPlaylist> finalPlaylists = new ArrayList<>();
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("select playlist.playlist_name, audio.audio_type, song.song_name, song.song_url, podcast.podcast_name, podcast.podcast_path \n" +
                "from playlist playlist\n" +
                "join audio on playlist.audio_id = audio.audio_id\n" +
                "left join song on song.song_id = audio.song_id \n" +
                "left join podcast on podcast.podcast_id = audio.podcast_id\n" +
                "where playlist.playlist_name = " + "'" + name + "'");

        while (rs.next())
        {
            finalPlaylists.add(new FinalPlaylist(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getString(5), rs.getString(6)));
        }
        return finalPlaylists;
    }

    public static void displayPlaylist(String name) throws SQLException {
        List<FinalPlaylist> finalPlaylistList = PlaylistDao.searchPlayList(name);
        PreparedStatement ps= conn.prepareStatement("select * from playlist where playlist_name=?");
        ps.setString(1,name);
        ResultSet fp=ps.executeQuery();


        System.out.println("SEARCH RESULT");
        System.out.printf("%25s%25s%25s%25s", "Playlist Name", "Audio Type", "Song Name", "Podcast Name");
        System.out.println();
       // for (FinalPlaylist fp : finalPlaylistList)
     //   {
        while (fp.next()){
            System.out.printf("%25s%25s%25s%25s\n", fp.getString("playlist_name"), fp.getInt(1), fp.getString(2), fp.getInt(3),fp.getInt(4));
            System.out.println();
            }
    }

    public static void deletePlaylistByName(String name) throws SQLException {
        PreparedStatement preparedStatement = conn.prepareStatement("delete from playlist where playlist_name = ?");
        preparedStatement.setString(1, name);
        int delete = preparedStatement.executeUpdate();
        if (delete > 0)
        {
            System.out.println("Playlist Deleted 😊");
        }
        else
        {
            System.out.println("Unable to delete ☹️");
        }
    }

}
