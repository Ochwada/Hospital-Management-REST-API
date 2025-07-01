package com.example.hospital.web;


import com.example.hospital.repo.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * *******************************************************
 * Package: com.example.hospital.web
 * File: StaffController.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:57 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class StaffController {

    private final StaffRepository staffRepository;
    private final PatientRepositoryCustom patientRepositoryCustom;

    public StaffController(StaffRepository staffRepository, PatientRepositoryCustom patientRepositoryCustom) {
        this.staffRepository = staffRepository;
        this.patientRepositoryCustom = patientRepositoryCustom;
    }

    /**
     * Retrieves average bill per department by joining patients and staff.
     */
    @GetMapping("/avg-bill-per-department")
    public List<Object[]> getAverageBillPerDepartment() {
        return patientRepositoryCustom.averageBillPerDepartment();
    }

    /**
     * Retrieves doctors who have more than a given number of patients.
     *
     * @param minCount the minimum number of patients
     */
    @GetMapping("/doctors-with-many-patients")
    public List<Object[]> getDoctorsWithMoreThanXPatients(@RequestParam("minCount") int minCount) {
        return patientRepositoryCustom.doctorsWithPatientCount(minCount);
    }
}
