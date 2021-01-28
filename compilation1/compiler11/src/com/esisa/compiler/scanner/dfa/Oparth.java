package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Oparth extends DFA{
	public Oparth(String name) {
		super(name,5, 1); 
		add(0, 1, "+");
		add(0, 1, "-");
		add(0, 1, "*");
		add(0, 1, "/");
		add(0, 1, "%");
		
	}
	public Oparth() {
		this("Oparth");
	}

}
