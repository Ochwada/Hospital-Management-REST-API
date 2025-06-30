# Hospital Management REST API

## Overview
A Spring Boot REST API to manage a hospital's staff and patients.
Designing a real-world entities, connect to PostgreSQL, perform CRUD, and write advanced native SQL queries with Spring Data JPA.

> 🎯 Goal: Practice full-stack Spring Boot development with custom SQL.

##  Background
Our hospital has:

- **Staff**: doctors, nurses, admin staff — organized by department. 
- **Patients**: each assigned to a doctor. Patients have diagnoses and bills.

The REST API will:
1. Register staff & patients 
2. Query assigned patients for a doctor 
3. See billing statistics 
4. Identify doctors with many patients 
5. Report patients with bills higher than the average


## Database Schema

### Staff Table

| Column   | Type      | Notes                        |
|----------|-----------|-----------------------------|
| id       | BIGSERIAL | Primary key                 |
| name     | TEXT      | Staff name                  |
| role     | TEXT      | doctor/nurse/admin          |
| department | TEXT    | e.g. Cardiology, ER         |

---

### Patients Table

| Column             | Type      | Notes                                  |
|---------------------|-----------|----------------------------------------|
| id                  | BIGSERIAL | Primary key                           |
| name                | TEXT      | Patient name                          |
| assigned_doctor_id  | BIGINT    | FK to Staff.id (doctor only)          |
| diagnosis           | TEXT      | Description of diagnosis              |
| bill_amount         | NUMERIC   | Total bill in euros                   |

Using foreign key to link patients to their assigned doctor.
