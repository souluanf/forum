package dev.luanfernandes.forum.repository;

import dev.luanfernandes.forum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findByName(String courseName);
}
