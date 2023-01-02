package Operations;
import Dao.PodcastDao;
import  ModelClasses.Podcast;
import java.sql.*;
import  java.util.List;

import  Exceptions.PodcastNotFoundException;
import DatabaseConnection.*;


public class PodcastOperations {
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

    public  static  void displayPodcasts(List<Podcast> list){
        System.out.printf("%25s%25s%25s%25s", "PodcastID", "PodcastName", "CelebrityName", "PublishDate\n");
        list.stream().forEach(f->System .out.printf("%25s%25s%25s%25s\n", f.getPodcastId(),f.getPodcastName(),f.getCelebrityName(),f.getPublishDate() ));
        System.out.println();
    }

    public  static  void displayPodcastsByName(String name) throws SQLException, PodcastNotFoundException {
        List<Podcast> list= PodcastDao.searhByName(name);
        System.out.printf("%25s%25s%25s%25s", "PodcastID", "PodcastName", "CelebrityName", "PublishDate\n");
        list.stream().forEach(f->System .out.printf("%25s%25s%25s%25s\n", f.getPodcastId(),f.getPodcastName(),f.getCelebrityName(),f.getPublishDate() ));
        System.out.println();
    }


}
