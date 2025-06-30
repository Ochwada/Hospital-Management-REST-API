package com.example.hospital.repo;


import com.example.hospital.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.hospital.repo
 * File: StaffRepository.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:09 PM
 * Description: Repository interface for Staff entity.
 * Objective:  Demo of using advanced SQL queries using nativeQuery
 * *******************************************************
 */


/**
 * Repository interface for performing CRUD operations on {@link Staff} entities.
 * <p>
 * Extends Spring Data's {@link CrudRepository} to inherit basic data access methods
 * such as save, findById, findAll, deleteById, etc.
 */
@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
}
