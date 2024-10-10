package com.concessionariaapi.concessionariaapi.dto;

import ch.qos.logback.core.net.ssl.SSL;
import com.concessionariaapi.concessionariaapi.model.Service;

import java.time.LocalDate;
import java.util.List;

public record CarDto(
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String currency,
        String price,
        List<ServiceDto>services,
        String countOfOwners
) {
}
