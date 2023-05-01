package org.patientmanagement.app.controller;

import java.util.List;
import java.util.Optional;

import org.patientmanagement.app.model.PatientModel;
import org.patientmanagement.app.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "pat")
public class PatientController {
	
	@Autowired
	public PatientService service;
	
	
	//Post Drug
	@PostMapping(value="/createPat")
	public String addDrug(@RequestBody PatientModel drug){
		return service.createPat(drug);
	}
	
	
	//Get Drug by Id
	@GetMapping(value = "/getPat")
	public Optional<PatientModel> getDrug(@RequestParam(required = true) int drug_id){
		return service.getPat(drug_id);
	}
	
	
	//Get All Drug
	@GetMapping(value = "/getPats")
	public List<PatientModel> getAllDrug(){
		return service.getAllPats();
	}
	
	
	//Edit Drug
	@PutMapping(value = "/editPat")
	public String updateDrugById(@RequestBody PatientModel drug, @RequestParam(required = true) int id){
		return service.updatePat(drug, id);
	}
	
	
	//Delete Drug
	@DeleteMapping(value = "/deletePat")
	public String deleteDrugByReqParam(@RequestParam int drug_id){
		return service.deletePat(drug_id); 
	}
	
	
	//Ascending Sorting
	@GetMapping(value = "/sortAsc")
	public List<PatientModel> sortAsc(@RequestParam(required = true) String field){
		return service. sortAscending(field);
	}
		
		
	//Descending Sorting
	@GetMapping(value = "/sortDesc")
	public List<PatientModel> sortDesc(@RequestParam(required = true) String field){
		return service. sortDescending(field);
	}
	
	
	//Pagination with sorting
	@GetMapping(value = "/pagination")
	public List<PatientModel> paginationData(@RequestParam(value = "pnu", required = true) int pnu, @RequestParam(value = "psize", required = true) int psize, @RequestParam(value = "field", required = true) String field){
		return service.paginationAndSorting(pnu, psize, field);
	}
}