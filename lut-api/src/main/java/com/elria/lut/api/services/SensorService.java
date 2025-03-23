package com.elria.lut.api.services;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.elria.lut.api.repositories.SensorRepository;
import com.elria.lut.api.entities.Leitura;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
@AllArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;

    public ResponseEntity<List<Leitura>> buscarLeituras(LocalDate data) {
        if (data == null) return ResponseEntity.ok(sensorRepository.findAll());

        return ResponseEntity.ok(sensorRepository.findByData(data));
    }

    public ResponseEntity<List<Leitura>> buscarLeiturasPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return ResponseEntity.ok(sensorRepository.findByDataBetween(dataInicial, dataFinal));
    }

    public ResponseEntity<Leitura> inserirLeitura(Leitura leitura) {
        leitura.setTempo(LocalTime.now());
        leitura.setData(LocalDate.now());

        return  ResponseEntity.ok(sensorRepository.save(leitura));
    }

    @Scheduled(fixedRate = 3600000)
    public void buscarDadosArduino() {
        // Implementação futura para integração com o Arduino
    }
}