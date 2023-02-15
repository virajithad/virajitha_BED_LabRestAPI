package com.greatlearning.studentregistrationapplication.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentregistrationapplication.model.Student;
import com.greatlearning.studentregistrationapplication.repository.StudentRepository;
import com.greatlearning.studentregistrationapplication.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	
    StudentRepository studentrepo;
	
	@Override
	public void saveRecord(Student student) {
		
		studentrepo.save(student);
		
	}

	@Override
	public List<Student> getAllStudent() {
		
		return studentrepo.findAll();
	}
    
	@Override
	public Student findById(int id) {
		
		return studentrepo.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		
		studentrepo.deleteById(id);
		
	}

}
