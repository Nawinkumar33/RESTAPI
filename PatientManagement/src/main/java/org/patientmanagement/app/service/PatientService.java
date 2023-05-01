package org.patientmanagement.app.service;

import java.util.List;
import java.util.Optional;

import org.patientmanagement.app.repository.PatientRepo;
import org.patientmanagement.app.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
	
	@Autowired
	public PatientRepo repo;
	
	
	public String createPat(PatientModel drug){
		boolean value = repo.existsById(drug.getPatientId());
	
		if(value == true){
			return "The user already exists. To enter the application please use login";
		}
		else{
			repo.save(drug);
			return "A new user with the details " + drug.toString() + " is created. Login to continue";
		}
	}
	
	
	public Optional<PatientModel> getPat(int id){
		boolean value = repo.existsById(id);
		if(value == true) {
			return repo.findById(id);
		}
		else {
			return null;
		}
	}
	
	
	public List<PatientModel> getAllPats(){
		return repo.findAll();
	}
	
	
	public String updatePat(PatientModel drug, int id){
		boolean value = repo.existsById(id);
		PatientModel dummy = repo.findById(id).orElse(null);
		if(value == true) {
			dummy.setAge(drug.getAge());
			dummy.setCharge(drug.getCharge());
			dummy.setEmail(drug.getEmail());
			dummy.setFirstName(drug.getFirstName());
			dummy.setLastName(drug.getLastName());
			dummy.setPatientId(drug.getPatientId());
			dummy.setPhoneNumber(drug.getPatientId());
			dummy.setPrescription(drug.getPrescription());
			dummy.setProblem(drug.getProblem());
			dummy.setWeight(drug.getWeight());
			
			repo.saveAndFlush(dummy);
			
			return "The drug details was successfully updated in the database";
		}
		else {
			return "The drug details is not present in the database to be updated";
		}
	}
	
	
	public String deletePat(int id){
		PatientModel value = repo.findById(id).orElse(null);
		if(value != null) {
			repo.deleteById(id);
			return "Drug with id " + id + "is not deleted from the database";
		}
		else {
			return "Drug with id " + id + "is not deleted as it's not present in Database";
		}
	}
	
	
	public List<PatientModel> sortAscending(String field){
		return repo.findAll(Sort.by(Direction.ASC, field));
	}
	
	
	public List<PatientModel> sortDescending(String field){
		return repo.findAll(Sort.by(Direction.DESC, field));
	}
	
	
	public List<PatientModel> paginationAndSorting(int pageNumber, int pageSize, String field){
		Page<PatientModel> drug = repo.findAll(PageRequest.of(pageNumber, pageSize, Sort.by(Direction.ASC, field)));
		return drug.getContent();
	}
}