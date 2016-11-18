package com.prathap.service;

import java.util.List;

import com.prathap.entity.Student;

public interface StudentService {
	public Student save(Student student);

	public Object findById(int id);

	public boolean delete(Student student);

	List<Student> findByAll();
}
