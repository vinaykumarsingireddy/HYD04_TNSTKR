package com.springboot.PlacementManagementSystem.Service;
/* Created by- Singireddy Vinay Kumar
 * Date Created-20/11/2023
 */
	
import com.springboot.PlacementManagementSystem.Entity.Certificate;
import com.springboot.PlacementManagementSystem.Entity.Student;
	
public interface IStudentService {
	public Student addStudent(Student student);
	public Student updateStudent(Student student);
	public Student searchStudentById(long id);
	public Student searchStudentByHallTicket(long ticketNo);
	public boolean addCertificate(Certificate certificate);
	public boolean updateCertificate(Certificate certificate);
	public boolean deleteStudent(long id);
}
