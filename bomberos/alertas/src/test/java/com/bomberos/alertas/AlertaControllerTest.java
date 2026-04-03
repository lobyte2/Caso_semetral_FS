package com.bomberos.alertas;

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
class AlertaControllerTest {

    @Mock
    private AlertaRepository alertaRepository; // Simulamos la BD

    @InjectMocks
    private AlertaController alertaController; // Inyectamos en el controlador

    @Test
    void testObtenerTodasLasAlertas() {
        // 1. GIVEN (Configuración)
        Alerta alerta1 = new Alerta();
        // alerta1.setId(1L); // Activa esto según tus campos reales

        Alerta alerta2 = new Alerta();
        // alerta2.setId(2L);

        when(alertaRepository.findAll()).thenReturn(Arrays.asList(alerta1, alerta2));

        // 2. WHEN (Ejecución)
        List<Alerta> resultado = alertaController.obtenerAlertas(); // Cambia el nombre del método si en tu controller se llama distinto

        // 3. THEN (Verificación)
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(alertaRepository, times(1)).findAll();
    }

    @Test
    void testCrearAlerta() {
        Alerta nuevaAlerta = new Alerta();

        when(alertaRepository.save(any(Alerta.class))).thenReturn(nuevaAlerta);

        Alerta resultado = alertaController.crearAlerta(nuevaAlerta); // Cambia el nombre del método si en tu controller se llama distinto

        assertNotNull(resultado);
        verify(alertaRepository).save(nuevaAlerta);
    }
}