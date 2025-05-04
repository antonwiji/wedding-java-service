package com.wedding.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PersonDto {
    private Long id;

    private String name;

    private String alamat;

    private Integer umur;
}
