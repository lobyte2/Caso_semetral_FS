package com.bomberos.reportes.controller;

import com.bomberos.reportes.model.Reporte;
import com.bomberos.reportes.service.ReporteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteService reporteService;

    @GetMapping
    public List<Reporte> listarReportes() {
        return reporteService.obtenerReportes();
    }

    @PostMapping
    public Reporte crearReporte(@Valid @RequestBody Reporte reporte) {
        return reporteService.crearReporte(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminarReporte(@PathVariable UUID id) {
        reporteService.eliminarReporte(id);
    }
}