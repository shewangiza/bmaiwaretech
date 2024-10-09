package com.bmai.ware.tech.bmaiware.services;

import com.bmai.ware.tech.bmaiware.model.Contact;
import com.bmai.ware.tech.bmaiware.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }
}

