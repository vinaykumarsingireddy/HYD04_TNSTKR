package com.springboot.PlacementManagementSystem.controller;
/* Created by- Singireddy Vinay Kumar
 * Date Created-20/11/2023
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.PlacementManagementSystem.Entity.Student;
import com.springboot.PlacementManagementSystem.Service.IStudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	@Autowired
	private IStudentService istudentService;

	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudent(@RequestBody Student student){
		Student addedStudent=istudentService.addStudent(student);
		return new ResponseEntity<>(addedStudent,HttpStatus.CREATED);
	}
	@PutMapping("/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student){
		Student updatedStudent=istudentService.updateStudent(student);
		return new ResponseEntity<>(updatedStudent,HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable long id){
		Student student=istudentService.searchStudentById(id);
		if(student!= null) {
			return new ResponseEntity<>(student,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/hallTicket/{ticketNo}")
	public ResponseEntity<Student> getStudentByHallTicket(@PathVariable long ticketNo){
		Student student=istudentService.searchStudentByHallTicket(ticketNo);
		if(student!=null) {
			return new ResponseEntity<>(student,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	@DeleteMapping("/delete/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable long id) {
        boolean deleted = istudentService.deleteStudent(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
