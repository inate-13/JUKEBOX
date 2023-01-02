package ModelClasses;

public class Playlist {
    private int playlistId;
    private String playlistName;
    private int userId;
    private int audioId;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName, int userId, int audioId) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
        this.userId = userId;
        this.audioId = audioId;
    }

    public Playlist(String playlistName, int userId, int audioId) {
        this.playlistName=playlistName;
        this.userId=userId;
        this.audioId=audioId;
    }

    public int getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(int playlistId) {
        this.playlistId = playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }
}
