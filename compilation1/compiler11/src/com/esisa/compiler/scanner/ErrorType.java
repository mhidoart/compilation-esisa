package com.esisa.compiler.scanner;

public enum ErrorType {
	LEXICAL("Erreur lexical"),
	SYNTACTIC("Erreur syntaxique"),
	SEMANTIC("Erreur sémantique");
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private String name;

	private ErrorType(String name) {
		this.name = name;
	}
	
}
