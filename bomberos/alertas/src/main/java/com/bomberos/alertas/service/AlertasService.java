package com.bomberos.alertas.service;

import com.bomberos.alertas.model.Alerta;
import com.bomberos.alertas.repository.AlertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertasService {

    @Autowired
    private AlertaRepository alertaRepository;

    public List<Alerta> obtenerAlertas() {
        return alertaRepository.findAll();
    }

    public Alerta crearAlerta(Alerta alerta) {
        return alertaRepository.save(alerta);
    }
}