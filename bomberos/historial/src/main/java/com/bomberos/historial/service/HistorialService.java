package com.bomberos.historial.service;

import com.bomberos.historial.model.Historial;
import com.bomberos.historial.repository.HistorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistorialService {

    @Autowired
    private HistorialRepository repository;

    public List<Historial> listar() {
        return repository.findAll();
    }

    // Nuevo método para guardar un historial
    public Historial guardar(Historial historial) {
        return repository.save(historial);
    }
}