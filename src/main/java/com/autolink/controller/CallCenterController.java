package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.CallCenterRepository;
import com.autolink.model.CallCenter;

public class CallCenterController {

	@Autowired
	CallCenterRepository callCenterRepository;
	
	public Iterable<CallCenter> getAllCallCenteres() {
		return callCenterRepository.findAll();
	}
	
	public CallCenter save(CallCenter usu){
		return callCenterRepository.save(usu);
	}
	
	public CallCenter findBycallCenter(String callCenter){
		return callCenterRepository.findByNombre(callCenter);
	}
	
	public CallCenter findBycallCenterId(BigDecimal id){
		return callCenterRepository.findById(id).orElse(null);
	}
	
	public CallCenter changeEstado(String callCenter, boolean estado){
		CallCenter ase = this.callCenterRepository.findByNombre(callCenter);
		ase.setEstado(estado);
		return callCenterRepository.save(ase);
		
	}
	
	public CallCenter update(CallCenter callCenter){
		CallCenter ase = this.callCenterRepository.findById(callCenter.getId()).orElse(null);
		if(ase != null) {
			if(callCenter.getTelefono() != null) {
				ase.setTelefono(callCenter.getTelefono());
			}
			if(callCenter.getRazonsocial() != null) {
				ase.setRazonsocial(callCenter.getRazonsocial());
			}
			if(callCenter.getCargo() != null) {
				ase.setCargo(callCenter.getCargo());
			}
			if(callCenter.getUsuario() != null) {
				ase.setUsuario(callCenter.getUsuario());
			}
			if(callCenter.getNombre() !=null) {
				ase.setNombre(callCenter.getNombre());
			}
			return callCenterRepository.save(ase);
		}else {
			return null;
		}
		
	}


}
