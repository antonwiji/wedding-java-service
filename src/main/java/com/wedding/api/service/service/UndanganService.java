package com.wedding.api.service.service;

import com.wedding.api.service.dto.UndanganDto;
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

import java.util.List;
import java.util.stream.Stream;

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
                            .content(undanganEntity.getValueUndanganEntity().stream().map(valueUndanganEntity ->
                                    ValueUndanganDto.builder()
                                            .value(valueUndanganEntity.getValue())
                                            .props(valueUndanganEntity.getProps().getProps())
                                            .component(valueUndanganEntity.getComponent().getComponent())
                                            .createdAt(valueUndanganEntity.getCreated_at()).build()).toList()
                            ).build()
            ).toList();

            return generateResponse.generate(undanganDtoBuilderStream, HttpStatus.OK, "Success");
        }
        catch (Exception err) {
            return generateResponse.generate(err.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, "Erros");
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
}
