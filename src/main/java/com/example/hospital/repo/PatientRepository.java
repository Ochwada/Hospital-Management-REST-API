package com.example.hospital.repo;


import com.example.hospital.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * *******************************************************
 * Package: com.example.hospital.repo
 * File: PatientRepository.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:10 PM
 * Description: Repository interface for Patient entity.
 * Objective:  Demo of using advanced SQL queries using nativeQuery
 * *******************************************************
 */


/**
 * Repository interface for performing CRUD operations on {@link Patient} entities.
 * <p>
 * Extends Spring Data's {@link CrudRepository} to inherit basic data access methods
 * such as save, findById, findAll, deleteById, etc.
 */
@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
