package com.bomberos.alertas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/alertas")
public class AlertaController {

    @Autowired
    private AlertaRepository alertaRepository;

    @GetMapping
    public List<Alerta> obtenerAlertas() {
        return alertaRepository.findAll();
    }

    @PostMapping
    public Alerta crearAlerta(@RequestBody Alerta alerta) {
        return alertaRepository.save(alerta);
    }
}