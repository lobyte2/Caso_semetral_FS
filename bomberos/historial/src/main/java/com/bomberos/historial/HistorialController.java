package com.bomberos.historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/historial")
public class HistorialController {

    @Autowired
    private HistorialRepository repository;

    @GetMapping
    public List<Historial> listar() {
        return repository.findAll();
    }
}