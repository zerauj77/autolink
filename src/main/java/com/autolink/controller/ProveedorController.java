package com.autolink.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.autolink.interfaces.ProveedorRepository;
import com.autolink.interfaces.UsuarioRepository;
import com.autolink.model.Proveedor;
import com.autolink.model.Usuarios;
import com.autolink.request.ProveedorInsert;

public class ProveedorController {
	
	@Autowired
	ProveedorRepository proveedorRepository;
	
	@Autowired
	UsuarioRepository usuRepository;
	
	public Iterable<Proveedor> getAllproveedores() {
		return proveedorRepository.findAll();
	}
	
	public Proveedor save(Proveedor usu){
		return proveedorRepository.save(usu);
	}
	
	public Proveedor update(ProveedorInsert proveedor){
		
		Proveedor prov = proveedorRepository.findById(proveedor.getId()).orElse(null);
		if(prov != null) {
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
				Usuarios usu = usuRepository.findByUsuario(proveedor.getUsuario());
				if(usu != null) {
					prov.setUsuario(usu);
				}
				
			}
			if(proveedor.getNombre() !=null) {
				prov.setNombre(proveedor.getNombre());
			}
			if(proveedor.getPorcentajepago() !=null) {
				prov.setPorcentajepago(proveedor.getPorcentajepago());
			}
			return proveedorRepository.save(prov);
		}else {
			return null;
		}
		
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
