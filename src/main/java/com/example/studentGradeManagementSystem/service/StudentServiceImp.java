package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentDTO;
import com.example.studentGradeManagementSystem.exception.CourseExistException;
import com.example.studentGradeManagementSystem.exception.CourseNotFoundException;
import com.example.studentGradeManagementSystem.repository.CourseRepository;
import com.example.studentGradeManagementSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    private final ModelMapper modelMapper;


    @Override
    public Student createStudent(Student student) {

        var hasStudent = isExistStudent(student.getSchoolNumber());
        if(!hasStudent){
            var newStudent = modelMapper.map(student, Student.class);
            var result = studentRepository.save(newStudent);
            return result;
        }
        else throw new CourseExistException("The student already exist in database", student.getSchoolNumber());

    }

    @Override
    public List<StudentDTO> findAllStudents() {
        var studentDTO = studentRepository.findAll()
                                                  .stream()
                                                  .map(student -> modelMapper.map(student, StudentDTO.class))
                                                  .toList();
        return studentDTO;
    }

    @Override
    public Student addCourse(Course course, Student student) {
        var hasCourse = isExistCourse(course.getCourseId());
        if(!hasCourse){
            throw new CourseNotFoundException("The course has not exist in database");
        }
        else {
            Student std= studentRepository.getById(student.getStudentId());
            std.getTakenCourses().add(course);

        }
        return null;
    }

    public boolean isExistStudent(String studentNumber) {
        var student =  studentRepository.findById(studentNumber);
        return student.isPresent();
    }
    public boolean isExistCourse(Long courseId) {
        var course =  courseRepository.findById(courseId);
        return course.isPresent();
    }
}
