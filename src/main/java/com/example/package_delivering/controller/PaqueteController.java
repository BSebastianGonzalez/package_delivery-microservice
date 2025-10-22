package com.example.package_delivering.controller;

import com.example.package_delivering.model.Paquete;
import com.example.package_delivering.repository.PaqueteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class PaqueteController {

    private final PaqueteRepository paqueteRepository;

    @GetMapping("/{email}")
    public Paquete getPaqueteByEmail(@PathVariable String email) {
        return paqueteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("No se encontró entrega para este cliente"));
    }
}