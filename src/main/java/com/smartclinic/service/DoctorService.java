package main.java.com.smartclinic.service;

import main.java.com.smartclinic.model.Doctor;
import main.java.com.smartclinic.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    public List<Doctor> findDoctorsBySpecialtyAndAvailability(String specialty, String date) {
        // This is a placeholder; you'd normally filter based on availableTimes and date
        if (specialty != null) {
            return doctorRepository.findBySpecialtyIgnoreCase(specialty);
        } else {
            return doctorRepository.findAll();
        }
    }

    public String validateDoctorLogin(String email, String password) {
        Optional<Doctor> doctorOpt = doctorRepository.findByEmail(email);
        if (doctorOpt.isPresent()) {
            Doctor doctor = doctorOpt.get();
            if (doctor.getPassword().equals(password)) {
                return "Login successful";
            } else {
                return "Invalid password";
            }
        } else {
            return "Doctor not found";
        }
    }
}
