package com.bomberos.monitoreo.service;

import com.bomberos.monitoreo.model.ZonaMonitoreo;
import com.bomberos.monitoreo.repository.MonitoreoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonitoreoService {

    @Autowired
    private MonitoreoRepository monitoreoRepository;

    public List<ZonaMonitoreo> listarTodo() {
        return monitoreoRepository.findAll();
    }

    public ZonaMonitoreo guardar(ZonaMonitoreo monitoreo) {
        return monitoreoRepository.save(monitoreo);
    }
}