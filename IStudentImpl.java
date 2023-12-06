package com.springboot.PlacementManagementSystem.Service;
/* Created by- Singireddy Vinay Kumar
 * Date Created-20/11/2023
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.PlacementManagementSystem.Entity.Certificate;
import com.springboot.PlacementManagementSystem.Entity.College;
import com.springboot.PlacementManagementSystem.Entity.Student;
import com.springboot.PlacementManagementSystem.Entity.User;
import com.springboot.PlacementManagementSystem.Repository.ICertificateRepository;
import com.springboot.PlacementManagementSystem.Repository.IStudentRepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class IStudentImpl implements IStudentService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private IStudentRepository studentRepository;

    @Autowired
    private ICertificateRepository certificateRepository;

    @Override
    @Transactional
    public Student addStudent(Student student) {
        // Save the associated College and User entities if necessary
        College college = student.getCollege();
        if (college != null) {
            User collegeAdmin = college.getCollegeAdmin();
            if (collegeAdmin != null && collegeAdmin.getId() == 0) {
                entityManager.persist(collegeAdmin);
            }
            entityManager.persist(college);
        }

        // Save the Student entity
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        // Save the associated College and User entities if necessary
        College college = student.getCollege();
        if (college != null) {
            User collegeAdmin = college.getCollegeAdmin();
            if (collegeAdmin != null && collegeAdmin.getId() == 0) {
                entityManager.persist(collegeAdmin);
            }
            entityManager.persist(college);
        }

        // Save the Student entity
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student searchStudentById(long id) {
        return studentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Student searchStudentByHallTicket(long ticketNo) {
        return studentRepository.findByHallTicketNo(ticketNo);
    }

    @Override
    @Transactional
    public boolean addCertificate(Certificate certificate) {
        certificateRepository.save(certificate);
        return true;
    }

    @Override
    @Transactional
    public boolean updateCertificate(Certificate certificate) {
        certificateRepository.save(certificate);
        return true;
    }

    @Override
    @Transactional
    public boolean deleteStudent(long id) {
        studentRepository.deleteById(id);
        return true;
    }

	}
