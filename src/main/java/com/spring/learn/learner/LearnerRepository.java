package com.spring.learn.learner;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LearnerRepository extends JpaRepository<Learner,Integer> {

    @Query("SELECT l.first_name FROM  Learner l WHERE l.last_name = :last_name ORDER BY l.first_name ASC")
    public List<Learner> findByLast_nameOrderByFirst_nameAsc(@Param("last_name") String last_name);

}
