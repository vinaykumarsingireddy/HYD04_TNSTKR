/* Created by- Singireddy Vinay Kumar
 * Date Created-23/11/2023
 */
package com.tns.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tns.entity.Student;

public interface IStudentRepository extends JpaRepository<Student,Long> {
	Student addStudent(Student student);
	Student updateStudent(Student student);
	Student searchStudentById(long id);
	Student searchStudentByHallTicket(long ticketNo);
	Student deleteStudent(long id);
	

}
