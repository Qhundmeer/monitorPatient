package com.monitorPatient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.monitorPatient.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
