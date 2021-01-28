package com.esisa.compiler.scanner;

public class Error 
{
	private int id;
	private ErrorType type;
	private Object symbol;
	private int position;
	
	public Error() 
	{
		
	}

	public Error(int id, ErrorType type, Object symbol, int position) {
		super();
		this.id = id;
		this.type = type;
		this.symbol = symbol;
		this.position = position;
	}
	public String getMessage()
	{
		//String message = type.getName() +" Num "+ id + " sur le symbole [ " + symbol + " ] a la position  " + position;
		String message = type.getName() +" Num "+ id + " a la position  " + position +" Veuillez corriger le symbole -> " +symbol ;
		return message;
	}

}
