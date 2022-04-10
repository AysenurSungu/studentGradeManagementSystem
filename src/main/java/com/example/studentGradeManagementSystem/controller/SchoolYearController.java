package com.example.studentGradeManagementSystem.controller;

import com.example.studentGradeManagementSystem.domain.SchoolYear;
import com.example.studentGradeManagementSystem.service.SchoolYearService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

@RestController
@CrossOrigin
@RequestScope
@RequestMapping("/schoolYears")
@RequiredArgsConstructor
@Validated
public class SchoolYearController {
    private final SchoolYearService schoolYearService;

    @ApiOperation(value = "Eğitim yılı ekleme")
    @PostMapping("/addSchoolYear")
    public ResponseEntity<SchoolYear> addYear(@RequestBody final SchoolYear schoolYear) {
        SchoolYear result = schoolYearService.addYear(schoolYear);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
