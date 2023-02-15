package com.greatlearning.studentregistrationapplication.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.studentregistrationapplication.model.Student;
import com.greatlearning.studentregistrationapplication.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	StudentService studentService;
	@RequestMapping("/list")
	public String listStudent(Model model)
	{
		List<Student> studentlist = studentService.getAllStudent();	
		model.addAttribute("Students", studentlist);
		return "list_students";
		
	}
	
	@RequestMapping("/showFormForAdd")
	public String ShowForm(Model model)
	{
		Student student = new Student(); 
		model.addAttribute("Student", student);
		return "student_form";
	}
	
	 //Update method
	
	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("studentId") int id,
			Model model) 
	{

		Student theStudent = studentService.findById(id);

		model.addAttribute("Student", theStudent);

		return "student_form";			
	}


	@PostMapping("/save")
	public String save(@RequestParam("id") int id,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("course") String course,
			@RequestParam("country") String country) 
	{

		System.out.println(id);
		Student theStudent;
		if(id!=0)
		{
			theStudent=studentService.findById(id);
			theStudent.setFirstName(firstName);
			theStudent.setLastName(lastName);
			theStudent.setCourse(course);
			theStudent.setCountry(country);
		}
		else
		{
			theStudent=new Student(firstName, lastName, course, country);
		}
		
	    studentService.saveRecord(theStudent);
        return "redirect:/student/list";

	}

	// Delete Students
	@RequestMapping("/delete")
	public String delete(@RequestParam("studentId") int theId) {

		
		studentService.deleteById(theId);

		return "redirect:/student/list";

	}
	
	//Access Denied
	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();

		if (user != null) {
			model.addObject("msg", "Hi " + user.getName() 
			+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg", 
			"You do not have permission to access this page!");
		}

		model.setViewName("403");
		return model;

	}


}







