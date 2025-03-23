package com.elria.lut.api.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elria.lut.api.entities.Leitura;

public interface SensorRepository extends JpaRepository<Leitura, Long> {
    List<Leitura> findByData(LocalDate data);
    List<Leitura> findByDataBetween(LocalDate inicio, LocalDate fim);
}