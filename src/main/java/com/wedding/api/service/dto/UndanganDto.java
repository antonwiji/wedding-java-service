package com.wedding.api.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UndanganDto {

    private Integer idUndangan;

    private boolean delFlag;

    private List<Map<String, String>> content;

}
