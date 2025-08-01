package main.java.com.smartclinic.controller;

import com.smartclinic.model.Prescription;
import com.smartclinic.repository.PrescriptionRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/prescriptions")
public class PrescriptionController {

    @Autowired
    private PrescriptionRepository prescriptionRepository;

    @PostMapping
    public ResponseEntity<?> savePrescription(@Valid @RequestBody Prescription prescription) {
        try {
            Prescription saved = prescriptionRepository.save(prescription);
            return ResponseEntity.ok(saved);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body("Error saving prescription: " + e.getMessage());
        }
    }
}
