package com.wedding.api.service.service;

import com.wedding.api.service.dto.UndanganDto;
import com.wedding.api.service.dto.UndanganDtoGrup;
import com.wedding.api.service.dto.ValueUndanganDto;
import com.wedding.api.service.entity.UndanganEntity;
import com.wedding.api.service.entity.ValueUndanganEntity;
import com.wedding.api.service.repository.UndanganRepository;
import com.wedding.api.service.repository.ValueUndanganRepository;
import com.wedding.api.service.utils.GenerateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UndanganService {
    @Autowired
    private UndanganRepository undanganRepository;
    @Autowired
    private ValueUndanganRepository valueUndanganRepository;
    @Autowired
    private GenerateResponse generateResponse;

    public ResponseEntity<UndanganDto> getAllUndangan() {
        try {
            List<UndanganEntity> undanganData = undanganRepository.findAll();

            List<UndanganDto> undanganDtoBuilderStream = undanganData.stream().map(undanganEntity ->
                    UndanganDto.builder()
                            .idUndangan(undanganEntity.getIdUndanganContent())
                            .delFlag(undanganEntity.isDelFlag())
                            .content(mapToDTO(undanganEntity.getValueUndanganEntity()))
                            .build()
            ).toList();

            return generateResponse.generate(undanganDtoBuilderStream, HttpStatus.OK, "Success");
        } catch (Exception err) {
            return generateResponse.generate(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "Errors");
        }
    }

    public ResponseEntity<ValueUndanganDto> getValueUndangan() {
        try {

            List<ValueUndanganDto> dtoUndangan = getDtoUndangan();

            return generateResponse.generate(dtoUndangan, HttpStatus.OK, "Success");
        }
        catch (Exception err) {
            return generateResponse.generate(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "Erros");
        }
    }

    public List<ValueUndanganDto> getDtoUndangan() {
        List<ValueUndanganEntity> valueUndanganAll = valueUndanganRepository.findAll();

        List<ValueUndanganDto> valueUndanganDtoStream = valueUndanganAll.stream().map(valueUndanganEntity -> ValueUndanganDto.builder()
                .component(valueUndanganEntity.getComponent().getComponent())
                .props(valueUndanganEntity.getProps().getProps())
                .value(valueUndanganEntity.getValue())
                .createdAt(valueUndanganEntity.getCreated_at())
                .build()
        ).toList();

        return valueUndanganDtoStream;
    }

    private List<Map<String, String>> mapToDTO(List<ValueUndanganEntity> valueUndanganEntities) {
        Map<String, UndanganDtoGrup> map = valueUndanganEntities.stream()
                .collect(Collectors.toMap(
                        valueUndanganEntity -> valueUndanganEntity.getComponent().getComponent(),
                        valueUndanganEntity -> {
                            UndanganDtoGrup dto = new UndanganDtoGrup();
                            dto.setComponent(valueUndanganEntity.getComponent().getComponent());
                            dto.setProperty(valueUndanganEntity.getProps().getProps(), valueUndanganEntity.getValue());
                            return dto;
                        },
                        (existing, replacement) -> {
                            existing.setProperty(replacement.getProperties().keySet().iterator().next(),
                                    replacement.getProperties().values().iterator().next());
                            return existing;
                        }
                ));

        // Mengubah ValueUndanganDto menjadi Map<String, String>
        return map.values().stream()
                .map(dto -> {
                    Map<String, String> resultMap = new HashMap<>();
                    resultMap.put("component", dto.getComponent());
                    resultMap.putAll(dto.getProperties());
                    return resultMap;
                })
                .collect(Collectors.toList());
    }
}
