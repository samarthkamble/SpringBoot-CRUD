package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepository;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    public Optional<Course> getCourseById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Course> updateCourse(Long id, Course courseDetails) {
        Optional<Course> optionalCourse = courseRepository.findById(id);
        if (optionalCourse.isPresent()) {
            Course existingCourse = optionalCourse.get();
            existingCourse.setTitle(courseDetails.getTitle());
            existingCourse.setStartDate(courseDetails.getStartDate());
            existingCourse.setEndDate(courseDetails.getEndDate());
            courseRepository.save(existingCourse);
        }
        return optionalCourse;
    }

    public boolean deleteCourse(Long id) {
        try {
            courseRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
