package com.elria.lut.api.Controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.elria.lut.api.Service.SensorService;
import com.elria.lut.api.dto.LeituraDto;
import com.elria.lut.api.entities.Leitura;

@RestController
@RequestMapping("/sensores")
public class SensorController {

    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    @GetMapping("/leituras")
    public ResponseEntity<List<Leitura>> buscarLeituras() {
        return sensorService.buscarLeituras();
    }

    @GetMapping("/leitura")
    public ResponseEntity<Leitura> buscarLeituraPorData(@RequestParam LocalDateTime data, @RequestParam Long sensorId) {
        return sensorService.buscarLeituraPorData(data, sensorId);
    }

    @GetMapping("/dados-especificos")
    public ResponseEntity<LeituraDto> buscarDadosEspecificos(@RequestParam LocalDateTime inicio,
            @RequestParam LocalDateTime fim) {
        return sensorService.buscarDadosEspecificos(inicio, fim);
    }
}