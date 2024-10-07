package com.traini8.project.service;

import com.traini8.project.model.TrainingCenter;
import com.traini8.project.repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    public TrainingCenter savedTrainingCenter(TrainingCenter trainingCenter){
        trainingCenter.setCreatedOn(System.currentTimeMillis()/1000L);
        return trainingCenterRepository.save(trainingCenter);
    }

    public List<TrainingCenter> getAllTrainingCenters(){
        return trainingCenterRepository.findAll();
    }

    public List<TrainingCenter> getTrainingCentersByFilter(String city, String state, String course){
        return trainingCenterRepository.findByFilters(city,state,course);
    }
}
