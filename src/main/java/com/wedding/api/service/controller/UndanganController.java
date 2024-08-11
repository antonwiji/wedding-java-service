package com.wedding.api.service.controller;

import com.wedding.api.service.dto.UndanganDto;
import com.wedding.api.service.dto.ValueUndanganDto;
import com.wedding.api.service.entity.UndanganEntity;
import com.wedding.api.service.entity.ValueUndanganEntity;
import com.wedding.api.service.service.UndanganService;
import com.wedding.api.service.utils.GenerateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UndanganController {
    @Autowired
    private UndanganService undanganService;

    @Autowired
    private GenerateResponse generateResponse;

    @GetMapping("/undangan")
    public ResponseEntity<UndanganDto> getAllUndangan() {
       return undanganService.getAllUndangan();
    }

    @GetMapping("/value")
    public ResponseEntity<ValueUndanganDto> getValueUndangan() {
       return undanganService.getValueUndangan();
    }

}
