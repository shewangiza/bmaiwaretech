package com.bmai.ware.tech.bmaiware.repository;


import com.bmai.ware.tech.bmaiware.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
}

