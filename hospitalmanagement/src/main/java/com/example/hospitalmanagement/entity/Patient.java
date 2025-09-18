package com.example.hospitalmanagement.entity;

import com.example.hospitalmanagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient",
        uniqueConstraints = {
                @UniqueConstraint(name = "unique_Patient_email", columnNames = {"emails"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthdate"})
        },
        indexes = {
                @Index(name = "idx_patient_birth_date", columnList = "birthdate")
        }
)
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthdate;

    private String email;

    private String gender;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;
}
