package com.rakesh.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rakesh.repo.StudentRepo;
import com.rakesh.model.Student;
import com.rakesh.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private	StudentRepo studentRepo;
	
	
	
	
	
	@Override
	public Student add(Student s) {
		try {
		    return studentRepo.save(s);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}		
	}

	@Override
	public Student update(Student s) { 
		Student existingStudent=studentRepo.findById(s.getId()).get();
		existingStudent.setName(s.getName());
		existingStudent.setAddress(s.getAddress());
		existingStudent.setEmail(s.getEmail());
		Student updatedStudent= studentRepo.save(existingStudent);
		return updatedStudent;
	}

	@Override
	public void delete(Integer id) {
		studentRepo.deleteById(id);
	}

	@Override
	public Student get(Integer id) {
		return studentRepo.findById(id).get();
	}

	@Override
	public List<Student> getAll() {
		return studentRepo.findAll();
	}

}
