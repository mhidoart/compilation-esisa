package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Identifier extends DFA{
	
	public Identifier(String name) {
		super(name,2, 1); //2 etats
		add(0 , 1, 'a', 'z');
		add(0 , 1, 'A', 'Z');//lettres
		add(0 , 1, '_');
		
		add(1 , 1, 'a', 'z');
		add(1 , 1, 'A', 'Z');
		add(1 , 1, '_');
		
		add(1 , 1, '0', '9');
	}
	
	public Identifier() {
		this("id");
	}
	
	

}
