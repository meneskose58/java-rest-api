package com.enes.restApi.Business;

import java.util.List;
import com.enes.restApi.Entities.Country;

public interface ICountryService {

	List<Country> getAll();
	void add(Country country);
	void update(Country country);
	void delete(Country country);
	Country getByCode(String code);
	
}
