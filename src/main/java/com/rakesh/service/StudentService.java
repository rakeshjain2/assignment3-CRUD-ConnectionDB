package com.rakesh.service;

import java.util.List;

import com.rakesh.model.Student;

public interface StudentService {
	   
	
		public Student add(Student s);
		public Student update(Student s);
		public void delete(Integer id);
		public Student get(Integer id);
		public List<Student> getAll();
		
}
