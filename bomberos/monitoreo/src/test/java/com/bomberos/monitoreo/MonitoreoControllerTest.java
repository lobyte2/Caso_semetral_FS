package com.bomberos.monitoreo;

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
class MonitoreoControllerTest {

    @Mock
    private MonitoreoRepository monitoreoRepository;

    @InjectMocks
    private MonitoreoController monitoreoController;

    @Test
    void testObtenerZonas() {
        ZonaMonitoreo zona1 = new ZonaMonitoreo();
        ZonaMonitoreo zona2 = new ZonaMonitoreo();

        when(monitoreoRepository.findAll()).thenReturn(Arrays.asList(zona1, zona2));

        List<ZonaMonitoreo> resultado = monitoreoController.listarTodo();

        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        verify(monitoreoRepository, times(1)).findAll();
    }
}