package com.example.hospitalmanagement;

import com.example.hospitalmanagement.entity.Patient;
import com.example.hospitalmanagement.repository.PatientRepository;
import com.example.hospitalmanagement.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLOutput;
import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    public PatientRepository patientRepository;

    @Test
    public void testPatientRepository(){

        List<Patient> patientList = patientRepository.findAll();
        System.out.println(patientList);
    }

    @Test
    public void testTransactionMethods(){
        Patient patient = patientRepository.getPatientById(1L);

        System.out.print(patient);
    }
}
