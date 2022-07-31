package com.enes.restApi.RestApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enes.restApi.Business.ICountryService;
import com.enes.restApi.Entities.Country;

@RestController
@RequestMapping("/api")
public class CountryController {
	
	private ICountryService countryService;
	
	@Autowired
	public CountryController(ICountryService countryService) {
		this.countryService = countryService;
	}
	
	@GetMapping("/countries")
	public List<Country> get(){
		return this.countryService.getAll();
	}
	
	@PostMapping("/add/country")
	public void add(@RequestBody Country country) {
		this.countryService.add(country);
	}
	
	@PostMapping("/delete/country")
	public void delete(@RequestBody Country country) {
		this.countryService.delete(country);
	}
	
	@PostMapping("/update/country")
	public void update(@RequestBody Country country) {
		this.countryService.update(country);
	}
	
	@GetMapping("/countries/{code}")
	public Country getById(@PathVariable String code){
		return this.countryService.getByCode(code);
	}
	
	

}
