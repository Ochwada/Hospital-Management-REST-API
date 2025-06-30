package com.example.hospital.sql;


/**
 * *******************************************************
 * Package: com.example.hospital.sql
 * File: PatientQuery.java
 * Author: Ochwada
 * Date: Monday, 30.Jun.2025, 5:23 PM
 * Description: The {@code PatientQuery}  enum defines reusable SQL queries related to Patient operations.
 * Objective:
 * *******************************************************
 */


public enum PatientQuery {

    // =====================  START QUERY =====================
    /**
     * Retrieves all patients from the 'patients' table.
     */
    // == 1. Retrieves all patients
    SELECT_ALL_PATIENTS("SELECT * FROM patients"),

    /**
     * Retrieves all staff from the 'staff' table.
     */
    // == 2. Retrieves all Staff
    SELECT_ALL_STAFF("SELECT * FROM staff"),

    /**
     * Retrieves all patients from the 'patients' table who are assigned to a specific doctor.
     * The doctor's ID must be provided as a parameter to the query.
     */
    // == 3. Retrieves Patients for a given doctor
    PATIENT_FOR_A_DOCTOR(
            "SELECT * FROM patients " +
                    "WHERE assigned_doctor_id = ?"),


    /**
     * Retrieves the average bill amount per department. Joins the 'patients'(p) table with the 'staff'(s) table using
     * assigned doctor ID, and groups the result by department.
     */
    // == 4. Retrieves Average bill per department
    AVERAGE_BILL_PER_DEPARTMENT(
            "SELECT s.department, AVG(p.bill_amount) " +
                    "FROM patients p " +
                    "JOIN staff s ON p.assigned_doctor_id = s.id " +
                    "GROUP BY s.department"
    ),

    /**
     * Retrieves doctors who have more than a specified number of patients.
     * Joins the 'staff' and 'patients' tables, filters for staff with role 'doctor',
     * and groups by doctor ID and name to count assigned patients.
     * <p>
     * The '?' placeholder should be replaced with the patient count threshold.
     */
    // == 5. Doctors with more than X (threshold) patients
    DOCTORS_WITH_ABOVE_X_PATIENTS(
            "SELECT s.id, s.name, COUNT(p.id) as patient_count " +
                    "FROM staff s " +
                    "JOIN patients p on s.id = p.assigned_doctor_id " +
                    "WHERE s.role = 'doctor' " +
                    "GROUP  BY s.id, s.name " +
                    "HAVING COUNT(p.id) > ?"
    ),

    /**
     * Retrieves all patients whose bill amount is above the average bill amount
     * across all patients in the 'patients' table.
     */
    // == 6. Patients with bill above avg
    PATIENT_WITH_BILL_ABOVE_AVG(
            "SELECT * FROM patients " +
                    "WHERE bill_amount > (SELECT AVG(bill_amount) FROM patients)"
    )

    // ==========END QUERY ====================================
    ;
    // ===================== ==================================
    /**
     * The SQL query string associated with the enum constant.
     */
    private final String sql;

    /**
     * Constructs a new {@code PatientQuery} with the specified SQL query.
     *
     * @param sql the SQL query string
     */
    PatientQuery(String sql) {
        this.sql = sql;
    }

    /**
     * Returns the SQL query string associated with this query type.
     *
     * @return the SQL query string
     */
    public String getSql() {
        return sql;
    }
}
