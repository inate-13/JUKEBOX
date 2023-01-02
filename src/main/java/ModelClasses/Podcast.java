package ModelClasses;

import java.util.Date;

public class Podcast {
    private int podcastId;
    private String podcastName;
    private String celebrityName;
    private Date publishDate;
    private String podcastPath;

    public Podcast() {
    }

    public Podcast(int podcastId, String podcastName, String celebrityName, Date publishDate, String podcastPath) {
        this.podcastId = podcastId;
        this.podcastName = podcastName;
        this.celebrityName = celebrityName;
        this.publishDate = publishDate;
        this.podcastPath = podcastPath;
    }

    public int getPodcastId() {
        return podcastId;
    }

    public void setPodcastId(int podcastId) {
        this.podcastId = podcastId;
    }

    public String getPodcastName() {
        return podcastName;
    }

    public void setPodcastName(String podcastName) {
        this.podcastName = podcastName;
    }

    public String getCelebrityName() {
        return celebrityName;
    }

    public void setCelebrityName(String celebrityName) {
        this.celebrityName = celebrityName;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPodcastPath() {
        return podcastPath;
    }

    public void setPodcastPath(String podcastPath) {
        this.podcastPath = podcastPath;
    }
}
