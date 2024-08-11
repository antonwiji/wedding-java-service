package com.wedding.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ValueUndanganDto {

    private String component;
    private String props;
    private String value;
    private LocalDateTime createdAt;

}
