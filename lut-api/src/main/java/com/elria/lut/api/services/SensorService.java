package com.elria.lut.api.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fazecast.jSerialComm.SerialPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.elria.lut.api.repositories.SensorRepository;
import com.elria.lut.api.entities.Leitura;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Slf4j
@Service
public class SensorService {

    private final SensorRepository sensorRepository;

    @Value("${myapp.portaSerial}")
    private String portaSerial;

    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

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

    @Scheduled(fixedRateString = "${myapp.intervaloLeitura}")
    public void buscarDadosArduino() {
        SerialPort serialPort = SerialPort.getCommPort(portaSerial);
        serialPort.setBaudRate(9600);

        if (serialPort.openPort()) {
            System.out.print("Recebendo leitura do Arduino... ");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(serialPort.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println("Dados recebidos!");
                    // Mapeando o JSON String vindo do Arduino para a classe e inserindo no banco
                    inserirLeitura(new ObjectMapper().readValue(line, Leitura.class));
                }
            } catch (Exception e) {
                throw new RuntimeException("Erro inesperado ao ler o Arduino.");
            } finally {
                serialPort.closePort();
            }
        } else {
            System.out.println(
                    "Não foi possível se conectar ao Arduino. " +
                    "Tente verificar se a porta serial esta de acordo com a porta usada pelo Arduino."
            );
        }
    }
}