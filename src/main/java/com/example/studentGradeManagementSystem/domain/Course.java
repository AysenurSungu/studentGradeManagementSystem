package com.example.studentGradeManagementSystem.domain;

import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String courseName;
    private String courseCode;
    private Long yearId;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "course_student", joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> students = new ArrayList<>();
    @OneToMany
    private List<Exam> exams = new ArrayList<>();

   public int scoreAverage(Exam exam){
        var firstScore = exams.indexOf(1);
        var secondScore = exams.indexOf(2);
        var average = (firstScore + secondScore)/2;
        return average;
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public void addExam(Exam exam){exams.add(exam);}
    public void deleteStudent(Student student) {
        students.remove(student);
    }

}
