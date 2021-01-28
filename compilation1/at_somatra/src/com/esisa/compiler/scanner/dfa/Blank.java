package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Blank extends DFA{
	public Blank(String name) {
		super(name,2, 1); 
		add(0, 1, " \t\n\r");
		add(1, 1, " \t\n\r");
	}
	public Blank() {
		this("Blank");
	}
}
