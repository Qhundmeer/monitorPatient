package com.monitorPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitorPatient.dto.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

