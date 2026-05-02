package com.bomberos.reportes.service;

import com.bomberos.reportes.model.Reporte;
import com.bomberos.reportes.repository.ReporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ReporteService {

    @Autowired
    private ReporteRepository reporteRepository;

    public List<Reporte> obtenerReportes() {
        return reporteRepository.findAll();
    }

    public Reporte crearReporte(Reporte reporte) {
        return reporteRepository.save(reporte);
    }

    public void eliminarReporte(UUID id) {
        reporteRepository.deleteById(id);
    }

    public Reporte actualizarReporte(String id, Reporte reporteActualizado) {
        Reporte reporteExistente = reporteRepository.findById(UUID.fromString(id))
                .orElseThrow(() -> new RuntimeException("Reporte no encontrado con ID: " + id));

        reporteExistente.setDescripcion(reporteActualizado.getDescripcion());
        reporteExistente.setLatitud(reporteActualizado.getLatitud());
        reporteExistente.setLongitud(reporteActualizado.getLongitud());
        reporteExistente.setEstado(reporteActualizado.getEstado());

        return reporteRepository.save(reporteExistente);
    }
}