package com.studentboot.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.studentboot.config.ResponseStructure;
import com.studentboot.dao.StudentDao;
import com.studentboot.dto.Student;
import com.studentboot.exception.StudentNotFoundByIdException;

@Service
public class StudentService {
	@Autowired
	private  StudentDao studentDao;
	
	public ResponseEntity<ResponseStructure<Student>> saveStudent(Student student)
	{
		student= studentDao.saveStudent(student);
		ResponseStructure<Student>responseStructure=new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.CREATED.value());
		responseStructure.setMessage("Student added successfully");
		responseStructure.setData(student);
		
		return new ResponseEntity<ResponseStructure<Student>>(responseStructure, HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Student>> findStudent(int studentId)
	{
		Optional<Student> optional=studentDao.findStudentById(studentId);
		if(optional.isEmpty())
			
		{
			throw new StudentNotFoundByIdException("failed to find the student....!!");
		}else
		{
			Student student= optional.get();
			ResponseStructure<Student>responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.FOUND.value());
			responseStructure.setMessage("Student found....");
			responseStructure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.FOUND);
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> updateStudent(Student student,int studentId)
	{
		Optional<Student> optional=studentDao.findStudentById(studentId);
		if(optional.isEmpty())
		{
			return null;
		}else
		{
			student.setStudentId(studentId);
			student=studentDao.saveStudent(student);
			
			ResponseStructure<Student>responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student updated successfully....!");
			responseStructure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
	}
	
	
	
	public ResponseEntity<ResponseStructure<Student>> deleteStudent(int studentId)
	{
		Optional<Student> optional=studentDao.findStudentById(studentId);
		if(optional.isEmpty())
		{
			return null;
		}else
		{
			Student student=optional.get();
			student= studentDao.deleteStudent(student);
			
			ResponseStructure<Student>responseStructure=new ResponseStructure<Student>();
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student deleted successfully...!");
			responseStructure.setData(student);
			
			return new ResponseEntity<ResponseStructure<Student>>(responseStructure,HttpStatus.OK);
		}
	}
	
	
}














