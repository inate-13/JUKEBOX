package ModelClasses;

public class FinalPlaylist {
    private String playlistName;
    private String audioType;
    private String songName;
    private String songUrl;
    private String podcastName;
    private String podcastPath;

    public FinalPlaylist() {
    }

    public FinalPlaylist(String playlistName, String audioType, String songName, String songUrl, String podcastName, String podcastPath) {
        this.playlistName = playlistName;
        this.audioType = audioType;
        this.songName = songName;
        this.songUrl = songUrl;
        this.podcastName = podcastName;
        this.podcastPath = podcastPath;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public String getAudioType() {
        return audioType;
    }

    public void setAudioType(String audioType) {
        this.audioType = audioType;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getSongUrl() {
        return songUrl;
    }

    public void setSongUrl(String songUrl) {
        this.songUrl = songUrl;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getPodcastPath() {
        return podcastPath;
    }

    public void setPodcastPath(String podcastPath) {
        this.podcastPath = podcastPath;
    }
}
