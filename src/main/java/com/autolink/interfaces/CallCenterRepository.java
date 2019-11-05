package com.autolink.interfaces;

import java.math.BigDecimal;

import org.springframework.data.repository.CrudRepository;

import com.autolink.model.CallCenter;

public interface CallCenterRepository extends CrudRepository<CallCenter, BigDecimal> {

	public CallCenter findByNombre(String nombre);


}
