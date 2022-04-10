package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.dto.request.ExamRequestDTO;
import com.example.studentGradeManagementSystem.dto.response.ExamResponseDTO;
import com.example.studentGradeManagementSystem.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ExamServiceImp implements ExamService {
    private final ExamRepository examRepository;
    private final ModelMapper modelMapper;

    @Override
    public ExamResponseDTO addExam(ExamRequestDTO examRequest) {
        return modelMapper.map(examRepository.save
                (modelMapper.map(examRequest, Exam.class)), ExamResponseDTO.class);
    }

    @Override
    public List<Exam> getAllExams() {
        return null;
    }

    @Override
    public List<Exam> getAllExamsOfStudent(Long studentId) {
        return null;
    }

/*    @Override
    public Student getAverageScore(Long studentId, String courseCode, Long yearId) {
        List<Exam> exams = examRepository.findAll();
        List<Exam> whichExam = exams.stream().filter(exam -> exam.getStudentId().equals(studentId) &&
                        exam.getYearId().equals(yearId) &&
                        exam.getCourse().getCourseCode().equals(courseCode))
                .collect(Collectors.toList());

        whichExam.stream().mapToDouble(d -> d)
                .average()
                .getAsDouble()
                .build();

        return whichExam;
    }*/
}
