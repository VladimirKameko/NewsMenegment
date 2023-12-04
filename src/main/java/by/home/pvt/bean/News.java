package by.home.pvt.bean;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class News implements Serializable {

    private static final long SerialVersionUID = 10l;
    private long id;
    private String newsTitle;
    private LocalDate dateCreate;
    private String brief;
    private String content;

    private Long userId;


    public News(long id, String newsTitle, LocalDate dateCreate, String brief, String content, Long userId) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.dateCreate = dateCreate;
        this.brief = brief;
        this.content = content;
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public News() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public LocalDate getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(LocalDate dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        News news = (News) o;

        if (id != news.id) return false;
        if (!Objects.equals(newsTitle, news.newsTitle)) return false;
        if (!Objects.equals(dateCreate, news.dateCreate)) return false;
        if (!Objects.equals(brief, news.brief)) return false;
        if (!Objects.equals(content, news.content)) return false;
        return Objects.equals(userId, news.userId);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (newsTitle != null ? newsTitle.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", newsTitle='" + newsTitle + '\'' +
                ", dateCreate=" + dateCreate +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                '}';
    }
}
