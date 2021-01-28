package com.esisa.compiler.scanner;

public class Token {

	private String value; // lexeme
	private String lexicalUnit; //unite lexicale
	
	public Token() 
	{
		
	}

	public Token(String value, String lexicalUnit) {
		super();
		this.value = value;
		this.lexicalUnit = lexicalUnit;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLexicalUnit() {
		return lexicalUnit;
	}

	public void setLexicalUnit(String lexicalUnit) {
		this.lexicalUnit = lexicalUnit;
	}

	@Override
	public String toString() {
		return "(" + value + "," + lexicalUnit + ")";
	}
	public boolean equals(String terminal)
	{
		if ( value.equals(terminal)) return true;
		if ( lexicalUnit.equals(terminal)) return true;
		return false;
	}

}
