package com.autolink.request;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.autolink.model.Solicitud;

public class FilesRequest implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private MultipartFile file;
	private String codigoSolicitud;
	
	
	
	public String getName() {
		return file.getName();
	}

	public String getOriginalFilename() {
		return file.getOriginalFilename();
	}

	public String getContentType() {
		return file.getContentType();
	}

	public boolean isEmpty() {
		return file.isEmpty();
	}

	public long getSize() {
		return file.getSize();
	}

	public byte[] getBytes() throws IOException {
		return file.getBytes();
	}

	public InputStream getInputStream() throws IOException {
		return file.getInputStream();
	}

	public  Resource getResource() {
		return file.getResource();
	}

	public void transferTo(File dest) throws IOException, IllegalStateException {
		file.transferTo(dest);
	}

	public String getCodigoSolicitud() {
		return codigoSolicitud;
	}

	public void setCodigoSolicitud(String codigoSolicitud) {
		this.codigoSolicitud = codigoSolicitud;
	}

	

	
	
}
