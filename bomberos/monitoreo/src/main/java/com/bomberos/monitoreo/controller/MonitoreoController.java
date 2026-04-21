package com.bomberos.monitoreo.controller;

import com.bomberos.monitoreo.model.ZonaMonitoreo;
import com.bomberos.monitoreo.service.MonitoreoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/monitoreo")
public class MonitoreoController {

    @Autowired
    private MonitoreoService monitoreoService;

    // Obtener todos los puntos de monitoreo
    @GetMapping
    public List<ZonaMonitoreo> listarTodo() {
        return monitoreoService.listarTodo();
    }

    // Crear un nuevo punto de monitoreo (¡Ahora con @Valid!)
    @PostMapping
    public ZonaMonitoreo guardar(@Valid @RequestBody ZonaMonitoreo monitoreo) {
        return monitoreoService.guardar(monitoreo);
    }
}