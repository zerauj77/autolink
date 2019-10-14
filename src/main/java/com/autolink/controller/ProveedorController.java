package com.autolink.controller;

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
		return proveedorRepository.save(prov);
	}
	
	public Proveedor findByproveedor(String proveedor){
		return proveedorRepository.findByNombre(proveedor);
	}
	
	public Proveedor changeEstado(String proveedor, boolean estado){
		Proveedor ase = this.proveedorRepository.findByNombre(proveedor);
		ase.setEstado(estado);
		return proveedorRepository.save(ase);
		
	}


}
