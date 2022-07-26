package com.devsuperior.dscatalog.services.execptions;

public class ResourcesNotFoundExceptions extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourcesNotFoundExceptions(String msg) {
		super(msg);
	}

}
