package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Model;
import com.example.demo.repository.ModelRepository;
import com.example.demo.service.ModelService;


@RestController
public class ModelController {

	@Autowired
	ModelService is;
	@Autowired
	ModelRepository rs;
	
	@GetMapping("/get")
	public List<Model>getAll(){
		
		return is.getall();
	}
	@GetMapping("/get/{id}")
	public Model getDetailsById(@PathVariable int id)
	{
		return rs.findById(id).orElse(null);
	}
	@PostMapping("/save")
	public String saveall(@RequestBody Model id)
	{
		is.saveall(id);
		return "Id details Saved";
	}
	@DeleteMapping("/delete/{id}")
	public String deletebyId(@PathVariable int id)
	{
		rs.deleteById(id);
		return "id details deleted";
		
	}
	@PutMapping("/put")
	public Model putDetailsById(@RequestBody Model s)
	{
		return rs.save(s);
	}
}