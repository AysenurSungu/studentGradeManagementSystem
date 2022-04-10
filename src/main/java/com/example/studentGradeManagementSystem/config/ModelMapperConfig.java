package com.example.studentGradeManagementSystem.config;

import com.example.studentGradeManagementSystem.domain.Course;
import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.Student;
import com.example.studentGradeManagementSystem.dto.StudentAvgScoreDTO;
import com.example.studentGradeManagementSystem.dto.request.CourseRequestDTO;
import com.example.studentGradeManagementSystem.dto.request.ExamRequestDTO;
import com.example.studentGradeManagementSystem.dto.request.StudentRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.CourseResponseDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;
import com.example.studentGradeManagementSystem.dto.response.StudentResponseDTO;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    private static final Converter<Student, StudentResponseDTO> STUDENT_TO_STUDENT_RESPONSE_CONVERTER =
            context -> new StudentResponseDTO(
                    context.getSource().getId(),
                    context.getSource().getFullname(),
                    context.getSource().getSchoolNumber(),
                    context.getSource().getCourses().stream().toList());

    private static final Converter<StudentRequestDTO, Student> STUDENT_REQUEST_TO_STUDENT_CONVERTER =
            context -> Student.builder()
                    .id(context.getSource().getId())
                    .fullname(context.getSource().getFullname())
                    .schoolNumber(context.getSource().getSchoolNumber())
                    .courses(context.getSource().getCourses())
                    .build();


    private static final Converter<Course, CourseResponseDTO> COURSE_TO_COURSE_RESPONSE_CONVERTER =
            context -> new CourseResponseDTO(
                    context.getSource().getId(),
                    context.getSource().getCourseCode(),
                    context.getSource().getCourseName(),
                    context.getSource().getYearId(),
                    context.getSource().getStudents().stream().toList());



    private static final Converter<CourseRequestDTO, Course> COURSE_REQUEST_TO_COURSE_CONVERTER =
            context -> Course.builder()
                    .id( context.getSource().getId())
                    .courseName(context.getSource().getCourseCode())
                    .courseName(context.getSource().getCourseName())
                    .yearId(context.getSource().getYearId())
                    .students(context.getSource().getStudents())
                    .build();

    private static final Converter<Exam, ExamResponseDTO> EXAM_TO_EXAM_RESPONSE_CONVERTER =
            context -> new ExamResponseDTO(
                    context.getSource().getId(),
                    context.getSource().getStudentId(),
                    context.getSource().getCourse().getId(),
                    context.getSource().getYearId(),
                    context.getSource().getScore());


    private static final Converter<ExamRequestDTO, Exam> EXAM_REQUEST_TO_EXAM_CONVERTER =
            context -> Exam.builder()
                    .id(context.getSource().getExamId())
                    .course(context.getSource().getCourse())
                    .studentId(context.getSource().getStudentId())
                    .yearId(context.getSource().getYearId())
                    .score(context.getSource().getScore())
                    .build();

    @Bean
    public ModelMapper modelMapper(){
        var modelMapper = new ModelMapper();
        modelMapper.addConverter(STUDENT_TO_STUDENT_RESPONSE_CONVERTER, Student.class, StudentResponseDTO.class);
        modelMapper.addConverter(STUDENT_REQUEST_TO_STUDENT_CONVERTER, StudentRequestDTO.class, Student.class);
        modelMapper.addConverter(COURSE_TO_COURSE_RESPONSE_CONVERTER, Course.class, CourseResponseDTO.class);
        modelMapper.addConverter(COURSE_REQUEST_TO_COURSE_CONVERTER, CourseRequestDTO.class, Course.class);
        modelMapper.addConverter(EXAM_TO_EXAM_RESPONSE_CONVERTER, Exam.class, ExamResponseDTO.class);
        modelMapper.addConverter(EXAM_REQUEST_TO_EXAM_CONVERTER, ExamRequestDTO.class, Exam.class);
        return modelMapper;
    }


}
