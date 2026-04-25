package com.bomberos.usuarios.controller;

import com.bomberos.usuarios.model.Usuario;
import com.bomberos.usuarios.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioRepository.findAll();
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable UUID id) {
        usuarioRepository.deleteById(id);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUsuario(@RequestBody Map<String, String> credenciales) {
        String email = credenciales.get("email");
        String password = credenciales.get("password");

        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(email);

        // Verificamos si existe el usuario y si la contraseña coincide
        if (usuarioOpt.isPresent() && usuarioOpt.get().getPassword().equals(password)) {
            return ResponseEntity.ok(usuarioOpt.get());
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
    }
}