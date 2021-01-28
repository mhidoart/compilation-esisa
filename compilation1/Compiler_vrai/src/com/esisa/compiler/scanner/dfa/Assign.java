package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Assign extends DFA{

	public Assign() {
		
		this("assign");
	}
	
	public Assign(String name)
	{
		super(name, 2, 1);
		add(0,1, "=");
		
	}
	
}
