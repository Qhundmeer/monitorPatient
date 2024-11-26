package com.monitorPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitorPatient.dto.HeartRate;

public interface HeartRateRepository extends JpaRepository<HeartRate, Long> {
}

