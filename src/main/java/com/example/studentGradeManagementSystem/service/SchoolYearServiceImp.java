package com.example.studentGradeManagementSystem.service;

import com.example.studentGradeManagementSystem.domain.SchoolYear;
import com.example.studentGradeManagementSystem.repository.SchoolYearRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SchoolYearServiceImp implements SchoolYearService {
    private final SchoolYearRepository schoolYearRepository;
    private final ModelMapper modelMapper;

    @Override
    public SchoolYear addYear(SchoolYear schoolYear) {
        var result = schoolYearRepository.save(schoolYear);
        return result;
    }

    @Override
    public SchoolYear getYearCode(String yearCode) {
        SchoolYear year = schoolYearRepository.findByYearCode(yearCode);
        return year;
    }

}
