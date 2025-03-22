package com.elria.lut.api.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.elria.lut.api.Repository.SensorRepository;
import com.elria.lut.api.dto.LeituraDto;
import com.elria.lut.api.entities.Leitura;

@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    public ResponseEntity<List<Leitura>> buscarLeituras() {
        List<Leitura> leituras = sensorRepository.findAll();
        return ResponseEntity.ok(leituras);
    }

    public ResponseEntity<Leitura> buscarLeituraPorData(@RequestParam LocalDateTime data, @RequestParam Long sensorId) {
        Optional<Leitura> leitura = sensorRepository.findBySensorId(sensorId).stream()
                .filter(l -> l.getData().equals(data)) // Filtra pela data também, se necessário
                .findFirst();
        return leitura.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<LeituraDto> buscarDadosEspecificos(LocalDateTime inicio, LocalDateTime fim) {
        List<Leitura> leituras = sensorRepository.findByDataBetween(inicio, fim);

        if (leituras.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        double mediaLuminosidade = leituras.stream().mapToDouble(Leitura::getLuminosidade).average().orElse(0);
        double mediaUmidade = leituras.stream().mapToDouble(Leitura::getUmidade).average().orElse(0);
        double mediaTemperatura = leituras.stream().mapToDouble(Leitura::getTemperatura).average().orElse(0);

        LeituraDto dto = new LeituraDto((float) mediaLuminosidade, (float) mediaUmidade, (float) mediaTemperatura,
                inicio, fim);

        return ResponseEntity.ok(dto);
    }

    public void buscarDadosArduino() {
        // Implementação futura para integração com o Arduino
    }
}