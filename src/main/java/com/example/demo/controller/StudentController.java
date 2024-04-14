package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.ResponseMessage;
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
    public ResponseMessage createStudent(@RequestBody StudentEnity student) {
    studentRepository.save(student);
    return new ResponseMessage("Done");
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

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentEnity> getStudent(@PathVariable Long id) {
    return studentRepository.findById(id)
            .map(student -> ResponseEntity.ok(student))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
}

    @GetMapping("/students/name/{name}")
    public ResponseEntity<List<StudentEnity>> getStudentByName(@PathVariable String name) {
    List<StudentEnity> students = studentRepository.findByName(name);
    if (students.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    } else {
        return ResponseEntity.ok(students);
    }
}


    
}