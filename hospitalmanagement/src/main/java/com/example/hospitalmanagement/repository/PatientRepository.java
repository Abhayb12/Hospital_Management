package com.example.hospitalmanagement.repository;

import com.example.hospitalmanagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    Patient getPatientById(long l);

    List<Patient> findByName(String name);
    List<Patient> findByBirthdateOrEmail(LocalDate birthdate, String email);

    @Query("SELECT p FROM Patient p LET JOIN FETCH p.appointment")
    List<Patient> findAllPatientWithAppointment();
}
