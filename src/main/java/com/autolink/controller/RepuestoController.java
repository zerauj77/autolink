package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.RepuestoRepository;
import com.autolink.model.Repuestos;

public class RepuestoController {
	
		
		@Autowired
		RepuestoRepository repuestoRepository;
		
		public Iterable<Repuestos> getAllrepuestoes() {
			return repuestoRepository.findAll();
		}
		
		public Repuestos save(Repuestos usu){
			return repuestoRepository.save(usu);
		}
		
		public Repuestos update(Repuestos repuesto){
			Repuestos prov = this.findByrepuesto(repuesto.getNombre());
			if(repuesto.getValor() != null) {
				prov.setValor(repuesto.getValor());
			}
			if(repuesto.getNombre() != null) {
				prov.setNombre(repuesto.getNombre());
			}
			return repuestoRepository.save(prov);
		}
		
		public Repuestos findByrepuesto(String repuesto){
			return repuestoRepository.findByNombre(repuesto);
		}
		
		public Repuestos findRepuestoById(BigDecimal id){
			return repuestoRepository.findById(id).orElse(null);
		}
		
		public Repuestos changeEstado(String repuesto, boolean estado){
			Repuestos ase = this.repuestoRepository.findByNombre(repuesto);
			ase.setEstado(estado);
			return repuestoRepository.save(ase);
			
		}


}
