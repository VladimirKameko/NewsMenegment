package by.home.pvt.bean;

import java.util.Date;
import java.util.Objects;

public class News {

    private String newsTitle;
    private Date dateCreate;
    private String brief;
    private String content;

    public News(String newsTitle, Date dateCreate, String brief, String content) {
        this.newsTitle = newsTitle;
        this.dateCreate = dateCreate;
        this.brief = brief;
        this.content = content;
    }

    public News() {
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
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

        if (!Objects.equals(newsTitle, news.newsTitle)) return false;
        if (!Objects.equals(dateCreate, news.dateCreate)) return false;
        if (!Objects.equals(brief, news.brief)) return false;
        return Objects.equals(content, news.content);
    }

    @Override
    public int hashCode() {
        int result = newsTitle != null ? newsTitle.hashCode() : 0;
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (brief != null ? brief.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsTitle='" + newsTitle + '\'' +
                ", dateCreate=" + dateCreate +
                ", brief='" + brief + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
