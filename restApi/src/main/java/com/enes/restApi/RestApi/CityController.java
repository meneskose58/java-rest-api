package com.enes.restApi.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enes.restApi.Business.ICityService;
import com.enes.restApi.Entities.City;

@RestController
@RequestMapping("/api")
public class CityController {

	private ICityService cityService;
	
	@Autowired
	public CityController(ICityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/cities")
	public List<City> get(){
		return this.cityService.getAll();
	}
	
	@PostMapping("/add/city")
	public void add(@RequestBody City city) {
		this.cityService.add(city);
	}
	
	@PostMapping("/delete/city")
	public void delete(@RequestBody City city) {
		this.cityService.delete(city);
	}
	
	@PostMapping("/update/city")
	public void update(@RequestBody City city) {
		this.cityService.update(city);
	}
	
	@GetMapping("/cities/{id}")
	public City getById(@PathVariable int id){
		return this.cityService.getById(id);
	}
}
