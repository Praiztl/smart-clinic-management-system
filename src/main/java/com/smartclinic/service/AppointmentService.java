package main.java.com.smartclinic.service;

import main.java.com.smartclinic.dto.AppointmentDTO;
import main.java.com.smartclinic.model.Appointment;
import main.java.com.smartclinic.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    public List<Appointment> getAppointmentsForDoctor(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    public Appointment createAppointment(Appointment appointment) {
        // Optional: validate date not in the past
        if (appointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time cannot be in the past.");
        }
        return appointmentRepository.save(appointment);
    }

    // Add more methods for update, cancel, etc. as needed
}
