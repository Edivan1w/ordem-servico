package br.com.edivan.app.controllers.exceptions;

import java.io.Serializable;

public class FieldMesage implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String fieldMesage;
	private String mesage;
	
	public FieldMesage() {}
	public FieldMesage(String fieldMesage, String mesage) {
		super();
		this.fieldMesage = fieldMesage;
		this.mesage = mesage;
	}
	public String getFieldMesage() {
		return fieldMesage;
	}
	public void setFieldMesage(String fieldMesage) {
		this.fieldMesage = fieldMesage;
	}
	public String getMesage() {
		return mesage;
	}
	public void setMesage(String mesage) {
		this.mesage = mesage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
