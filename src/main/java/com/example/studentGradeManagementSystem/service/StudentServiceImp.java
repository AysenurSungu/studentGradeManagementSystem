package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentAvgScoreDTO;
import com.example.studentGradeManagementSystem.dto.request.StudentRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.StudentResponseDTO;
import com.example.studentGradeManagementSystem.exception.StudentExistException;
import com.example.studentGradeManagementSystem.exception.StudentNotFoundException;
import com.example.studentGradeManagementSystem.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StudentServiceImp implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;


    @Override
    public StudentResponseDTO addStudent(StudentRequestDTO studentRequest) {
        if(!isExistStudent(studentRequest.getId())){
            log.info("User saved on system... : " + studentRequest.getSchoolNumber());
            return modelMapper.map(studentRepository.save
                  (modelMapper.map(studentRequest, Student.class)), StudentResponseDTO.class);
        }
        throw new StudentExistException("This student already is saving database.. : ");
    }

    @Override
    public StudentResponseDTO getStudentById(Long studentId) {
        if(isExistStudent(studentId)){
            return modelMapper.map(studentRepository.findById(studentId), StudentResponseDTO.class);
        }
        else throw new StudentNotFoundException("Can't find in database this student -> ", studentId);
    }


    public Student getStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalArgumentException(
                        "author with id: " + studentId + " could not be found"));
        return student;
    }

    @Override
    public List<StudentAvgScoreDTO> getCourseAndExamsByStudentId(Long studentId) {
       /* Student student = getStudent(studentId);
        List<Course> courses = courseService.findAll();

        Map<Double, String> averages = courses.stream()
                .filter(s -> s.getCourseName())
                .collect(Collectors.toMap(
                        s -> s.getClass().stream()
                                .mapToInt(Marks::getScore)
                                .summaryStatistics().getAverage(), s->s.getName(),
                        (a,b)->a, // merge, not used by syntactically required.
                        ()->new TreeMap<>(Comparator.reverseOrder())
                ));

        averages.forEach((k,v)->System.out.printf("Student: %8s,   Average: %s%n", v,k));
*/
        return null;
    }

    @Override
    public List<StudentResponseDTO> getStudents() {
        var studentList = studentRepository.findAll().stream()
                .map(student -> modelMapper.map(student, StudentResponseDTO.class))
                .toList();
        return studentList;
    }

    public boolean isExistStudent(Long studentId){
        return studentRepository.existsById(studentId);
    }
}
