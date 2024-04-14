package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.service.StudentEnity;

public interface StudentRepository extends JpaRepository<StudentEnity, Long> {

    List<StudentEnity> findByName(String name);
}