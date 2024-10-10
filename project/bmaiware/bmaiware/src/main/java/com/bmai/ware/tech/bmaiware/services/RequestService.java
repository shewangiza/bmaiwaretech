package com.bmai.ware.tech.bmaiware.services;



import com.bmai.ware.tech.bmaiware.model.Request;
import com.bmai.ware.tech.bmaiware.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RequestService {

    @Autowired
    private RequestRepository requestRepository;

    public Request saveRequest(Request request) {
        request.setRequestDate(LocalDateTime.now()); // Set the request date to the current time
        return requestRepository.save(request);
    }

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }
}

