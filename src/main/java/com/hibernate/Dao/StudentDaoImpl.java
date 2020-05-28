package com.hibernate.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hibernate.Model.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private EntityManager entity;
	
	
	@Override
	@Transactional
	public List<Student> GetallStudents() {
		Session session=entity.unwrap(Session.class);
		Query query=session.createQuery("from Student");
		List<Student>student=query.getResultList();
		return student;
	}

	@Override
	@Transactional
	public int InsertStudents(Student Stud) {
		Session session=entity.unwrap(Session.class);
		int count=(int) session.save(Stud);
		return count;
	}

	@Override
	@Transactional
	public void UpdateStudents(Student Stud) {
		Session session=entity.unwrap(Session.class);
		Query query=session.createQuery("update Student s set s.Studentsubject=?1 where s.id=?2");
		query.setParameter(1,Stud.getStudentsubject());
		query.setParameter(2,Stud.getId());
		query.executeUpdate();
		query.getFirstResult();
	}

	@Override
	@Transactional
	public Student GetStudentById(int id) {
		Session session=entity.unwrap(Session.class);
		Student stud=session.get(Student.class, id);
		return stud;
	}

	@Override
	@Transactional
	public void DeleteStudent(int id) {
		Session session=entity.unwrap(Session.class);
		Student stud=session.get(Student.class, id);
		session.delete(stud);
		}

}
