package com.traini8.project.repository;

import com.traini8.project.model.TrainingCenter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainingCenterRepository extends JpaRepository<TrainingCenter,Long> , JpaSpecificationExecutor<TrainingCenter> {

    default List<TrainingCenter> findByFilters(String city, String state, String course) {
        Specification<TrainingCenter> spec = Specification.where(hasCity(city))
                .and(hasState(state))
                .and(hasCourse(course));
        return findAll(spec);
    }

    private static Specification<TrainingCenter> hasCity(String city){
        return (root,query, criteriaBuilder)->city==null ? null :criteriaBuilder.equal(root.get("address").get("city"), city);
    }

    private static Specification<TrainingCenter> hasState(String state){
        return (root,query,criteriaBuilder)-> state==null ? null : criteriaBuilder.equal(root.get("address").get("state"),state);
    }

    private static Specification<TrainingCenter> hasCourse(String course){
        return (root,query,criteriaBuilder)-> course==null ? null : criteriaBuilder.isMember(course, root.get("coursesOffered"));
    }


}
