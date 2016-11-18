package com.prathap.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.prathap.dao.StudentDao;
import com.prathap.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Student save(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Override
	public Object findById(int id) {
		Student student = entityManager.find(Student.class, id);
		return student;
	}

	@Override
	public boolean delete(Student student) {
		student = entityManager.find(Student.class, student.getId());
		entityManager.remove(student);
		return true;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByAll() {
		return entityManager.createQuery("FROM " + Student.class.getName()).getResultList();
	}

}
