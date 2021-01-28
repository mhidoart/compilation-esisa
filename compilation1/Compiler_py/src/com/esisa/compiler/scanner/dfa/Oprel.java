package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Oprel extends DFA
{
	public Oprel()
	{
		this("Oprel");
	}
	public Oprel(String name)
	{
		super(name,4,1,2);
		add(0,1, "<>");
		add(1, 2, '=');
		add(0, 3, "!=");
		add(3,2, '=');
	}
}
