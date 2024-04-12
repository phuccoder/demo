package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.StudentEnity;
import com.example.demo.repository.StudentRepository;

import java.util.List;

@RestController
public class StudentController {

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @GetMapping("/students")
    public List<StudentEnity> getAllStudents() {
        return studentRepository.findAll();
    }

    @PostMapping("/students")
    public StudentEnity createStudent(@RequestBody StudentEnity student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public StudentEnity updateStudent(@PathVariable Long id, @RequestBody StudentEnity newStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    student.setAddress(newStudent.getAddress());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }

    @PatchMapping("/students/{id}")
    public StudentEnity updateStudentName(@PathVariable Long id, @RequestBody StudentEnity newStudent) {
        return studentRepository.findById(id)
                .map(student -> {
                    student.setName(newStudent.getName());
                    return studentRepository.save(student);
                })
                .orElseGet(() -> {
                    newStudent.setId(id);
                    return studentRepository.save(newStudent);
                });
    }
}