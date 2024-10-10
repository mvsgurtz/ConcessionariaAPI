package com.concessionariaapi.concessionariaapi.model;

import java.time.LocalDate;

public class Service {
    private LocalDate date;
    private Long Kilometers;
    private String description;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getKilometers() {
        return Kilometers;
    }

    public void setKilometers(Long kilometers) {
        Kilometers = kilometers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
