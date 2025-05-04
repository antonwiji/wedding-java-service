package com.wedding.api.service.service;

import com.wedding.api.service.dto.PersonDto;
import com.wedding.api.service.dto.PersonResDto;
import com.wedding.api.service.repository.UndanganRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private UndanganRepository undanganRepository;

    public ResponseEntity<PersonResDto> savePerson(PersonDto personDto) {

        PersonResDto dataRest = PersonResDto.builder()
                .name(personDto.getName())
                .alamat(personDto.getAlamat())
                .build();

        return ResponseEntity.ok(dataRest);
    }
}
