package com.example.hospital.repo;


/**
 * *******************************************************
 * Package: com.example.hospital.repo
 * File: PatientRepositoryCustomImpl.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:19 PM
 * Description:  Implementation of the {@link PatientRepositoryCustom} interface.
 * Objective:
 * *******************************************************
 */


import java.util.List;

import com.example.hospital.model.Patient;
import com.example.hospital.sql.PatientQuery;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 * This class is responsible for executing custom employee queries defined in the {@link PatientQuery}
 * enum, with optional parameter binding. The implementation typically uses {@code EntityManager} for
 * executing native SQL queries that are not directly handled by Spring Data JPA.
 */
@Repository
public class PatientRepositoryCustomImpl implements PatientRepositoryCustom {

    /**
     * The JPA {@link EntityManager} used to execute native SQL queries.
     * <p>
     * It provides an interface to manage persistence and allows the execution of dynamic queries
     * that are not handled by Spring Data JPA's method naming conventions or annotations.
     * </p>
     */
    private final EntityManager entityManager; // speaks to the database

    /**
     * Constructs the custom repository implementation with a provided {@link EntityManager}.
     *
     * @param entityManager the JPA entity manager used for query execution and parameter binding
     */
    public PatientRepositoryCustomImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Retrieves a list of patients assigned to a specific doctor.
     *
     * <p>This method executes a native SQL query defined in {@code PatientQuery.PATIENT_FOR_A_DOCTOR}
     * to find all patients associated with the provided doctor ID. It uses {@code entityManager}
     * to run the query and maps the results to {@code Patient} entities.</p>
     *
     * @param doctorId the ID of the doctor whose patients are to be retrieved
     * @return a list of {@code Patient} objects associated with the given doctor
     */
    @Override
    public List<Patient> findPatientForDoctor(Long doctorId) {
        Query query = entityManager.createNativeQuery(
                PatientQuery.PATIENT_FOR_A_DOCTOR.getSql(),
                Patient.class
        );

        query.setParameter(1, doctorId);
        return query.getResultList();
    }

    @Override
    public List<Object[]> averageBillPerDepartment() {
        Query query = entityManager.createNativeQuery(
                PatientQuery.AVERAGE_BILL_PER_DEPARTMENT.getSql()
        );
        return query.getResultList();
    }

    @Override
    public List<Object[]> doctorsWithPatientCount(int minCount) {
        Query query = entityManager.createNativeQuery(
                PatientQuery.DOCTORS_WITH_ABOVE_X_PATIENTS.getSql()
        );
        query.setParameter(1, minCount); // Positional index
        return query.getResultList();
    }

    @Override
    public List<Patient> patientsAboveAvgBill() {
        Query query = entityManager.createNativeQuery(
                PatientQuery.PATIENT_WITH_BILL_ABOVE_AVG.getSql(),
                Patient.class
        );
        return query.getResultList();
    }
}
