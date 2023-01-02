package ModelClasses;

public class Song {
    private int songId;
    private String songName;
    private String duration;
    private String genre;
    private String albumName;
    private String artistName;
    private String songPath;

    public Song() {
    }

    public Song(int songId, String songName, String duration, String genre, String albumName, String artistName, String songPath) {
        this.songId = songId;
        this.songName = songName;
        this.duration = duration;
        this.genre = genre;
        this.albumName = albumName;
        this.artistName = artistName;
        this.songPath = songPath;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getSongPath() {
        return songPath;
    }

    public void setSongPath(String songPath) {
        this.songPath = songPath;
    }
}
