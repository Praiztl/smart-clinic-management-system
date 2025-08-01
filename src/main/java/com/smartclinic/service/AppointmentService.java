package main.java.com.smartclinic.service;

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
        if (appointment.getAppointmentTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Appointment time cannot be in the past.");
        }
        return appointmentRepository.save(appointment);
    }

    public Appointment updateAppointment(Long id, Appointment updatedAppointment) {
        Appointment existing = appointmentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Appointment not found"));

        existing.setAppointmentTime(updatedAppointment.getAppointmentTime());
        existing.setStatus(updatedAppointment.getStatus());
        return appointmentRepository.save(existing);
    }

    public void cancelAppointment(Long id) {
        if (!appointmentRepository.existsById(id)) {
            throw new RuntimeException("Appointment not found.");
        }
        appointmentRepository.deleteById(id);
    }
}
