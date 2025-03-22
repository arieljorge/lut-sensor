package com.elria.lut.api.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "leituras")
public class Leitura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private float luminosidade;
    private float umidade;
    private float temperatura;
    private LocalDateTime data;

    // Construtor vazio (necessário para JPA)
    public Leitura() {
    }

    // Construtor completo
    public Leitura(String nome, float luminosidade, float umidade, float temperatura, LocalDateTime data) {
        this.nome = nome;
        this.luminosidade = luminosidade;
        this.umidade = umidade;
        this.temperatura = temperatura;
        this.data = data;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public float getLuminosidade() {
        return luminosidade;
    }

    public float getUmidade() {
        return umidade;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setLuminosidade(float luminosidade) {
        this.luminosidade = luminosidade;
    }

    public void setUmidade(float umidade) {
        this.umidade = umidade;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}