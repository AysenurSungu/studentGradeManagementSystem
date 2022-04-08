package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.Exam;
import com.example.studentGradeManagementSystem.domain.SchoolYear;
import com.example.studentGradeManagementSystem.repository.ExamRepository;
import com.example.studentGradeManagementSystem.repository.SchoolYearRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExamServiceImp implements ExamService {
    private final ExamRepository examRepository;
    private final SchoolYearRepository schoolYearRepository;
    private final ModelMapper modelMapper;

    @Override
    public Exam createExam(Exam exam) {
        return null;
    }

    @Override
    public SchoolYear createYear(SchoolYear schoolYear) {

            var newYear = modelMapper.map(schoolYear, SchoolYear.class);
            var result = schoolYearRepository.save(newYear);
            return result;

    }
}
