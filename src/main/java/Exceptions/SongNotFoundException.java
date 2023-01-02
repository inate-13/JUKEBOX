package Exceptions;

public class SongNotFoundException extends Throwable {
    public SongNotFoundException(String msg){
        System.out.println(msg);
    }
}
