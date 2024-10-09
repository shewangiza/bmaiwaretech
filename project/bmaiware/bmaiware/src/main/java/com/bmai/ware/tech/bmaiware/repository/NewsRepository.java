package com.bmai.ware.tech.bmaiware.repository;



import com.bmai.ware.tech.bmaiware.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    // Additional query methods (if needed) can be defined here
}
