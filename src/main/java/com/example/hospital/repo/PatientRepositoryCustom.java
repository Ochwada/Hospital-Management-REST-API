package com.example.hospital.repo;


import com.example.hospital.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * *******************************************************
 * Package: com.example.hospital.repo
 * File: PatientRepositoryCustom.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:13 PM
 * Description: Custom repository interface for advanced queries related to {@link Patient} entities.
 * Objective:
 * *******************************************************
 */

@Repository
public interface PatientRepositoryCustom {

    /**
     * Finds all patients assigned to a specific doctor.
     *
     * @param doctorId the unique ID of the doctor
     * @return a list of patients under the specified doctor
     */
    List<Patient> findPatientForDoctor(Long doctorId);


    /**
     * Calculates the average bill amount per department.
     *
     * @return a list of object arrays where each array contains:
     *         [0] = department name (String),
     *         [1] = average bill amount (Double)
     */
    List<Object[]> averageBillPerDepartment();

    /**
     * Retrieves doctors who have more than the specified number of patients.
     *
     * @param minCount the minimum number of patients a doctor must have
     * @return a list of object arrays where each array contains:
     *         [0] = doctor name or ID,
     *         [1] = patient count (Long or Integer)
     */
    List<Object[]> doctorsWithPatientCount(int minCount);

    /**
     * Finds all patients whose bill amount is above the average bill across all patients.
     *
     * @return a list of patients with bills higher than the average
     */
    List<Patient> patientsAboveAvgBill();
}
