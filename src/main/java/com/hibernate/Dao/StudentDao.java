package com.hibernate.Dao;

import java.util.List;

import com.hibernate.Model.Student;

public interface StudentDao {

	public List<Student> GetallStudents();
	public int InsertStudents(Student Stud);
	public void UpdateStudents(Student Stud);
	public Student GetStudentById(int id);
	public void DeleteStudent(int id);
}
