package com.bmai.ware.tech.bmaiware.controller;



import com.bmai.ware.tech.bmaiware.model.Vacancy;
import com.bmai.ware.tech.bmaiware.services.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;

    @PostMapping("/post")
    public ResponseEntity<Vacancy> postVacancy(@RequestBody Vacancy vacancy) {
        Vacancy savedVacancy = vacancyService.saveVacancy(vacancy);
        return new ResponseEntity<>(savedVacancy, HttpStatus.CREATED);
    }

    @GetMapping("/get")
    public ResponseEntity<List<Vacancy>> getVacancies() {
        List<Vacancy> vacancies = vacancyService.getAllVacancies();
        return new ResponseEntity<>(vacancies, HttpStatus.OK);
    }
}

