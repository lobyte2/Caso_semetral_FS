package com.bomberos.reportes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteRepository reporteRepository;

    @GetMapping
    public List<Reporte> obtenerTodosLosReportes() {
        return reporteRepository.findAll();
    }

    @PostMapping
    public Reporte crearReporte(@RequestBody Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    @DeleteMapping("/{id}")
    public void eliminarReporte(@PathVariable UUID id) {
        reporteRepository.deleteById(id);
    }
}