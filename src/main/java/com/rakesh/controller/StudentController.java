package com.rakesh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rakesh.model.Student;
import com.rakesh.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/")
	@ResponseBody
	public String welcome() {
		return "Welcome to My Project";
	}
	
	@PostMapping("/addStudent")
	@ResponseBody
	public Student addStudent(@RequestBody Student student) {
	   Student s= studentService.add(student);
	   return s;
	}
	
	@PutMapping("/update/{id}")
	@ResponseBody
	public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
	   student.setId(id);
	   Student s= studentService.update(student);
	   return s;
	}
	
	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deleteStudent(@PathVariable Integer id, @RequestBody Student student) {
	  studentService.delete(id);
	  return "Student Record Deleted";
	}
	
	@GetMapping("/get/{id}")
	@ResponseBody
	public Student getStudent(@PathVariable Integer id, @RequestBody Student student) {
	Student s=  studentService.get(id);
	  return s;
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public List<Student> getAllStudent() {
	List<Student> students=  studentService.getAll();
	  return students;
	}
}
