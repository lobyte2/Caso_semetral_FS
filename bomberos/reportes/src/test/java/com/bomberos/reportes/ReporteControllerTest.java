package com.bomberos.reportes;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class ReporteControllerTest {

    @Mock
    private ReporteRepository reporteRepository;

    @InjectMocks
    private ReporteController reporteController;

    @Test
    void testObtenerTodosLosReportes() {
        Reporte reporte1 = new Reporte();
        Reporte reporte2 = new Reporte();

        when(reporteRepository.findAll()).thenReturn(Arrays.asList(reporte1, reporte2));

        List<Reporte> resultado = reporteController.obtenerTodosLosReportes();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(reporteRepository, times(1)).findAll();
    }
}