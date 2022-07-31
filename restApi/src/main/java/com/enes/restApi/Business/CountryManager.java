package com.enes.restApi.Business;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.enes.restApi.DataAccess.ICountryDal;
import com.enes.restApi.Entities.Country;

@Service
public class CountryManager implements ICountryService {

	
	private ICountryDal countryDal;
	
	@Autowired
	public CountryManager(ICountryDal countryDal) {
		this.countryDal = countryDal;
	}
	

	@Override
	@Transactional
	public List<Country> getAll() {		
		return this.countryDal.getAll();
	}

	@Override
	@Transactional
	public void add(Country country) {
		this.countryDal.add(country);
		
	}

	@Override
	@Transactional
	public void update(Country country) {
		this.countryDal.update(country);
	}

	@Override
	@Transactional
	public void delete(Country country) {
		this.countryDal.delete(country);		
	}

	@Override
	@Transactional
	public Country getByCode(String code) {
		return this.countryDal.getByCode(code);
	}

}
