package com.bmai.ware.tech.bmaiware.services;

import com.bmai.ware.tech.bmaiware.model.News;
import com.bmai.ware.tech.bmaiware.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    // Define the base directory for file uploads
    private final String uploadDir = "bmaiware/bmaiware/src/main/resources/static/uploads";

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    // Find all news entries
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    // Find news entry by ID
    public Optional<News> findById(Long id) {
        return newsRepository.findById(id);
    }

    // Save a new news entry
    public News save(News news) {
        return newsRepository.save(news);
    }

    // Delete a news entry by ID
    public void deleteById(Long id) {
        newsRepository.deleteById(id);
    }

    // Save an image file to the uploads/images directory
    public String saveImage(MultipartFile file) {
        return saveFile(file, "images");
    }

    // Save a video file to the uploads/videos directory
    public String saveVideo(MultipartFile file) {
        return saveFile(file, "videos");
    }

    // Helper method to save a file to the specified folder (images or videos)
    // Helper method to save a file to the specified folder (images or videos)
    private String saveFile(MultipartFile file, String folder) {
        try {
            // Validate the file
            if (file.isEmpty()) {
                throw new IOException("Failed to store empty file.");
            }

            // Generate a unique filename to prevent overwriting
            String originalFilename = file.getOriginalFilename();
            String extension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + extension;

            // Define the upload path based on the folder (images or videos)
            Path uploadPath = Paths.get(uploadDir + "/" + folder); // Add a slash here

            // Create directories if they don't exist
            if (!Files.exists(uploadPath)) {
                Files.createDirectories(uploadPath);
            }

            // Save the file
            Path filePath = uploadPath.resolve(uniqueFileName);
            Files.write(filePath, file.getBytes());

            // Return the relative path (used for accessing the file via a URL)
            return "/uploads/" + folder + "/" + uniqueFileName;
        } catch (IOException e) {
            e.printStackTrace();
            return null;  // Consider throwing a custom exception instead
        }
    }

}
