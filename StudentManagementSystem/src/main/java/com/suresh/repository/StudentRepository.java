package com.suresh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.suresh.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	public List<Student> findByName(String name);
}
