package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Reference extends DFA{

	public Reference() {
		this("reference");
	}
	
	public Reference(String name) {
		super(name, 2, 0);
		add(0, 0, '0', '9');
		add(0, 0, 'A', 'Z');
		add(0, 1, '-');
		add(1, 0, 'A', 'Z');
		add(1, 0, '0', '9');
	}

}
