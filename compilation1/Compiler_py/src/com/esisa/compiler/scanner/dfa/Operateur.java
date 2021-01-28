package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Operateur extends DFA 

{

	public Operateur() 
	{
		this("operateur");
	}
	public Operateur(String name)
	{
		super(name,7,1,2,3,4,5,6);
		add(0,1, '+');
		add(0, 2, '-');
		add(0, 3, '*');
		add(0,4, '/');
		add(0,5,'%');
		add(0,6,'=');
	}

}
