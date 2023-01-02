package Dao;
import  DatabaseConnection.*;
import  java.sql.*;
import java.util.*;
import ModelClasses.*;

import java.sql.Connection;

public class AudioDao {
    static Connection con;

         static   {
        try {
            con = EstablishConnection.connection() ;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public  static List<Audio> showAllAudio() throws SQLException {
             List<Audio> all=new ArrayList<>();
             Statement st=con.createStatement();
             ResultSet rs=st.executeQuery("select * from audio");
             while (rs.next()){
                 all.add((new Audio( rs.getInt(1),rs.getInt(2),rs.getInt(3), rs.getString(4))) );
             }
           return  all;
    }

    public static void displayAudio(List<Audio> ll) throws SQLException {
             List <Audio> dis=showAllAudio();

           System.out.printf("%25s%25s%25s%25s", "AudioID", "SongID", "PodcastID", "AudioType\n");
            dis.stream().forEach(a-> System.out.printf("%25s %25s %25s %25s\n", a.getAudioId(), a.getSongId(), a.getPodcastId(), a.getAudioType()));
            System.out.println();
         }

}
