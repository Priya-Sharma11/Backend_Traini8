package com.traini8.project.repository;

import com.traini8.project.model.TrainingCenter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for managing TrainingCenter entities.
 * Extends JpaRepository for basic CRUD operations and 
 * JpaSpecificationExecutor for advanced queries using specifications.
 */


@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long> , JpaSpecificationExecutor<TrainingCenter> {

     /**
     * Finds TrainingCenter entities based on optional filters for city, state, and course.
     * 
     * @param city the city to filter by (optional)
     * @param state the state to filter by (optional)
     * @param course the course to filter by (optional)
     * @return a list of TrainingCenter entities matching the specified filters
     */
    
    default List<TrainingCenter> findByFilters(String city, String state, String course) {
        Specification<TrainingCenter> spec = Specification.where(hasCity(city))
                .and(hasState(state))
                .and(hasCourse(course));
        return findAll(spec);                        // Execute the specification and return the results
    }

     
     //Specification to filter TrainingCenters by city.
     
    private static Specification<TrainingCenter> hasCity(String city){
        return (root,query, criteriaBuilder)->city==null ? null :criteriaBuilder.equal(root.get("address").get("city"), city);
    }

    
     //Specification to filter TrainingCenters by state.
    private static Specification<TrainingCenter> hasState(String state){
        return (root,query,criteriaBuilder)-> state==null ? null : criteriaBuilder.equal(root.get("address").get("state"),state);
    }

     //Specification to filter TrainingCenters by course.
    private static Specification<TrainingCenter> hasCourse(String course){
        return (root,query,criteriaBuilder)-> course==null ? null : criteriaBuilder.isMember(course, root.get("coursesOffered"));
    }


}
