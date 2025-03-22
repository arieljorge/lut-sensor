package com.elria.lut.api.dto;

import java.time.LocalDateTime;

public class LeituraDto {
    private float mediaLuminosidade;
    private float mediaUmidade;
    private float mediaTemperatura;
    private LocalDateTime dataInicial;
    private LocalDateTime dataFinal;

    // Construtor
    public LeituraDto(float mediaLuminosidade, float mediaUmidade, float mediaTemperatura, LocalDateTime dataInicial,
            LocalDateTime dataFinal) {
        this.mediaLuminosidade = mediaLuminosidade;
        this.mediaUmidade = mediaUmidade;
        this.mediaTemperatura = mediaTemperatura;
        this.dataInicial = dataInicial;
        this.dataFinal = dataFinal;
    }

    public float getMediaLuminosidade() {
        return mediaLuminosidade;
    }

    public void setMediaLuminosidade(float mediaLuminosidade) {
        this.mediaLuminosidade = mediaLuminosidade;
    }

    public float getMediaUmidade() {
        return mediaUmidade;
    }

    public void setMediaUmidade(float mediaUmidade) {
        this.mediaUmidade = mediaUmidade;
    }

    public float getMediaTemperatura() {
        return mediaTemperatura;
    }

    public void setMediaTemperatura(float mediaTemperatura) {
        this.mediaTemperatura = mediaTemperatura;
    }

    public LocalDateTime getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(LocalDateTime dataInicial) {
        this.dataInicial = dataInicial;
    }

    public LocalDateTime getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(LocalDateTime dataFinal) {
        this.dataFinal = dataFinal;
    }
}