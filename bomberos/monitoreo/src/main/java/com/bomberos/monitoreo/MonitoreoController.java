package com.bomberos.monitoreo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoreo")
public class MonitoreoController {

    @Autowired
    private MonitoreoRepository monitoreoRepository;

    // Obtener todos los puntos de monitoreo
    @GetMapping
    public List<ZonaMonitoreo> listarTodo() {
        return monitoreoRepository.findAll();
    }

    // Crear un nuevo punto de monitoreo (coordenadas de incendio, etc)
    @PostMapping
    public ZonaMonitoreo guardar(@RequestBody ZonaMonitoreo monitoreo) {
        return monitoreoRepository.save(monitoreo);
    }
}