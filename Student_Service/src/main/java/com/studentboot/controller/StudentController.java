package com.studentboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentboot.config.ResponseStructure;
import com.studentboot.dto.Student;
import com.studentboot.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return studentService.saveStudent(student);
	}
	
	@GetMapping
	public ResponseEntity<ResponseStructure<Student>> findStudent(@RequestParam int studentId)
	{
		return studentService.findStudent(studentId);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Student>> updateStudent(@RequestBody Student student,int studentId)
	{
		return studentService.updateStudent(student, studentId);
	}
	
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(@RequestParam int studentId)
	{
		return studentService.deleteStudent(studentId); 
	}
}


















