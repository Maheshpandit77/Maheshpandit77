
package com.jbk.springboot.com.jbk.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.springboot.com.jbk.springboot.entity.Student;

@RestController
public class StudentController {
	
	List<Student>list=new ArrayList<>();
	
	
	
	@PostMapping(value="/saveStudent")
public boolean saveStudent(@RequestBody Student student) {
		list.add(student);
return true;
	}
	
	@PutMapping(value="/UpdateStudent")
	public String updateStudent(@RequestBody Student student) {
		String msg="Student Not Exist";
		for (Student std:list) {
			if(std.getStudentId()==student.getStudentId()) {
				list.remove(std);
				list.add(student);
				msg="Update";
				break;
				
			}
		}
		return msg;
	}
	
	
	

	@GetMapping(value="getAllStudent")
	public List<Student>getallStudent(){
		return list;
		
	}
	@GetMapping(value="/getOnlyStudent/{id}")
	public Student getStudentById(@PathVariable int id) {
		Student student=null;
		for (Student std:list) {
			if(std.getStudentId()==id) {
				student=std;
				break;
			}
		}
		return student;
	}
	@DeleteMapping(value="/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id) {
		String msg="Student Not Exist";
		for(Student std:list) {
			if (std.getStudentId()==id) {
				list.remove(std);
				msg="Delete";
				break;
			}
		}
		return msg;
	}
	
}

