package Dao;
import  ModelClasses.Podcast;
import java.sql.*;
import java.util.ArrayList;
import  java.util.List;
import  Exceptions.PodcastNotFoundException;
import DatabaseConnection.*;


public class PodcastDao {
    static  Connection con;
   static  {
        try {
                con= EstablishConnection.connection();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

    }
    public  static  List<Podcast> showAllPodcast()throws SQLException{
        List<Podcast> list=new ArrayList<>();
        Statement  ps=con.createStatement();
        ResultSet rs=ps.executeQuery("select * from podcast");
        while (rs.next()){
            list.add(new Podcast(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));

        }
        return list;
    }

    public  static  List<Podcast>  searhByName(String name) throws SQLException, PodcastNotFoundException {
        List<Podcast> allPodcast = new ArrayList<>();

        PreparedStatement ps = con.prepareStatement("select * from podcast where podcast_name =?");
        ps.setString( 1 ,name);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            while (rs.next()) {
                allPodcast.add(new Podcast(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5)));
            }
            return allPodcast;
        } else throw new PodcastNotFoundException("Podcast not found");
    }




}
