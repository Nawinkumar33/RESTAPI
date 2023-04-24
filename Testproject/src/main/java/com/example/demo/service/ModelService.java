package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Model;
import com.example.demo.repository.ModelRepository;

@Service
public class ModelService {
	 @Autowired
	 ModelRepository mr;
	 public List<Model> getall(){
		 return mr.findAll(); 
	 }
	public Model saveall(Model Id) {
		return mr.save(Id);
	}
}





