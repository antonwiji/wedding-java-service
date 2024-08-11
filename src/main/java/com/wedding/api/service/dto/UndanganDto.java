package com.wedding.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UndanganDto {

    private Integer idUndangan;

    private boolean delFlag;

    private List<ValueUndanganDto> content;

}
