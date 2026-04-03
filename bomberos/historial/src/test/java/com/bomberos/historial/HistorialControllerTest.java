package com.bomberos.historial;

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
class HistorialControllerTest {

    @Mock
    private HistorialRepository historialRepository;

    @InjectMocks
    private HistorialController historialController;

    @Test
    void testObtenerHistoriales() {
        Historial h1 = new Historial();
        Historial h2 = new Historial();

        when(historialRepository.findAll()).thenReturn(Arrays.asList(h1, h2));

        List<Historial> resultado = historialController.listar();
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(historialRepository, times(1)).findAll();
    }
}