package com.example.teste.status;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EventoNotFoundException extends RuntimeException {

	private String eventoName;
	private String fieldName;
	private Object fieldValue;

	public EventoNotFoundException(String eventoName, String fieldName, Object fieldValue) {
		super(String.format("%s not found with %s : '%s'", eventoName, fieldName, fieldValue));
		this.eventoName = eventoName;
		this.fieldName = fieldName;
		this.fieldValue = fieldValue;
	}

	public String getEventoName() {
		return eventoName;
	}

	public void setEventoName(String eventoName) {
		this.eventoName = eventoName;
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
