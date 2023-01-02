package Exceptions;

public class PodcastNotFoundException extends Throwable {
    public  PodcastNotFoundException(String  msg){
        System.out.println(msg);
    }
}
