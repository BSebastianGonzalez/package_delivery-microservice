package com.example.package_delivering.service;

import com.example.package_delivering.model.Paquete;
import com.example.package_delivering.repository.PaqueteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaqueteService {

    private final PaqueteRepository paqueteRepository;

    public void crearPaquete(Long clienteId, String email) {
        Paquete paquete = new Paquete();
        paquete.setClienteId(clienteId);
        paquete.setEmail(email);
        paquete.setTrackingNumber(generarTracking());
        paquete.setEstado("Pendiente");
        paqueteRepository.save(paquete);
        System.out.println("📦 Entrega creada para cliente: " + email + " con tracking: " + paquete.getTrackingNumber());
    }

    private String generarTracking() {
        return "PKG-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    @Scheduled(fixedRate = 20000)
    public void actualizarEstados() {
        List<Paquete> paquetes = paqueteRepository.findAll();
        for (Paquete p : paquetes) {
            switch (p.getEstado()) {
                case "Pendiente" -> p.setEstado("En preparación");
                case "En preparación" -> p.setEstado("En tránsito");
                case "En tránsito" -> p.setEstado("Entregado");
                default -> {}
            }
        }
        paqueteRepository.saveAll(paquetes);
    }
}