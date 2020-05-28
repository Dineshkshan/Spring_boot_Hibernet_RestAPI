package com.hibernate.Container;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.Dao.StudentDao;
import com.hibernate.Model.Student;

@RestController
public class Container {
	@Autowired
	StudentDao student;
	
	@GetMapping("/Getall")
	public List<Student> GetallStudents()
	{
		List<Student> stud=student.GetallStudents();
		return stud;
	}
	
	@GetMapping("/GetById/{id}")
	public Student GetStudentsById(@PathVariable int id)
	{
		Student stud=student.GetStudentById(id);
		return stud;
	}
	
	@PostMapping("/insertstudent")
	public String InsertStudent(@RequestBody Student stud)
	{
		int count=student.InsertStudents(stud);
		try {
			if (count!=0) 
			{
				return "Student is inserted successfully";
			}
		} catch (Exception e) {
			return "Error in inserting Student "+ e;
		}
		return null;
	} 
	
	@PutMapping("/UpdateStudent")
	public String UpdateStudent(@RequestBody Student stud)
	{
		//System.out.println(stud.getStudentsubject()+" "+stud.getId());
		student.UpdateStudents(stud);
		return "Student Updated Successfully";	
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public String DeleteStudent(@PathVariable int id)
	{
		try {
			student.DeleteStudent(id);
			return "Student is Deleted Successfully";
		} catch (Exception e) {
			return "Error in Deleting table" +e;
		}	
	}

}




























