package com.suresh.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suresh.exception.StudentException;
import com.suresh.model.Student;
import com.suresh.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Student registerStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student findStudentByRoll(Integer roll) throws StudentException {
		
		return studentRepository.findById(roll).orElseThrow(()-> new StudentException("No Student Found With This Roll !"));
	}

	@Override
	public List<Student> getStudentList() throws StudentException {
		List<Student> list = studentRepository.findAll();
		
		if (list.isEmpty()) {
			throw new StudentException("No Students Found !");
		}else {
			return list;
		}
	}

	@Override
	public String deleteStudent(Integer roll) throws StudentException {
		Optional<Student> opt = studentRepository.findById(roll);
		
		if (opt.isEmpty()) {
			throw new StudentException("No Student Found With This Roll !");
		}else {
			studentRepository.deleteById(roll);
		}
		return "Student Deleted Successfully !";
	}

	@Override
	public String updateStudentDetails(Integer roll, Student student) throws StudentException {
		Optional<Student> opt = studentRepository.findById(roll);
		
		if (opt.isEmpty()) {
			throw new StudentException("No Student Found With This Roll !");
		}else {
			Student existing = opt.get();
			
			existing.setName(student.getName());
			existing.setAge(student.getAge());
			existing.setGender(student.getGender());
			
			studentRepository.save(existing);
			
			return "Student Updated Successfully !";
		}
	}

	@Override
	public String updateStudentName(Integer roll, String updatedName) throws StudentException {
		Optional<Student> opt = studentRepository.findById(roll);
		
		if (opt.isEmpty()) {
			throw new StudentException("No Student Found With This Roll !");
		}else {
			opt.get().setName(updatedName);
			
			studentRepository.save(opt.get());
			
			return "Student Name Updated Successfully !";
		}
	}

	@Override
	public String updateStudentAge(Integer roll, Integer age) throws StudentException {
		Optional<Student> opt = studentRepository.findById(roll);
		
		if (opt.isEmpty()) {
			throw new StudentException("No Student Found With This Roll !");
		}else {
			opt.get().setAge(age);
			
			studentRepository.save(opt.get());
			
			return "Student Age Updated Successfully !";
		}
	}

}
