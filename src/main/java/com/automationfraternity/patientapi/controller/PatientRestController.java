package com.automationfraternity.patientapi.controller;

import com.automationfraternity.patientapi.model.Patient;
import com.automationfraternity.patientapi.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class PatientRestController {

    @Autowired
    PatientService patientService;

    @PostMapping("/patient")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Patient createPatient(@RequestBody Patient patient){
        return patientService.createNewPatient(patient);
    }

    @GetMapping("/patient")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Patient> getAllPatient(@RequestParam (required = false) String email){
        if(email==null){
            return patientService.getPatient();
        }else{
            return patientService.getPatient(email);
        }

    }

}
