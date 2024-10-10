package com.bmai.ware.tech.bmaiware.repository;


import com.bmai.ware.tech.bmaiware.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
    // You can define custom query methods here if needed
}

