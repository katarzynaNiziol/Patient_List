package com.luv2code.springboot.thymeleafdemo.service;

import com.luv2code.springboot.thymeleafdemo.dao.PatientRepository;
import com.luv2code.springboot.thymeleafdemo.entity.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository thePatientRepository) {

        patientRepository = thePatientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Patient findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);

        Patient thePatient = null;

        if (result.isPresent()) {
            thePatient = result.get();
        } else {
            // we didn't find the patient
            throw new RuntimeException("Did not find patient id - " + theId);
        }

        return thePatient;
    }

    @Override
    public void save(Patient thePatient) {
        if (thePatient.getFirstName().equals("NN")) {
            thePatient.setFirstName("NN");
        }
        patientRepository.save(thePatient);
    }

    @Override
    public void deleteById(int theId) {
        patientRepository.deleteById(theId);
    }

}






