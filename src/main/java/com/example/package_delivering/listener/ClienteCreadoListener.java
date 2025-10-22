package com.example.package_delivering.listener;

import com.example.package_delivering.event.ClienteCreadoEvent;
import com.example.package_delivering.service.PaqueteService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClienteCreadoListener {
    private final PaqueteService entregaService;

    @RabbitListener(queues = "entrega.queue")
    public void onClienteCreado(ClienteCreadoEvent event) {
        System.out.println("Evento recibido en entrega-service: " + event);
        entregaService.crearPaquete(event.getId(), event.getEmail());
    }
}
