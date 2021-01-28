package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Verbfr extends DFA{

	public Verbfr() {
		this("verbe");
	}
	
	public Verbfr(String name) {
		super(name, 3, 2);
		add(0, 1, 'a', 'z');
		add(0, 1, 'A', 'Z');
		add(1, 2, "er");
		add(2, 3, ' ');
		//add(3, 0, ' ');
	}

}
