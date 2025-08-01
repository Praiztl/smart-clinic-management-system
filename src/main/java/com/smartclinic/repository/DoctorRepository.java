package main.java.com.smartclinic.repository;

import main.java.com.smartclinic.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    @Query("SELECT d FROM Doctor d WHERE LOWER(d.fullName) LIKE LOWER(CONCAT('%', :search, '%')) OR LOWER(d.specialty) LIKE LOWER(CONCAT('%', :search, '%'))")
    List<Doctor> searchDoctors(String search);
}
