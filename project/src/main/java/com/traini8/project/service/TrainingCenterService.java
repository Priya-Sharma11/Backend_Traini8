package com.traini8.project.service;

import com.traini8.project.model.TrainingCenter;
import com.traini8.project.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for managing TrainingCenter entities.
 * Provides business logic for CRUD operations and data retrieval.
 */

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;


     //Saves a new TrainingCenter entity to the database.
    public TrainingCenter savedTrainingCenter(TrainingCenter trainingCenter){
        trainingCenter.setCreatedOn(System.currentTimeMillis()/1000L);
        return trainingCenterRepository.save(trainingCenter);
    }
    
    //Retrieves all TrainingCenter entities from the database.
    public List<TrainingCenter> getAllTrainingCenters(){
        return trainingCenterRepository.findAll();
    }

    //Retrieves TrainingCenter entities based on optional filters for city, state, and course.
    public List<TrainingCenter> getTrainingCentersByFilter(String city, String state, String course){
        return trainingCenterRepository.findByFilters(city,state,course);
    }
}
