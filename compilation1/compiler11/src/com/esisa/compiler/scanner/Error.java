package com.esisa.compiler.scanner;

public class Error {
	private int id;
	private  ErrorType type;
	private Object symbole;
	private int position;
	
	public Error(int id, ErrorType type, Object symbole, int position) {
		super();
		this.id = id;
		this.type = type;
		this.symbole = symbole;//unit
		this.position = position;
	}

	public Error() {
	}
	public String getMessage() {
		String message=type.getName()+ "N° "+id
				+"sur le symbole: '"+ symbole +"' a la position : " + position;
		return message;
	}
	
}
