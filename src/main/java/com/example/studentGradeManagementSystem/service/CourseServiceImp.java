package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.dto.CourseDTO;
import com.example.studentGradeManagementSystem.exception.CourseExistException;
import com.example.studentGradeManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public Course createCourse(Course course) {

        var hasCourse = isExistCourse(course.getCourseId());
        if(!hasCourse){
            var newCourse = modelMapper.map(course, Course.class);
            var result = courseRepository.save(newCourse);
            return result;
        }
        else throw new CourseExistException("The course already exist in database", course.getCourseCode());

    }

    @Override
    public List<CourseDTO> findAllCourses() {
        var courseDTO = courseRepository.findAll()
                                                       .stream()
                                                       .map(course -> modelMapper.map(course, CourseDTO.class))
                                                       .toList();
        return courseDTO;
    }

    public boolean isExistCourse(Long courseId) {
        var course =  courseRepository.findById(courseId);
        return course.isPresent();
    }

}
