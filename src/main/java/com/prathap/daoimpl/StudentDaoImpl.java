package com.prathap.daoimpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.prathap.dao.StudentDao;
import com.prathap.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@CachePut(value="student", key="#result.id")
	public Student save(Student student) {
		entityManager.persist(student);
		return student;
	}

	@Override
	@Cacheable("student")
	public Student findById(int id) {
		System.out.println("Inside findById");
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
	@Cacheable("students")
	public List<Student> findByAll() {
		System.out.println("Inside findAll");
		return entityManager.createQuery("FROM " + Student.class.getName()).getResultList();
	}

}
