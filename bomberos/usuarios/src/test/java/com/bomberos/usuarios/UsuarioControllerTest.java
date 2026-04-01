package com.bomberos.usuarios;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class) // Habilita el uso de Mockito
class UsuarioControllerTest {

    @Mock
    private UsuarioRepository usuarioRepository; // Crea un simulacro del repositorio

    @InjectMocks
    private UsuarioController usuarioController; // Inyecta el mock en el controlador

    @Test
    void testObtenerTodosLosUsuarios() {
        // 1. Configuración (GIVEN)
        Usuario user1 = new Usuario();
        user1.setNombre("Juan");
        Usuario user2 = new Usuario();
        user2.setNombre("Pedro");

        // Definimos qué debe devolver el mock cuando se llame a findAll()
        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(user1, user2));

        // 2. Ejecución (WHEN)
        List<Usuario> resultado = usuarioController.obtenerTodosLosUsuarios();

        // 3. Verificación (THEN)
        assertNotNull(resultado);
        assertEquals(2, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());

        // Verifica que el método del repositorio se llamó exactamente una vez
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void testCrearUsuario() {
        Usuario nuevoUsuario = new Usuario();
        nuevoUsuario.setNombre("Maria");

        when(usuarioRepository.save(any(Usuario.class))).thenReturn(nuevoUsuario);

        Usuario resultado = usuarioController.crearUsuario(nuevoUsuario);

        assertEquals("Maria", resultado.getNombre());
        verify(usuarioRepository).save(nuevoUsuario);
    }
}