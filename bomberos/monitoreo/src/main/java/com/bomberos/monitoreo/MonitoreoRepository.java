package com.bomberos.monitoreo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonitoreoRepository extends JpaRepository<ZonaMonitoreo, Long> {
}