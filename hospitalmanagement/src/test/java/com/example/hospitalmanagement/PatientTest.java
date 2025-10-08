package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    public PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){

        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
//        Patient patient = patientRepository.getPatientById(1L);


//        List<Patient> patient = patientRepository.findByName("Diva Patel");
//        System.out.print(patient);

        List<Patient> patientList = patientRepository.findByBirthdateOrEmail(LocalDate.of(1995,8,20), "neha.iyer@example.com");

        for(Patient patient : patientList){
            System.out.println(patient);
       }
    }
}
