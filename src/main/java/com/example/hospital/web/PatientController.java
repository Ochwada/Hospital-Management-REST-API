package com.example.hospital.web;

import com.example.hospital.repo.PatientRepositoryCustomImpl;
import com.example.hospital.sql.PatientQuery;
import org.springframework.web.bind.annotation.*;

import com.example.hospital.model.Patient;
import com.example.hospital.repo.PatientRepository;
import com.example.hospital.repo.PatientRepositoryCustom;

import java.util.List;
import java.util.Optional;


/**
 * *******************************************************
 * Package: com.example.hospital.web File: PatientController.java Author:
 * Ochwada Date: Monday, 30.Jun.2025, 5:58 PM Description: REST controller for
 * managing Patients data. Objective:
 * *******************************************************
 */
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientRepository patientRepository;
    private final PatientRepositoryCustom patientRepositoryCustom;
    private final PatientRepositoryCustomImpl patientRepositoryCustomImpl;

    /**
     * Constructs the {@code PatientController} with standard and custom
     * repositories.
     *
     * @param patientRepository       the JPA repository for basic CRUD operations
     * @param patientRepositoryCustom the custom repository for executing
     *                                dynamic SQL queries
     */
    public PatientController(PatientRepository patientRepository,
                             PatientRepositoryCustom patientRepositoryCustom,
                             PatientRepositoryCustomImpl patientRepositoryCustomImpl) {
        this.patientRepository = patientRepository;
        this.patientRepositoryCustom = patientRepositoryCustom;

        this.patientRepositoryCustomImpl = patientRepositoryCustomImpl;
    }

    /**
     * Retrieves all patients from the database.
     *
     * @return an iterable list of all {@link Patient} entities
     */
    @GetMapping
    public Iterable<Patient> getAll() {
        return patientRepository.findAll();
    }

    /**
     * Adds a new Patient to the database.
     *
     * @param p the {@link Patient} object to be persisted (from request body)
     * @return the saved {@link Patient} entity with generated ID
     */
    @PostMapping("/new-patient")
    public Patient addPatient(@RequestBody Patient p) {
        return patientRepository.save(p);

    }

    /**
     * Retrieves all patients assigned to a specific doctor by their ID.
     *
     * <p>This method delegates to a custom repository implementation that executes
     * a native SQL query defined in {@link PatientQuery#PATIENT_FOR_A_DOCTOR}.</p>
     *
     * @param id the ID of the doctor whose patients are to be retrieved; provided as a query parameter (e.g., {@code /for-doctor?doctorId=5})
     * @return an {@link Optional} containing a list of {@link Patient} objects if any are found,
     *         or {@link Optional#empty()} if no patients are assigned to the given doctor
     */
    @GetMapping("/for-doctor") // and ?doctorId=1
    public Optional<List<Patient>> getPatientsByDoctorId(@RequestParam("doctorId") Long id) {
        List<Patient> patients = patientRepositoryCustom.findPatientForDoctor(id);
        return patients.isEmpty() ?
                Optional.empty() : Optional.of(patients);
    }

    /**
     * Retrieves all patients whose bill amount is above the average.
     *
     * <p>This uses a native SQL query defined in {@link PatientQuery#PATIENT_WITH_BILL_ABOVE_AVG}.</p>
     *
     * @return a list of {@link Patient} entities whose bills exceed the average bill
     */
    @GetMapping("/above-avg-bill")
    public List<Patient> aboveAvgBill(){
        return  patientRepositoryCustom.patientsAboveAvgBill();
    }


}
