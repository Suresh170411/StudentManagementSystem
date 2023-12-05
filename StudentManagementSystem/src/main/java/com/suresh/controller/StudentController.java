package com.suresh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.suresh.exception.StudentException;
import com.suresh.model.Student;
import com.suresh.service.StudentService;

@RestController
@CrossOrigin
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student/register")
	public ResponseEntity<Student> registerStudentHandler(@RequestBody Student student){
		return new ResponseEntity<>(studentService.registerStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudentList() throws StudentException{
		return new ResponseEntity<List<Student>>(studentService.getStudentList(), HttpStatus.OK);
	}
	
	@GetMapping("/student/{roll}")
	public ResponseEntity<Student> getStudentByRollHandler(@PathVariable ("roll") Integer roll) throws StudentException{
		return new ResponseEntity<Student>(studentService.findStudentByRoll(roll), HttpStatus.OK);
	}
	
	@DeleteMapping("/student/{roll}")
	public ResponseEntity<String> deleteStudentByRoll(@PathVariable ("roll") Integer roll) throws StudentException{
		return new ResponseEntity<String>(studentService.deleteStudent(roll), HttpStatus.OK);
	}
	
	@PutMapping("/student/{roll}")
	public ResponseEntity<String> updateStudetNameHandler (@RequestBody Student student, @PathVariable ("roll") Integer roll) throws StudentException{
		return new ResponseEntity<String>(studentService.updateStudentDetails(roll, student), HttpStatus.OK);
	}
	
	@PutMapping("/student/name/{roll}")
	public ResponseEntity<String> updateStudentNameHandler(@PathVariable ("roll") Integer roll, @RequestParam String name) throws StudentException{
		return new ResponseEntity<String>(studentService.updateStudentName(roll, name), HttpStatus.OK);
	}
	
	@PutMapping("/student/age/{roll}")
	public ResponseEntity<String> updateStudentNameHandler(@PathVariable ("roll") Integer roll, @RequestParam Integer age) throws StudentException{
		return new ResponseEntity<String>(studentService.updateStudentAge(roll, age), HttpStatus.OK);
	}
	
}
