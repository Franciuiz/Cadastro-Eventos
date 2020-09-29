package com.example.teste.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {

	private String usuarioName;
	private String fieldName;
	private Object fieldValue;

	public UsuarioNotFoundException(String usuarioName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", usuarioName, fieldName, fieldValue));
		this.usuarioName = usuarioName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getUsuarioName() {
		return usuarioName;
	}

	public void setUsuarioName(String usuarioName) {
		this.usuarioName = usuarioName;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Object getFieldValue() {
		return fieldValue;
	}

	public void setFieldValue(Object fieldValue) {
		this.fieldValue = fieldValue;
	}
	
	
}
