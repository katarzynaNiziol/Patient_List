package com.luv2code.springboot.thymeleafdemo.service;

import java.util.List;

import com.luv2code.springboot.thymeleafdemo.entity.Patient;

public interface PatientService {

	public List<Patient> findAll();
	
	public Patient findById(int theId);
	
	public void save(Patient thePatient);
	
	public void deleteById(int theId);
	
}
