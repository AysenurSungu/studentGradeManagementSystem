package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.dto.request.CourseRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.CourseResponseDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;
import com.example.studentGradeManagementSystem.service.CourseService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;


@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/courses")
@RequiredArgsConstructor
@Validated
public class CourseController {
    private final CourseService courseService;

    @ApiOperation(value = "Yeni ders ekleme")
    @PostMapping("/add")
    public ResponseEntity<CourseResponseDTO> addCourse(@RequestBody final CourseRequestDTO courseRequest) {
        CourseResponseDTO courseResponseDTO = courseService.addCourse(courseRequest);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Id'ye göre ders getirme")
    @GetMapping("/get/{id}")
    public ResponseEntity<CourseResponseDTO> getCourseById(@PathVariable final Long courseId) {
        CourseResponseDTO courseResponse = courseService.getCourseById(courseId);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Tüm derleri getirme")
    @GetMapping("/getAll")
    public ResponseEntity<List<CourseResponseDTO>> getCourses() {
        List<CourseResponseDTO> courseResponse = courseService.getCourses();
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Öğrenciye ders ekleme")
    @PostMapping("/addStudent/{studentId}/to/{courseId}")
    public ResponseEntity<CourseResponseDTO> addStudentToCourse(@PathVariable final Long studentId,
                                                                @PathVariable final Long courseId) {
        CourseResponseDTO courseResponseDTO = courseService.addStudentToCourse(courseId, studentId);
        return new ResponseEntity<>(courseResponseDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Öğrenci Id'si ve ders id'sine göre sınav notu girme")
    @PostMapping("/addExam/{studentId}/to/{courseId}")
    public ResponseEntity<ExamResponseDTO> addExamToCourse(@PathVariable final Long studentId,
                                                           @PathVariable final Long courseId,
                                                           @RequestBody int examScore) {
        ExamResponseDTO examResponseDTO = courseService.addExamToCourse(courseId, studentId, examScore);
        return new ResponseEntity<>(examResponseDTO, HttpStatus.OK);
    }

    @ApiOperation(value = "Öğrenci Id'si, ders kodu ve yıl koduna göre tüm notları getirme")
    @GetMapping("/get/{studentId}/{courseCode}/{yearCode}")
    public ResponseEntity<List<CourseResponseDTO>> getScoresAndAvgScore(@PathVariable final Long studentId,
                                                                   @PathVariable final String courseCode,
                                                                   @PathVariable final String yearCode) {
        List<CourseResponseDTO> courseResponse = courseService.getScoresAndAvgScore(studentId, courseCode, yearCode);
        return new ResponseEntity<>(courseResponse, HttpStatus.OK);
    }

}
