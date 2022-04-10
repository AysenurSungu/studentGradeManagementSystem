package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentAvgScoreDTO;
import com.example.studentGradeManagementSystem.dto.request.StudentRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.StudentResponseDTO;
import com.example.studentGradeManagementSystem.service.StudentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/students")
@RequiredArgsConstructor
@Validated
public class StudentController {
    private final StudentService studentService;

    @ApiOperation(value = "Öğrenci ekleme")
    @PostMapping("/addStudent")
    public ResponseEntity<StudentResponseDTO> addStudent(@RequestBody final StudentRequestDTO studentRequest) {
        StudentResponseDTO studentResponse = studentService.addStudent(studentRequest);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Öğrenci Id'si göre öğrenci getirme")
    @GetMapping("/get/{id}")
    public ResponseEntity<StudentResponseDTO> getStudentById(@PathVariable final Long studentId) {
        StudentResponseDTO studentResponse = studentService.getStudentById(studentId);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Tüm öğrencileri listeleme")
    @GetMapping("/getAll")
    public ResponseEntity<List<StudentResponseDTO>> getStudents() {
        List<StudentResponseDTO> studentResponse = studentService.getStudents();
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Öğrenci Id'ye göre dersler ve notlarını getirme")
    @GetMapping("/getCoursesAndExams/{studentId}")
    public ResponseEntity<List<StudentAvgScoreDTO>> getCourseAndExamsByStudentId(@PathVariable final Long studentId)  {
        List<StudentAvgScoreDTO> studentAvgScoreDTO = studentService.getCourseAndExamsByStudentId(studentId);
        return new ResponseEntity<>(studentAvgScoreDTO, HttpStatus.OK);
    }

}
