package com.bmai.ware.tech.bmaiware.model;

import jakarta.persistence.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "news")
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDateTime date;
    private String author;
    private String summary;
    private String content;
    private String category;

    @ElementCollection
    private List<String> tags = new ArrayList<>();

    @ElementCollection
    private List<String> relatedArticles = new ArrayList<>();

    @ElementCollection
    private List<String> images = new ArrayList<>();

    private String videoPath;

    public News() {
    }

    public News(Long id, String title, LocalDateTime date, String author, String summary, String content, String category, List<String> tags, List<String> relatedArticles, List<String> images, String videoPath) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.author = author;
        this.summary = summary;
        this.content = content;
        this.category = category;
        this.tags = tags;
        this.relatedArticles = relatedArticles;
        this.images = images;
        this.videoPath = videoPath;
    }
// Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getRelatedArticles() {
        return relatedArticles;
    }

    public void setRelatedArticles(List<String> relatedArticles) {
        this.relatedArticles = relatedArticles;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String videoPath) {
        this.videoPath = videoPath;
    }


    // ... (Generate getters and setters)
}
