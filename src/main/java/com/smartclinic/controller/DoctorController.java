package main.java.com.smartclinic.controller;

import com.smartclinic.model.Doctor;
import com.smartclinic.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    // Example: GET /api/doctors/availability?specialty=Cardiology&date=2024-08-01
    @GetMapping("/availability")
    public ResponseEntity<List<Doctor>> getAvailableDoctors(
            @RequestParam(required = false) String specialty,
            @RequestParam(required = false) String date) {

        List<Doctor> availableDoctors = doctorService.findDoctorsBySpecialtyAndAvailability(specialty, date);
        return ResponseEntity.ok(availableDoctors);
    }
}
