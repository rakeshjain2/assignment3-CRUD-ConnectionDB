package com.rakesh.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rakesh.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>  {

}
