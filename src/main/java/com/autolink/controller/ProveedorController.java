package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.ProveedorRepository;
import com.autolink.model.Proveedor;

public class ProveedorController {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	public Iterable<Proveedor> getAllproveedores() {
		return proveedorRepository.findAll();
	}
	
	public Proveedor save(Proveedor usu){
		return proveedorRepository.save(usu);
	}
	
	public Proveedor update(Proveedor proveedor){
		Proveedor prov = this.findByproveedor(proveedor.getNombre());
		if(proveedor.getDireccion() != null) {
			prov.setDireccion(proveedor.getDireccion());
		}
		if(proveedor.getCargo() != null) {
			prov.setCargo(proveedor.getCargo());
		}
		if(proveedor.getCuentabancaria() != null) {
			prov.setCuentabancaria(proveedor.getCuentabancaria());
		}
		if(proveedor.getNit() != null) {
			prov.setNit(proveedor.getNit());
		}
		if(proveedor.getRazonsocial() != null) {
			prov.setRazonsocial(proveedor.getDireccion());
		}
		if(proveedor.getTelefono() != null) {
			prov.setTelefono(proveedor.getTelefono());
		}
		if(proveedor.getUsuario() != null) {
			prov.setUsuario(proveedor.getUsuario());
		}
		return proveedorRepository.save(prov);
	}
	
	public Proveedor findByproveedor(String proveedor){
		return proveedorRepository.findByNombre(proveedor);
	}
	
	public Proveedor findByproveedorById(BigDecimal id){
		return proveedorRepository.findById(id).orElse(null);
	}
	
	public Proveedor changeEstado(String proveedor, boolean estado){
		Proveedor ase = this.proveedorRepository.findByNombre(proveedor);
		ase.setEstado(estado);
		return proveedorRepository.save(ase);
		
	}


}
