package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Appointment;
import com.example.hospitalmanagement.entity.Insurance;
import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.service.AppointmentService;
import com.example.hospitalmanagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTests {

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testInsurance(){
        Insurance insurance = Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("HDFC")
                .validUntil(LocalDate.of(2030,12,12))
                .build();

        Patient patient = insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient = insuranceService.dissociateInsuranceFromPatient(patient.getId());

        System.out.println(newPatient);
    }

    @Test
    public void testCreateAppointment(){
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,12,12,14,0))
                .reason("CANCER")
                .build();

        var newappointment = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(newappointment);

        var updatedAppointment = appointmentService.reAssignAppointmentToAnotherDoctor(newappointment.getId(),3L);

        System.out.println(updatedAppointment);
    }
}
