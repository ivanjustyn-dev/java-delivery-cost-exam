package com.gcash.delivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gcash.delivery.model.Rate;

@Repository
public interface RateRepository extends CrudRepository<Rate,Integer>{
	
	
	public Rate findByType(String type);

}
