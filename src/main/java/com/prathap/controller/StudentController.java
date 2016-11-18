package com.prathap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.prathap.entity.Student;
import com.prathap.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value="/save", method=RequestMethod.POST, consumes="application/json")
	public Student save(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentService.save(student);
	}

	@RequestMapping(value="/get/{id}", method=RequestMethod.GET)
	public Object findById(@PathVariable int id) {
		// TODO Auto-generated method stub
		return studentService.findById(id);
	}

	@RequestMapping(value="/delete", method=RequestMethod.DELETE, consumes="application/json")
	public boolean delete(@RequestBody Student student) {
		// TODO Auto-generated method stub
		return studentService.delete(student);
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public Object findByAll() {
		// TODO Auto-generated method stub
		return studentService.findByAll();
	}
}
