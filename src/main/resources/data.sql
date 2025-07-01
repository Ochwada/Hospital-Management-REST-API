
TRUNCATE TABLE patients CASCADE;
TRUNCATE TABLE staff CASCADE;
-- ==== STAFF TABLE ====
-- DOCTOR, NURSE, ADMIN etc. (UPPERCASE)
INSERT INTO staff (id, name, role, department)
VALUES (1, 'Dr. Alice Smith', 'DOCTOR', 'Cardiology');

INSERT INTO staff (id, name, role, department)
VALUES (2, 'Dr. Brian Kim', 'DOCTOR', 'Neurology');

INSERT INTO staff (id, name, role, department)
VALUES (3, 'Nurse Ellen Park', 'NURSE', 'Pediatrics');

INSERT INTO staff (id, name, role, department)
VALUES (4, 'Dr. Sophie Dubois', 'DOCTOR', 'Orthopedics');

INSERT INTO staff (id, name, role, department)
VALUES (5, 'Admin John Roe', 'ADMIN', 'Records');

-- ==== PATIENTS TABLE ====
INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (1, 'John Doe', 'Arrhythmia', 4500, 1);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (2, 'Jane Roe', 'Stroke', 5500, 2);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (3, 'Anna Bell', 'Broken Arm', 3200, 4);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (4, 'Mike Chan', 'Epilepsy', 4000, 2);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (5, 'Sara Lee', 'Fracture', 3600, 4);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (6, 'Tom Ray', 'Heart Failure', 6100, 1);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (7, 'Lena Zhao', 'Arthritis', 2900, 4);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (8, 'Carlos Diaz', 'Epilepsy', 3700, 2);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (9, 'Fatima Noor', 'Anxiety', 2500, 1);

INSERT INTO patients (id, name, diagnosis, bill_amount, assigned_doctor_id)
VALUES (10, 'Jake Ngugi', 'Asthma', 3300, 1);
