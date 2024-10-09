package com.bmai.ware.tech.bmaiware.controller;

import com.bmai.ware.tech.bmaiware.model.News;
import com.bmai.ware.tech.bmaiware.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/news")
public class NewsController {
    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping
    public List<News> getAllNews() {
        return newsService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        return newsService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<News> createNews(
            @RequestParam("title") String title,
            @RequestParam("date") String date,
            @RequestParam("author") String author,
            @RequestParam("summary") String summary,
            @RequestParam("content") String content,
            @RequestParam("category") String category,
            @RequestParam(value = "tags", required = false) List<String> tags,
            @RequestParam(value = "images", required = false) List<MultipartFile> images,
            @RequestParam(value = "video", required = false) MultipartFile video,
            @RequestParam(value = "relatedArticles", required = false) List<String> relatedArticles) {

        // Create a new News object
        News news = new News();
        news.setTitle(title);
        news.setDate(LocalDateTime.parse(date));
        news.setAuthor(author);
        news.setSummary(summary);
        news.setContent(content);
        news.setCategory(category);
        news.setTags(tags != null ? tags : new ArrayList<>());
        news.setRelatedArticles(relatedArticles != null ? relatedArticles : new ArrayList<>());

        // Handle image uploads
        if (images != null && !images.isEmpty()) {
            List<String> imagePaths = new ArrayList<>();
            for (MultipartFile image : images) {
                String imagePath = newsService.saveImage(image);
                if (imagePath != null) {
                    imagePaths.add(imagePath);
                }
            }
            news.setImages(imagePaths);
        }

        // Handle video upload
        if (video != null && !video.isEmpty()) {
            String videoPath = newsService.saveVideo(video);
            if (videoPath != null) {
                news.setVideoPath(videoPath);
            }
        }

        // Save the news entry
        News savedNews = newsService.save(news);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News news) {
        return newsService.findById(id)
                .map(existingNews -> {
                    news.setId(existingNews.getId());
                    News updatedNews = newsService.save(news);
                    return ResponseEntity.ok(updatedNews);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id) {
        if (newsService.findById(id).isPresent()) {
            newsService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
