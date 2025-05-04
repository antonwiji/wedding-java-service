package com.wedding.api.service.controller;

import com.testing.core.utils.utils.CoreUtils;
import com.wedding.api.service.dto.*;
import com.wedding.api.service.entity.UndanganEntity;
import com.wedding.api.service.entity.ValueUndanganEntity;
import com.wedding.api.service.service.PersonService;
import com.wedding.api.service.service.UndanganService;
import com.wedding.api.service.utils.GenerateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UndanganController {
    @Autowired
    private UndanganService undanganService;

    @Autowired
    private GenerateResponse generateResponse;

    @Autowired
    private CoreUtils coreUtils;

    @Autowired
    private PersonService personService;

    @GetMapping("/undangan")
    public ResponseEntity<UndanganDto> getAllUndangan() {
       return undanganService.getAllUndangan();
    }

    @GetMapping("/value")
    public ResponseEntity<ValueUndanganDto> getValueUndangan() {
       return undanganService.getValueUndangan();
    }

    @PostMapping("/testing")
    private ResponseEntity<Object> getTesting(@RequestBody TestingDto testingDto) {
        int incerment = coreUtils.incerment(testingDto.getA(), testingDto.getB());
        System.out.println(incerment);

        return ResponseEntity.ok(incerment);
    }

    @GetMapping("/reload")
    private ResponseEntity<Object> reload() {
        try {
            undanganService.reloadUndangan();
            return ResponseEntity.ok("Success Reload Service");
        }catch (Exception err) {
            return ResponseEntity.internalServerError().body(err.getMessage());
        }
    }

   @PostMapping("/testing/data")
   private ResponseEntity<PersonResDto> savePerson(@RequestBody PersonDto personDto) {

        return personService.savePerson(personDto);
   }


}
