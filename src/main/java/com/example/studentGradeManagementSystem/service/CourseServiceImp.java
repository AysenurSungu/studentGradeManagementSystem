package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.request.CourseRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.CourseResponseDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;
import com.example.studentGradeManagementSystem.exception.CourseExistException;
import com.example.studentGradeManagementSystem.exception.CourseNotFoundException;
import com.example.studentGradeManagementSystem.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImp implements CourseService {
    private final CourseRepository courseRepository;
    private final StudentService studentService;
    private final SchoolYearService schoolYearService;
    private final ExamService examService;
    private final ModelMapper modelMapper;

    @Override
    public CourseResponseDTO addCourse(CourseRequestDTO courseRequest) {
        var isExistStudent = isExistCourse(courseRequest.getId());
        if (!isExistStudent) {
            var savingModel = modelMapper.map(courseRequest, Course.class);
            return modelMapper.map(courseRepository.save(savingModel), CourseResponseDTO.class);
        }
        else throw new CourseExistException("The course already exist in database", courseRequest.getId());

    }

    @Override
    public CourseResponseDTO getCourseById(Long courseId) {
        if(isExistCourse(courseId)){
            return modelMapper.map(courseRepository.findById(courseId), CourseResponseDTO.class);
        }
        else throw new CourseNotFoundException("Can't find in database this student -> ", courseId);
    }

    @Override
    public Course getCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(() ->
                new IllegalArgumentException("cannot find course with id: " + courseId));
        return course;
    }

    @Override
    public List<CourseResponseDTO> getCourses() {
        var courseList = courseRepository.findAll().stream()
                .map(course -> modelMapper.map(course, CourseResponseDTO.class))
                .toList();
        return courseList;
    }

    @Override
    public CourseResponseDTO addStudentToCourse(Long courseId, Long studentId) {
        Course course = courseRepository.getById(courseId);
        Student student = studentService.getStudent(studentId);
        if (student.getCourses().contains(student)) {
            throw new IllegalArgumentException("this student is already assigned to this course");
        }
        course.addStudent(student);
        student.addCourse(course);
        return modelMapper.map(course, CourseResponseDTO.class);
    }

    @Override
    public List<CourseResponseDTO> getScoresAndAvgScore(Long studentId, String courseCode, String yearCode) {
/*        Course course = new Course();
        Student student = studentService.getStudent(studentId);
        SchoolYear year = schoolYearService.getYearCode(yearCode);

        List<Course> courseList = new ArrayList<>();
        if(course.getCourseCode().equals(courseCode) && year.getYearCode().equals(yearCode) && student.getId().equals(studentId)){
            courseList.stream().map(course1 -> course1.scoreAverage()).

           return modelMapper.map(course, List<CourseResponseDTO>.class);
        }
        else throw new IllegalArgumentException("this student is already assigned to this course");*/
        return null;
    }

    @Override
    public ExamResponseDTO addExamToCourse(Long courseId, Long studentId, int examScore) {
        Exam exam= new Exam();
        Course course = getCourse(courseId);
        Student student = studentService.getStudent(studentId);
        if (student.getCourses().contains(student)) {
            throw new IllegalArgumentException("this student is already assigned to this course");
        }
        course.addStudent(student);
        student.addCourse(course);
        course.addExam(exam);

        return modelMapper.map(exam, ExamResponseDTO.class);
    }


    public boolean isExistCourse(Long courseId){
        return courseRepository.existsById(courseId);
    }
}
