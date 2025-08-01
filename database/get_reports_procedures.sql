DELIMITER $$

-- Procedure 1: Get Daily Appointment Report by Doctor
CREATE PROCEDURE GetDailyAppointmentReportByDoctor(IN report_date DATE)
BEGIN
  SELECT 
    d.id AS doctor_id,
    d.full_name AS doctor_name,
    COUNT(a.id) AS total_appointments
  FROM appointments a
  JOIN doctor d ON d.id = a.doctor_id
  WHERE DATE(a.appointment_time) = report_date
  GROUP BY d.id
  ORDER BY total_appointments DESC
  LIMIT 1;
END $$

-- Procedure 2: Get Doctor With Most Patients By Month
CREATE PROCEDURE GetDoctorWithMostPatientsByMonth(
    IN input_month INT,
    IN input_year INT
)
BEGIN
  SELECT 
    d.id AS doctor_id,
    d.full_name AS doctor_name,
    COUNT(DISTINCT a.patient_id) AS total_patients
  FROM appointments a
  JOIN doctor d ON d.id = a.doctor_id
  WHERE MONTH(a.appointment_time) = input_month
    AND YEAR(a.appointment_time) = input_year
  GROUP BY d.id
  ORDER BY total_patients DESC
  LIMIT 1;
END $$

DELIMITER ;
