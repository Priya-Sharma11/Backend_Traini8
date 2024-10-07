package com.traini8.project.controller;

import com.traini8.project.model.TrainingCenter;
import com.traini8.project.service.TrainingCenterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class for managing Training Centers.
 * Provides RESTful APIs for creating and retrieving training centers.
 */

@RestController
@RequestMapping("/api/training-centers")
public class TrainingCenterController {

    @Autowired
    private TrainingCenterService trainingCenterService;

      /**
     * Create a new Training Center.
     * @param trainingCenter Training center details.
     * @return ResponseEntity with created center.
     */
    
    @PostMapping
    public ResponseEntity<?> createdTrainingCenter(@Valid @RequestBody TrainingCenter trainingCenter){
        TrainingCenter savedCenter = trainingCenterService.savedTrainingCenter(trainingCenter);
        return new ResponseEntity<>(savedCenter, HttpStatus.CREATED);
    }

    // Get all Training Centers 
    
    @GetMapping
    public ResponseEntity<List<TrainingCenter>> getAllTrainingCenters(){
        List<TrainingCenter> centers = trainingCenterService.getAllTrainingCenters();
        if(centers.isEmpty()){
            return new ResponseEntity<>(centers,HttpStatus.OK);
        }
        return new ResponseEntity<>(centers, HttpStatus.OK);

    }

     /**
     * Filter Training Centers 
     * @param city   (optional) City to filter by.
     * @param state  (optional) State to filter by.
     * @param course (optional) Course to filter by.
     * @return List of filtered training centers.
     */
    
    @GetMapping("/filter")
    public List<TrainingCenter> getTrainingCentersByFilters(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state,
            @RequestParam(required = false) String course
    ){
        return trainingCenterService.getTrainingCentersByFilter(city,state,course);
    }


}
