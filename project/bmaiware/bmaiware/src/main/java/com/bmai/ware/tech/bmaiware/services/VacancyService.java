package com.bmai.ware.tech.bmaiware.services;



import com.bmai.ware.tech.bmaiware.model.Vacancy;
import com.bmai.ware.tech.bmaiware.repository.VacancyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancyService {

    @Autowired
    private VacancyRepository vacancyRepository;

    public Vacancy saveVacancy(Vacancy vacancy) {
        return vacancyRepository.save(vacancy);
    }

    public List<Vacancy> getAllVacancies() {
        return vacancyRepository.findAll();
    }
}

