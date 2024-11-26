package com.monitorPatient.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.monitorPatient.dto.HeartRate;
import com.monitorPatient.dto.Patient;
import com.monitorPatient.repository.HeartRateRepository;
import com.monitorPatient.repository.PatientRepository;

@RestController
@RequestMapping("/api/heart-rates")
public class HeartRateController {

    @Autowired
    private HeartRateRepository heartRateRepository;

    @Autowired
    private PatientRepository patientRepository;

    @PostMapping("/{patientId}")
    public ResponseEntity<HeartRate> recordHeartRate(@PathVariable Long patientId, @RequestBody HeartRate heartRate) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            return new ResponseEntity<HeartRate>(HttpStatus.NOT_FOUND);
        }
        heartRate.setPatient(patient);
        HeartRate savedHeartRate = heartRateRepository.save(heartRate);
        return new ResponseEntity<HeartRate>(savedHeartRate, HttpStatus.OK);
    }

    @GetMapping("/{patientId}")
    public ResponseEntity<List<HeartRate>> getHeartRates(@PathVariable Long patientId) {
        Patient patient = patientRepository.findById(patientId).orElse(null);
        if (patient == null) {
            return new ResponseEntity<List<HeartRate>>(HttpStatus.NOT_FOUND);
        }
        List<HeartRate> heartRates = patient.getHeartRates();
        if (heartRates == null || heartRates.isEmpty()) {
            return new ResponseEntity<List<HeartRate>>(new ArrayList<HeartRate>(), HttpStatus.OK);
        }
        return new ResponseEntity<List<HeartRate>>(heartRates, HttpStatus.OK);
    }
}

