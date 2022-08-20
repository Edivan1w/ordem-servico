package br.com.edivan.app.controllers.exceptions;

import java.util.ArrayList;
import java.util.List;

import br.com.edivan.app.model.StandardError;

public class ValidationErros extends StandardError{

	private static final long serialVersionUID = 1L;
	
	private List<FieldMesage> erros = new ArrayList<FieldMesage>();

	public ValidationErros() {
		super();
	}

	public ValidationErros(Long timesTamp, Integer status, String error) {
		super(timesTamp, status, error);
	}
	
	public List<FieldMesage> getErros() {
		return erros;
	}
	
	public void addError(String fielMesage, String mesage) {
		this.erros.add(new FieldMesage(fielMesage, mesage));
	}
	

}
