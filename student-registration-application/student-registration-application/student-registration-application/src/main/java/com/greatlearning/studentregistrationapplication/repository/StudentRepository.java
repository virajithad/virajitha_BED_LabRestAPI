package com.greatlearning.studentregistrationapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.studentregistrationapplication.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
	

}
