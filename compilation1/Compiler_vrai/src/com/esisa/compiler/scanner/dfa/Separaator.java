package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Separaator extends DFA{

	public Separaator() {
		
		this("Separator");
	}
	
	public Separaator(String name)
	{
		super(name, 2, 1);
		add(0,1, ",;{}[]().");
	}
	
}

