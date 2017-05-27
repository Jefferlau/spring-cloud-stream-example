package me.jefferlau.domain;


import java.io.Serializable;

public class News implements Serializable {

    private static final long serialVersionUID = -8540357721511879429L;
    private String id;
    private String link;
    private String title;
    private String description;
    private long pubDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getPubDate() {
        return pubDate;
    }

    public void setPubDate(long pubDate) {
        this.pubDate = pubDate;
    }

    @Override
    public String toString() {
        return new StringBuilder(128).append("News(title=").append(title).append(", description=")
                .append(description.length() >= 20 ? description.substring(0, 20) + "..." : description).append(")")
                .toString();
    }
}
