package com.greatlearning.studentregistrationapplication.service;

import java.util.List;

import com.greatlearning.studentregistrationapplication.model.Student;

public interface StudentService {
	
	
	public void saveRecord(Student student);
	
	public List<Student> getAllStudent();
	

	public Student findById(int id);

	public void deleteById(int id);

}
