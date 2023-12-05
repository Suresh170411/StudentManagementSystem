package com.suresh.service;

import java.util.List;

import com.suresh.exception.StudentException;
import com.suresh.model.Student;

public interface StudentService {

	public Student registerStudent(Student student);
	
	public Student findStudentByRoll(Integer roll) throws StudentException;
	
	public List<Student> getStudentList() throws StudentException;
	
	public String deleteStudent(Integer roll) throws StudentException;
	
	public String updateStudentDetails(Integer roll,Student student) throws StudentException;
	
	public String updateStudentName(Integer roll, String updatedName) throws StudentException;
	
	public String updateStudentAge(Integer roll, Integer age) throws StudentException;
}
