package com.elria.lut.api.controllers;

import java.time.LocalDate;
import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import com.elria.lut.api.services.SensorService;
import com.elria.lut.api.entities.Leitura;

@RestController
@RequestMapping("/leituras")
@AllArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<Leitura>> buscarLeituras(
        @RequestParam @Nullable @DateTimeFormat(pattern = "ddMMyyyy") LocalDate data
    ) {
        return sensorService.buscarLeituras(data);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Leitura>> buscarLeiturasPeriodo(
        @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") LocalDate dataInicial,
        @RequestParam @DateTimeFormat(pattern = "ddMMyyyy") LocalDate dataFinal
    ) {
        return sensorService.buscarLeiturasPorPeriodo(dataInicial, dataFinal);
    }

    @PostMapping
    public ResponseEntity<Leitura> inserirLeitura(@RequestBody Leitura leitura) {
        return sensorService.inserirLeitura(leitura);
    }
}