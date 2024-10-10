package com.concessionariaapi.concessionariaapi.dto;

public record CarResponseDto(
        String brand,
        String model,
        String manufacturingDate,
        String numberOfKilometers,
        String doors,
        String currency,
        String countOfOwners,
        String price
) {
}
