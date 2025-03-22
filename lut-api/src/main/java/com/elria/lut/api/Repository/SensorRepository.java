package com.elria.lut.api.Repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elria.lut.api.entities.Leitura;

public interface SensorRepository extends JpaRepository<Leitura, Long> {
    List<Leitura> findByData(LocalDateTime data); // Pode haver mais de uma leitura no mesmo horário

    List<Leitura> findByDataBetween(LocalDateTime inicio, LocalDateTime fim); // Usa método padrão do Spring Data JPA

    List<Leitura> findBySensorId(Long sensorId);

}