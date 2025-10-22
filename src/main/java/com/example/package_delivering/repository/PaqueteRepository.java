package com.example.package_delivering.repository;

import com.example.package_delivering.model.Paquete;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    Optional<Paquete> findByEmail(String email);
}
