package com.School.SchoolValleyProject.repository;

import com.School.SchoolValleyProject.Model.courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursesRepository extends JpaRepository<courses, Integer> {

    List<courses> findByOrderByNameDesc();
    List<courses> findByOrderByName();

}
