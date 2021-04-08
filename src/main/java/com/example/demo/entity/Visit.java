package com.example.demo.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "visit")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    @Column(name = "date")
    private String date;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medical_service_id", referencedColumnName = "id")
    private MedicalService medicalService;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "diagnosis_id", referencedColumnName = "id")
    private Diagnosis diagnosis;

    public Visit() {

    }

    @Override
    public String toString() {
        return "Visit [id=" + id + ", doctor=" + doctor + ", patient=" + patient + ", date=" + date
                + /*", medicalService=" + medicalService +*/ ", diagnosis=" + diagnosis + "]";
    }


}
