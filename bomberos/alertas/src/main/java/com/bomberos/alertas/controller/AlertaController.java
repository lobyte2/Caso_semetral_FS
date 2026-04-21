package com.bomberos.alertas.controller;

import com.bomberos.alertas.model.Alerta;
import com.bomberos.alertas.service.AlertasService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertasService alertaService;

    @GetMapping
    public List<Alerta> obtenerAlertas() {
        return alertaService.obtenerAlertas();
    }

    @PostMapping
    public Alerta crearAlerta(@Valid @RequestBody Alerta alerta) {
        return alertaService.crearAlerta(alerta);
    }
}