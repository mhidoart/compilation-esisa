package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Operator extends DFA
{

	public Operator()
	{
		this("Operator");
	}
	
	public Operator(String name)
	{
		super(name,2,1);
		add(0,1,"+-*/");
		
		
	}

}
