package com.enes.restApi.DataAccess;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.enes.restApi.Entities.City;

@Repository
public class HibernateCityDal implements ICityDal {

	private EntityManager entityManager;
	
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}
	
	

	@Override
	@Transactional
	public List<City> getAll() {	
		Session session= entityManager.unwrap(Session.class);
		List<City> cities= session.createQuery("from City", City.class).getResultList();
		return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		Session session= entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		Session session= entityManager.unwrap(Session.class);
		session.saveOrUpdate(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		Session session= entityManager.unwrap(Session.class);
		City cityToDelete=session.get(City.class, city.getId());
		session.delete(cityToDelete);
		
	}



	@Override
	@Transactional
	public City getById(int id) {
		Session session= entityManager.unwrap(Session.class);
		return session.get(City.class,id);
	}

	
}
