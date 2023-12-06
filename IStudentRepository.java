/* Created by- Singireddy Vinay Kumar
 * Date Created-23/11/2023
 */
package com.springboot.PlacementManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.PlacementManagementSystem.Entity.Student;

public interface IStudentRepository extends JpaRepository<Student, Long> {
	Student findById(long id);
    Student findByHallTicketNo(long ticketNo);
    Student findByName(String name);
    Student deleteById(long id);
}
