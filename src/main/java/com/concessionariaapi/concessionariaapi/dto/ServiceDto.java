package com.concessionariaapi.concessionariaapi.dto;

import java.time.LocalDate;

public record ServiceDto(
        String date,
        String Kilometers,
        String description
) {
}
