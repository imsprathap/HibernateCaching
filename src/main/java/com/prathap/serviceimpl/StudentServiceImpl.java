package com.prathap.serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prathap.dao.StudentDao;
import com.prathap.entity.Student;
import com.prathap.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	@Transactional
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}

	@Override
	public Object findById(int id) {
		// TODO Auto-generated method stub
		return studentDao.findById(id);
	}

	@Override
	@Transactional
	public boolean delete(Student student) {
		// TODO Auto-generated method stub
		return studentDao.delete(student);
	}
	
	@Override
	public List<Student> findByAll() {
		return studentDao.findByAll();
	}

}
