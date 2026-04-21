package com.bomberos.historial.controller;

import com.bomberos.historial.model.Historial;
import com.bomberos.historial.service.HistorialService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialService historialService;

    @GetMapping
    public List<Historial> listar() {
        return historialService.listar();
    }

    // Nuevo endpoint para crear un registro en el historial
    @PostMapping
    public Historial guardar(@Valid @RequestBody Historial historial) {
        return historialService.guardar(historial);
    }
}