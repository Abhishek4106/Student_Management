package com.studentboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.studentboot.dto.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
