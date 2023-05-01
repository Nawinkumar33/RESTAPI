package org.patientmanagement.app.repository;


import org.patientmanagement.app.model.PatientModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepo extends  JpaRepository<PatientModel, Integer> {

}
